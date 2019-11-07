package tiralabyra;

/**
 * Represents a traversable (non-wall) pixel in the input image.
 * @author okraisan
 */
public class Node {
  private final int numNeighbors = 8;
  
  private int[] neighbors;
  
  /**
   * Initializes the Node to have no neighbors.
   */
  public Node() {
    neighbors = new int[numNeighbors];
    
    for (int i = 0; i < neighbors.length; i++) {
      neighbors[i] = -1;
    }
  }
  
  /**
   * Sets one of this node's neighbors to point to an index in the graph.
   * @param whichNeighbor Number (direction) of neighborhood.
   * @param index         Index of the neighbor node in the graph.
   */
  public void setNeighbor(int whichNeighbor, int index) {
    if (whichNeighbor >= 0 && whichNeighbor <= numNeighbors) {
      neighbors[whichNeighbor] = index;
    }
  }
  
  public int[] getNeighbors() {
    return neighbors;
  }
}
