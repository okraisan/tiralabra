package tiralabyra;

/**
 * Solve shortest paths using A* (or Dijkstra, when no heuristics specified).
 */
public class AStar {

  public AStar() {
  }

  /**
   * Solve paths through a connected graph using A*.
   * @param graph The graph to be solved.
   * @param useHeuristics Whether to use remaining euclidean distance as a heuristic.
   * @return Result with solvability flag and backtrack array.
   */
  public SolvedResult solve(ConnectedGraph graph, boolean useHeuristics) {
    // Parent information for each node, for backtracking.
    int[]     parent = new int[graph.size()];

    // The "closed list" of A*
    boolean[] isVisited = new boolean[graph.size()];

    // Path distance from the entry point to each node.
    double[]  traveledDistance = new double[graph.size()];

    for (int i = 0; i < traveledDistance.length; i++) {
      traveledDistance[i] = Double.POSITIVE_INFINITY;
    }
    traveledDistance[graph.getEntryNodeIndex()] = 0;

    MinHeap prioHeap = new MinHeap();
    prioHeap.insert(new PrioNode(graph.getEntryNodeIndex(), 0));

    SolvedResult result = new SolvedResult();
    int numVisited = 1;

    while (prioHeap.size() > 0) {
      PrioNode node = prioHeap.removeMin();
      if (node.getIndex() == graph.getExitNodeIndex()) {
        result.setSolved(true);
        result.setLength(traveledDistance[node.getIndex()]);
        break;
      }

      for (Edge edge : graph.getEdgesFrom(node.getIndex())) {
        int neighborIndex = edge.getNode2();

        if (neighborIndex != -1 && !isVisited[neighborIndex]) {
          double scoreToNeighbor = traveledDistance[node.getIndex()] + edge.getWeight();
          //if (scoreToNeighbor < traveledDistance[neighborIndex]) {
            parent[neighborIndex] = node.getIndex();

            double heuristicRemainingDistance = 0;
            if (useHeuristics) {
              heuristicRemainingDistance = graph.getEuclideanDistanceToExit(neighborIndex);
            }

            prioHeap.insert(
                new PrioNode(neighborIndex, scoreToNeighbor + heuristicRemainingDistance));
            traveledDistance[neighborIndex] = scoreToNeighbor;
            isVisited[neighborIndex] = true;
            numVisited++;

          //}
        }
      }
    }
    result.setParents(parent);
    result.setNumberOfNodesVisited(numVisited);

    return result;
  }

}
