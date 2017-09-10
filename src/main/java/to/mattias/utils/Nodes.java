package to.mattias.utils;

import javafx.scene.Cursor;
import javafx.scene.Node;

import java.util.HashSet;
import java.util.Set;

public final class Nodes {

  private static boolean isDragging = false;
  private static double dX, dY, mouseX, mouseY, nodeX, nodeY;
  private static Set<Node> nodes = new HashSet<>();

  private Nodes() {}

  public static void makeDraggable(Node node) {
    System.out.println("Making " + node + " draggable");
    nodes.add(node);
    addDragListener(node);
  }

  public static void makeScalable(Node node) {
    System.out.println(String.format("Making %s scalable", node));
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
