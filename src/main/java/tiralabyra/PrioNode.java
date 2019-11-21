package tiralabyra;

public class PrioNode implements Comparable<PrioNode> {

  /**
   * Index of this node in the graph.
   */
  private int index;

  /**
   * Total distance to this node from the starting point.
   */
  private double pathDistance;

  /**
   * @param idx Index of this node in the graph.
   * @param dist Total distance to this node from the starting point.
   */
  public PrioNode(final int idx, final double dist) {
    index = idx;
    pathDistance = dist;
  }

  /**
   * @return Index of this node in the graph.
   */
  public int getIndex() {
    return index;
  }

  /**
   * How this node is placed in a priority queue.
   * @return A compareTo value.
   * @param n Another PrioNode.
   */
  public int compareTo(final PrioNode n) {
    if (this.pathDistance < n.pathDistance) {
      return -1;
    } else if (n.pathDistance < this.pathDistance) {
      return 1;
    }
    return 0;
  }

}
