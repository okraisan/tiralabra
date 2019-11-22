package tiralabyra;

public class SolvedResult {

  /**
   * Was the labyrinth successfully solved?
   */
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
   * Results of a labyrinth solve; blank constructor.
   */
  public SolvedResult() {
  }

  /**
   * Results of a labyrinth solve.
   * @param sol Was the labyrinth successfully solved?
   * @param par Backtrack path containing the parent index for each index.
   * @param len Total geometric length of the solution.
   */
  public SolvedResult(final boolean sol, final int[] par, final double len) {
    solved = sol;
    parents = par;
    length = len;
  }

  /**
   * @param sol Was the labyrinth successfully solved?
   */
  public void setSolved(final boolean sol) {
    solved = sol;
  }

  /**
   * @param par Backtrack path containing the parent index for each index.
   */
  public void setParents(final int[] par) {
    parents = par;
  }

  /**
   * @param len Total geometric length of the solution.
   */
  public void setLength(final double len) {
    length = len;
  }

  /**
   * @return Was the labyrinth successfully solved?
   */
  public boolean wasSolved() {
    return solved;
  }

  /**
   * @return Backtrack path containing the parent index for each index.
   */
  public int[] getParents() {
    return parents;
  }

  /**
   * @return Total geometric length of the solution.
   */
  public double getLength() {
    return length;
  }
}
