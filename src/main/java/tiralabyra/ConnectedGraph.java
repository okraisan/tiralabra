package tiralabyra;

public class ConnectedGraph {
  Node[] nodes;
  
  public ConnectedGraph(int size) {
    nodes = new Node[size];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = new Node();
    }
  }
  
  /**
   * Adds a directional neighborhood for two nodes.
   * @param nodeIndex     Index of the originating node in the graph.
   * @param whichNeighbor Number of neighborhood in graph with a known rank.
   * @param neighborIndex Index of the neighbor node in the graph.
   */
  public void addNeighborhood(int nodeIndex, int whichNeighbor, int neighborIndex) {
    if (nodeIndex >= 0 && nodeIndex < nodes.length
        && whichNeighbor >= 0 && whichNeighbor < 4
        && neighborIndex >= 0 && neighborIndex < nodes.length) {
      nodes[nodeIndex].setNeighbor(whichNeighbor, neighborIndex);
    }
  }
  
  public Node getNodeAt(int nodeIndex) {
    // TODO: What happens when out of bounds?
    return nodes[nodeIndex];
  }
}