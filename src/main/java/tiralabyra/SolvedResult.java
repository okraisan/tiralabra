package tiralabyra;

public class SolvedResult {

  private boolean solved = false;

  /**
   * Backtrack path containing the parent index for each index.
   */
  private int[] parents;

  /**
   * Total geometric length of the solution.
   */
  private double length;

  /**
   * How many nodes in total were added to a queue or heap structure.
   */
  private int numberOfNodesVisited;

  private long timeSpent;

  public SolvedResult() {
  }

  /**
   * Results of a labyrinth solve.
   * @param solved Was the labyrinth successfully solved?
   * @param parents Backtrack path containing the parent index for each index.
   * @param length Total geometric length of the solution.
   * @param numvisited Total number of nodes added to a data structure.
   * @param time Number of nanoseconds spent.
   */
  public SolvedResult(boolean solved, int[] parents, double length, int numvisited, long time) {
    this.solved = solved;
    this.parents = parents;
    this.length = length;
    this.numberOfNodesVisited = numvisited;
    this.timeSpent = time;
  }

  public void setSolved(boolean solved) {
    this.solved = solved;
  }

  /**
   * Set a backtrack path containing the parent index for each index.
   */
  public void setParents(int[] parents) {
    this.parents = parents;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public void setTimeSpent(long time) {
    this.timeSpent = time;
  }

  public void setNumberOfNodesVisited(int numvisited) {
    this.numberOfNodesVisited = numvisited;
  }

  public boolean wasSolved() {
    return solved;
  }

  /**
   * Backtrack path containing the parent index for each index.
   */
  public int[] getParents() {
    return parents;
  }

  /**
   * Total geometric length of the solution.
   */
  public double getLength() {
    return length;
  }

  public int getNumberOfNodesVisited() {
    return numberOfNodesVisited;
  }

  public long getTimeSpent() {
    return timeSpent;
  }

  public String toString() {
    String s = "";
    if (wasSolved()) {
      s += String.format("Length:     %.1f px\n", getLength());
      s += String.format("Exec time:  %.1f ms\n", timeSpent / 1000000.0);
      s += String.format("Inserted:   %d nodes\n", getNumberOfNodesVisited());
    } else {
      s += "Labyrinth could not be solved\n";
    }
    return s;
  }
}
