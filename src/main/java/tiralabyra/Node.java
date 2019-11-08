package tiralabyra;

import java.util.*;

/**
 * Represents a traversable (non-wall) pixel in the input image.
 * @author okraisan
 */
public class Node {
  private Set<Integer> neighbors;
  
  /**
   * Initializes the Node to have no neighbors.
   */
  public Node() {
    neighbors = new HashSet<Integer>();
  }
  
  /**
   * Sets one of this node's neighbors to point to an index in the graph.
   * @param index         Index of the neighbor node in the graph.
   */
  public void addNeighbor(int index) {
    neighbors.add(index);
  }
  
  public Set<Integer> getNeighbors() {
    return neighbors;
  }
}
