package tiralabyra;

public class SolvedResult {

  /**
   * Was the labyrinth successfully solved?
   */
  private boolean solved = false;
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
  
  public void setSolved(boolean sol) {
    solved = sol;
  }
  
  public void setParents(int[] par) {
    parents = par;
  }
  
  public boolean wasSolved() {
    return solved;
  }
  
  public int[] getParents() {
    return parents;
  }
}
