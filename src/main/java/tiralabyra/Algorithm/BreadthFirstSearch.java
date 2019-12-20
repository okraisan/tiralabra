package tiralabyra;

public class BreadthFirstSearch {
  /**
   * Solve paths through a connected graph using BFS.
   * @param graph The graph to be solved.
   * @return Result with solvability flag and backtrack array.
   */
  public SolvedResult solve(ConnectedGraph graph) {
    // Parent information for each node, for backtracking.
    int[]     parent = new int[graph.size()];

    // Path distance from the entry point to each node.
    double[]  traveledDistance = new double[graph.size()];

    for (int i = 0; i < traveledDistance.length; i++) {
      traveledDistance[i] = Double.POSITIVE_INFINITY;
    }
    traveledDistance[graph.getEntryNodeIndex()] = 0;

    boolean[] isVisited = new boolean[graph.size()];

    Queue nodeQueue = new Queue();
    nodeQueue.insert(graph.getEntryNodeIndex());
    isVisited[graph.getEntryNodeIndex()] = true;

    SolvedResult result = new SolvedResult();
    int numVisited = 1;

    while (nodeQueue.size() > 0) {
      int nodeIndex = nodeQueue.pop();
      if (nodeIndex == graph.getExitNodeIndex()) {
        result.setSolved(true);
        result.setLength(traveledDistance[nodeIndex]);
        break;
      }

      for (Edge edge : graph.getEdgesFrom(nodeIndex)) {
        int neighborIndex = edge.getNode2();

        if (neighborIndex != -1 && !isVisited[neighborIndex]) {
          isVisited[neighborIndex] = true;
          parent[neighborIndex] = nodeIndex;
          traveledDistance[neighborIndex] = traveledDistance[nodeIndex] + edge.getWeight();
          nodeQueue.insert(neighborIndex);
          numVisited++;
        }
      }
    }
    result.setParents(parent);
    result.setNumberOfNodesVisited(numVisited);

    return result;
  }
}
