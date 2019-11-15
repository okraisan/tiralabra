package tiralabyra;

import java.util.LinkedList;
import java.util.Queue;

public final class Main {

  /**
   * Private constructor for utility class, to satisfy Sun style.
   */
  @SuppressWarnings("unused")
  private Main() {
  }

  /**
   * We start here.
   * @param args Command line parameters.
   */
  public static void main(final String[] args) {

    final int backtrackColor = 0xFFFF0000;
    final String inFileName  = "C:\\Users\\windy\\Pictures\\labyrintti.png";
    final String outFileName = "C:\\Users\\windy\\Pictures\\labyra_out.png";

    Image image = new tiralabyra.Image(inFileName);
    ConnectedGraph graph = new tiralabyra.ConnectedGraph(image);

    // Breadth-first search, just for demonstation.
    boolean[] isVisited = new boolean[image.getNumberOfPixels()];
    int[]     parent    = new int[image.getNumberOfPixels()];

    Queue<Integer> fillQueue = new LinkedList<Integer>();
    fillQueue.add(new Integer(graph.getEntryNodeIndex()));

    while (fillQueue.size() > 0) {
      int nodeIndex = fillQueue.remove();
      if (nodeIndex == graph.getExitNodeIndex()) {
        break;
      }

      for (Edge edge : graph.getEdgesFrom(nodeIndex)) {
        if (edge != null && edge.getNode2() != -1
            && !isVisited[edge.getNode2()]) {
          isVisited[edge.getNode2()] = true;
          parent[edge.getNode2()] = nodeIndex;
          fillQueue.add(edge.getNode2());
        }
      }
    }

    // Backtrack.
    int backtrackIndex = graph.getExitNodeIndex();
    while (backtrackIndex != graph.getEntryNodeIndex()) {
      image.plotPathAroundIndex(backtrackIndex, backtrackColor);
      backtrackIndex = parent[backtrackIndex];
    }

    image.save(outFileName);
  }
}
