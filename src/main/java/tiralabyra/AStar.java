package tiralabyra;

import java.util.PriorityQueue;

public class AStar {

  /**
   * Solve paths through a connected graph using A*.
   */
  public AStar() {
  }

  /**
   * @param graph The graph to be solved.
   * @return Result with solvability flag and parenthood array.
   */
  public AStarResult solve(final ConnectedGraph graph) {
    int[]     parent    = new int[graph.size()];
    double[]  totalDist = new double[graph.size()];

    for (int i = 0; i < totalDist.length; i++) {
      totalDist[i] = Double.POSITIVE_INFINITY;
    }
    totalDist[graph.getEntryNodeIndex()] = 0;

    PriorityQueue<PrioNode> fillQueue = new PriorityQueue<PrioNode>();
    fillQueue.add(new PrioNode(graph.getEntryNodeIndex(), 0));

    AStarResult result = new AStarResult();

    while (fillQueue.size() > 0) {
      PrioNode node = fillQueue.remove();
      if (node.getIndex() == graph.getExitNodeIndex()) {
        result.setSolved(true);
        break;
      }

      for (Edge edge : graph.getEdgesFrom(node.getIndex())) {
        int neighborIndex = edge.getNode2();
        // A valid, ?(non-visited) edge
        if (edge != null && neighborIndex != -1) {
          double neighborsTotalDistance =
              totalDist[node.getIndex()] + edge.getWeight();

          if (neighborsTotalDistance < totalDist[neighborIndex]) {
            parent[neighborIndex] = node.getIndex();
            fillQueue.add(new PrioNode(neighborIndex, neighborsTotalDistance));
            totalDist[neighborIndex] = neighborsTotalDistance;
          }
        }
      }
    }
    result.setParents(parent);

    return result;
  }

}
