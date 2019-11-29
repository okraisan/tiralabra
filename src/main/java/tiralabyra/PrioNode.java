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
   * A graph node that is comparable to other nodes by total distance.
   * @param idx Index of this node in the graph.
   * @param dist Total distance to this node from the starting point.
   */
  public PrioNode(int idx, double dist) {
    index = idx;
    pathDistance = dist;
  }

  public int getIndex() {
    return index;
  }

  /**
   * How this node is placed in a priority queue.
   * @param n Another PrioNode.
   * @return A compareTo value.
   */
  public int compareTo(PrioNode n) {
    if (this.pathDistance < n.pathDistance) {
      return -1;
    } else if (n.pathDistance < this.pathDistance) {
      return 1;
    }
    return 0;
  }

}
