package to.mattias.utils;

import javafx.scene.Scene;

public final class Scenes {

  public static void scalableByMouse(Scene scene) {
    scene.setOnScroll(scroll -> {
      if (scroll.getDeltaY() > 0) {
        scene.getRoot().getChildrenUnmodifiable().forEach(node -> {
          node.setScaleX(node.getScaleX() * 1.1);
          node.setScaleY(node.getScaleY() * 1.1);
          node.setTranslateX(1.1);
          node.setTranslateY(1.1);
        });
      } else if (scroll.getDeltaY() < 0) {
        scene.getRoot().getChildrenUnmodifiable().forEach(node -> {
          node.setScaleX(node.getScaleX() * 0.9);
          node.setScaleY(node.getScaleY() * 0.9);
          node.setTranslateX(0.9);
          node.setTranslateY(0.9);
        });
      }
    });
  }
}
