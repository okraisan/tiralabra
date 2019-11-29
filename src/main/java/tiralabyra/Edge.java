package tiralabyra;

/**
 * Represents an edge between two nodes in a graph, with weight.
 * @author okraisan
 *
 */
public class Edge {

  private double weight;
  private int node1 = -1;
  private int node2 = -1;

  /**
   * An edge between two nodes in a graph, with weight.
   * @param node1 First node of this edge connection.
   * @param node2 Second node of this edge connection.
   * @param weight Edge weight.
   */
  public Edge(int node1, int node2, double weight) {
    this.node1 = node1;
    this.node2 = node2;
    this.weight = weight;
  }

  public int getNode1() {
    return node1;
  }

  public int getNode2() {
    return node2;
  }

  public double getWeight() {
    return weight;
  }
}
