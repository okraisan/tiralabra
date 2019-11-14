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
   * Builds a connected graph based on an input image, with all neighborhoods and input/exit nodes in place.
   * @param image
   */
  public ConnectedGraph(Image image) {
    
  }
  
  /**
   * Adds a bidirectional neighborhood for two nodes.
   * @param nodeIndex     Index of the originating node in the graph.
   * @param neighborIndex Index of the neighbor node in the graph.
   */
  public void addNeighborhood(int nodeIndex, int neighborIndex) {
    if (nodeIndex >= 0 && nodeIndex < nodes.length
        && neighborIndex >= 0 && neighborIndex < nodes.length) {
      nodes[nodeIndex].addNeighbor(neighborIndex);
      nodes[neighborIndex].addNeighbor(nodeIndex);
    }
  }
  
  public Node getNodeAt(int nodeIndex) {
    // TODO: What happens when out of bounds?
    return nodes[nodeIndex];
  }
}
