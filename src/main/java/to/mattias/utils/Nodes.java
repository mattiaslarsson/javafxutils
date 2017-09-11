package to.mattias.utils;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Region;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Nodes {

  private static boolean isDragging = false;
  private static double dX, dY, mouseX, mouseY, nodeX, nodeY;

  private Nodes() {}

  public static void makeDraggable(Node node) {
    addDragListener(node);
  }

  public static void makeScalable(Region parent) {

    List<Node> children = parent.getChildrenUnmodifiable();
    for (int i = children.size() - 1; i >= 0; i--) {
      if (children.get(i).getLayoutBounds().getMaxX() >= parent.getLayoutBounds().getMaxX()) {
        children.forEach(node -> {
          node.setScaleX(0.9);
          node.setScaleY(0.9);
        });
      }
    }
  }

  private static void addDragListener(Node node) {
    node.setOnMousePressed(mC -> {
      node.setCursor(Cursor.MOVE);
      mouseX = mC.getSceneX();
      mouseY = mC.getSceneY();
      nodeX = node.getLayoutX();
      nodeY = node.getLayoutY();
    });

    node.setOnMouseDragged(mD -> {
      isDragging = true;
      dX = mD.getSceneX() - mouseX;
      dY = mD.getSceneY() - mouseY;
      nodeX += dX;
      nodeY += dY;

      node.setLayoutX(nodeX);
      node.setLayoutY(nodeY);

      mouseX = mD.getSceneX();
      mouseY = mD.getSceneY();
    });

    node.setOnMouseReleased(mR -> {
      node.setCursor(Cursor.DEFAULT);
      isDragging = false;
    });
  }
}
