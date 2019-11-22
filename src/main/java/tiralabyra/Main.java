package tiralabyra;

public final class Main {

  /**
   * Private constructor for utility class, to satisfy Sun style.
   */
  @SuppressWarnings("unused")
  private Main() {
  }

  /**
   * Easy alias for System.out.println().
   * @param args Objects to print.
   */
  public static void sop(final Object... args) {
    System.out.println(args[0]);
  }

  /**
   * We start here.
   * @param args Command line parameters.
   */
  public static void main(final String[] args) {

    final int backtrackColor = 0xFFFF0000;
    final String inFileName  = "C:\\Users\\windy\\Pictures\\labyrintti.png";
    final String outFileName = "C:\\Users\\windy\\Pictures\\labyra_out.png";

    Image image = new tiralabyra.Image(inFileName);

    ConnectedGraph graph = new tiralabyra.ConnectedGraph(image);
    AStar astar = new AStar();
    SolvedResult result = astar.solve(graph);

    if (result.wasSolved()) {
      // Backtrack.

      int[] parent = result.getParents();

      int backtrackIndex = graph.getExitNodeIndex();
      while (backtrackIndex != graph.getEntryNodeIndex()) {
        image.plotPathAroundIndex(backtrackIndex, backtrackColor);
        if (parent[backtrackIndex] == backtrackIndex) {
          break;
        }
        backtrackIndex = parent[backtrackIndex];
      }

      System.out.println("Solved; path length " + result.getLength() + " px");
      image.save(outFileName);
    } else {
      System.out.println("This labyrinth can't be solved.");
    }
  }
}
