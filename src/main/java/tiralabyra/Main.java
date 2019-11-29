package tiralabyra;

public final class Main {

  /**
   * We start here.
   */
  public static void main(String[] args) {

    final int backtrackColor = 0xFFFF0000;
    final String inFileName  = "src/main/resources/labyrinth_long.png";
    final String outFileName = "labyra_out.png";

    Image image = new tiralabyra.Image(inFileName);

    ConnectedGraph graph = new tiralabyra.ConnectedGraph(image);
    AStar astar = new AStar();

    long startTime = System.nanoTime();
    SolvedResult result = astar.solve(graph, true);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);

    if (result.wasSolved()) {
      System.out.println("Solved!");
      System.out.println();
      System.out.println("RESULTS\n=======");
      System.out.println(String.format("Input size: %.1f Mpx",
          image.getNumberOfPixels() / 1000000.0));
      System.out.println(String.format("Elapsed:    %.0f ms",
          duration / 1000000.0));

      // Backtrack.

      int[] parent = result.getParents();

      int backtrackIndex = graph.getExitNodeIndex();
      while (backtrackIndex != graph.getEntryNodeIndex()) {
        image.plotPathAroundIndex(backtrackIndex, 1, backtrackColor);
        backtrackIndex = parent[backtrackIndex];
      }

      System.out.println(String.format("Length:     %.1f px", result.getLength()));
      image.save(outFileName);
      System.out.println("Output:     " + outFileName);
    } else {
      System.out.println("This labyrinth can't be solved.");
    }
  }
}
