package tiralabyra;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {

    final int backtrackColor = 0xFFFF0000;
    final String inFileName  = "C:\\Users\\windy\\Pictures\\labyrintti.png";
    final String outFileName = "C:\\Users\\windy\\Pictures\\labyra_out.png";

    Image image = new tiralabyra.Image(inFileName);
    ConnectedGraph graph = new tiralabyra.ConnectedGraph(image);

    // Breadth-first search.
    boolean[] isVisited = new boolean[image.getNumberOfPixels()];
    int[]     parent    = new int[image.getNumberOfPixels()];

    Queue<Integer> fillQueue = new LinkedList<Integer>();
    fillQueue.add(new Integer(entryNodeIndex));

    while (fillQueue.size() > 0) {
      int nodeIndex = fillQueue.remove();
      if (nodeIndex == exitNodeIndex) {
        break;
      }

      for (int neighborIndex : graph.getNodeAt(nodeIndex).getNeighbors()) {
        if (neighborIndex != -1 && !isVisited[neighborIndex]) {
          isVisited[neighborIndex] = true;
          parent[neighborIndex] = nodeIndex;
          fillQueue.add(neighborIndex);
        }
      }
    }

    // Backtrack.
    int backtrackIndex = exitNodeIndex;
    while (backtrackIndex != entryNodeIndex) {
      image.plotPathAroundIndex(backtrackIndex, backtrackColor);
      backtrackIndex = parent[backtrackIndex];
    }

    image.save(outFileName);
  }
}
