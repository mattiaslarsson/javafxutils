package to.mattias.fxparent;

import javafx.application.Application;


public abstract class JavaFXUtils extends Application {

  public abstract void instantiateFields();

  public static void run(JavaFXUtils instance) throws IllegalAccessException {
    Annotations.check(instance);
  }

}
