package tiralabyra;

public class AStarResult {
  
  private boolean solved = false;
  private int[] parents;
  
  public AStarResult() {
    
  }
  
  public AStarResult(boolean sol, int[] par) {
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
