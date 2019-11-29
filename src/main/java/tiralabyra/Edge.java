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
   * @param n1 First node of this edge connection.
   * @param n2 Second node of this edge connection.
   * @param wght Edge weight.
   */
  public Edge(int n1, int n2, double wght) {
    node1 = n1;
    node2 = n2;
    weight = wght;
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
