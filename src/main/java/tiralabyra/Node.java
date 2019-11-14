package tiralabyra;

import java.util.Set;
import java.util.HashSet;

/**
 * Represents a traversable (non-wall) pixel in the input image.
 * @author okraisan
 */
public class Node {
  /**
   * Set of neighbors to this node, as integer indices.
   */
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
  public void addNeighbor(final int index) {
    neighbors.add(index);
  }

  /**
   * Return the set of neighbors to this node.
   *
   * @return Set of indices to neighbor nodes.
   */
  public Set<Integer> getNeighbors() {
    return neighbors;
  }
}
