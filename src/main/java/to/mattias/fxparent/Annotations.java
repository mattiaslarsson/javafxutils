package to.mattias.fxparent;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import to.mattias.annotations.Draggable;
import to.mattias.annotations.Scalable;
import to.mattias.utils.Nodes;
import to.mattias.utils.Scenes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

class Annotations {

  /**
   * Check for annotated fields
   *
   * @param instance Instance of JavaFXUtils extended class
   * @throws IllegalAccessException
   */
  static void check(JavaFXUtils instance) throws IllegalAccessException {

    instance.instantiateFields();
    Field[] fields = instance.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      Annotation[] annotations = field.getDeclaredAnnotations();
      for (Annotation annotation : annotations) {
        try {
          if (annotation instanceof Draggable) {
            Nodes.makeDraggable((Node) field.get(instance));
          } else if (annotation instanceof Scalable) {
            if (((Scalable) annotation).mouse()) {
              Scenes.scalableByMouse((Scene) field.get(instance));
            }
          }
        } catch (IllegalAccessException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
