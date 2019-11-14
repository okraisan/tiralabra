package tiralabyra;

/**
 * Represents an edge between two nodes in a graph, with weight.
 * @author okraisan
 *
 */
public class Edge {

  /**
   * Edge weight.
   */
  private double weight;

  /**
   * First node of this edge connection.
   */
  private int node1;

  /**
   * First node of this edge connection.
   */
  private int node2;

  /**
   * @param n1 First node of this edge connection.
   * @param n2 Second node of this edge connection.
   * @param wght Edge weight.
   */
  public Edge(final int n1, final int n2, final double wght) {
    node1 = n1;
    node2 = n2;
    weight = wght;
  }

  /**
   * @return First node of this edge connection.
   */
  public int getNode1() {
    return node1;
  }

  /**
   * @return Second node of this edge connection.
   */
  public int getNode2() {
    return node2;
  }

  /**
   * @return The node weight.
   */
  public double getWeight() {
    return weight;
  }
}
