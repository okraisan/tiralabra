package tiralabyra;

public class PrioNode implements Comparable<PrioNode> {

  /**
   * Index of this node in the graph.
   */
  private int index;

  /**
   * Total distance to this node from the starting point.
   */
  private double distanceTraveled;

  /**
   * A graph node that is comparable to other nodes by total distance traveled
   * plus an estimate of the remaining path length.
   * @param index Index of this node in the graph.
   * @param distanceTraveled Total distance to this node from the starting point.
   */
  public PrioNode(int index, double distanceTraveled) {
    this.index = index;
    this.distanceTraveled = distanceTraveled;
  }

  public int getIndex() {
    return index;
  }

  /**
   * How this node is placed in a priority queue.
   * @param n Another PrioNode.
   * @return A compareTo value.
   */
  @Override
  public int compareTo(PrioNode n) {
    if (this.distanceTraveled < n.distanceTraveled) {
      return -1;
    } else if (n.distanceTraveled < this.distanceTraveled) {
      return 1;
    }
    return 0;
  }

}
