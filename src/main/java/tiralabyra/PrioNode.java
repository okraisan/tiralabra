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
   * An estimate of the distance to the exit.
   */
  private double distanceLeft;

  /**
   * A graph node that is comparable to other nodes by total distance traveled
   * plus an estimate of the remaining path length.
   * @param index Index of this node in the graph.
   * @param distanceTraveled Total distance to this node from the starting point.
   * @param distanceLeft An estimate of the distance to the exit.
   */
  public PrioNode(int index, double distanceTraveled, double distanceLeft) {
    this.index = index;
    this.distanceTraveled = distanceTraveled;
    this.distanceLeft = distanceLeft;
  }

  public PrioNode(int index, double distanceTraveled) {
    this.index = index;
    this.distanceTraveled = distanceTraveled;
    this.distanceLeft = 0.0;
  }

  public int getIndex() {
    return index;
  }

  public double getEstimatedTotalPathLength() {
    return distanceTraveled + distanceLeft;
  }

  /**
   * How this node is placed in a priority queue.
   * @param n Another PrioNode.
   * @return A compareTo value.
   */
  @Override
  public int compareTo(PrioNode n) {
    if (this.getEstimatedTotalPathLength() < n.getEstimatedTotalPathLength()) {
      return -1;
    } else if (n.getEstimatedTotalPathLength() < this.getEstimatedTotalPathLength()) {
      return 1;
    }
    return 0;
  }

}
