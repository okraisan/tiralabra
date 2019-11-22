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
   * Results of a labyrinth solve; blank constructor.
   */
  public SolvedResult() {
  }

  /**
   * Results of a labyrinth solve.
   * @param sol Was the labyrinth successfully solved?
   * @param par Backtrack path containing the parent index for each index.
   */
  public SolvedResult(final boolean sol, final int[] par) {
    solved = sol;
    parents = par;
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
}
