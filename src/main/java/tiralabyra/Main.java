package tiralabyra;

import java.util.Scanner;

public final class Main {

  /**
   * Solve one maze from an image file and draw the result onto an output image.
   */
  public static void solveAndSave(String inFileName, String outFileName) {
    final int backtrackColor = 0xFFFF0000;

    Image image = new tiralabyra.Image(inFileName);

    ConnectedGraph graph = new tiralabyra.ConnectedGraph(image);
    AStar astar = new AStar();
    SolvedResult result = astar.solve(graph, true);

    if (result.wasSolved()) {
      System.out.println("Solved");

      // Backtrack.
      int[] parent = result.getParents();

      int backtrackIndex = graph.getExitNodeIndex();
      while (backtrackIndex != graph.getEntryNodeIndex()) {
        image.plotPathAroundIndex(backtrackIndex, 1, backtrackColor);
        backtrackIndex = parent[backtrackIndex];
      }

      System.out.println(String.format("Length:     %.1f px", result.getLength()));
      image.save(outFileName);
    } else {
      System.out.println("This labyrinth can't be solved.");
    }
  }

  /**
   * Compare execution times for different algorithms for this input image.
   */
  public static void compareAlgorithms(String inFileName) {
    Image image = new tiralabyra.Image(inFileName);

    ConnectedGraph graph = new tiralabyra.ConnectedGraph(image);
    AStar astar = new AStar();

    long startTime = System.nanoTime();
    SolvedResult result = astar.solve(graph, true);
    long elapsedTime = System.nanoTime() - startTime;

    if (result.wasSolved()) {
      System.out.println("Solved");
      System.out.println(String.format("Length:     %.1f px", result.getLength()));
      System.out.println(String.format("Exec time:  %.1f ms", elapsedTime / 1000000.0));
    } else {
      System.out.println("This labyrinth can't be solved.");
    }
  }

  static void showMenu() {
    Scanner userInput = new Scanner(System.in);

    System.out.print("TIRALABYRA\n==========\n\nMENU\n==========\n\n");

    boolean done = false;

    while (!done) {
      System.out.println("1  Solve a labyrinth");
      System.out.println("2  Compare algorithms");
      System.out.println("0  Exit");

      String choice = userInput.nextLine();
      switch (choice) {
        case "1":
          System.out.println("Enter input image file name: ");
          String infilename = userInput.nextLine();
          System.out.println("Enter output image file name: ");
          String outfilename = userInput.nextLine();

          solveAndSave(infilename, outfilename);
          break;

        case "0":
          System.out.println("Goodbye");
          done = true;
          break;

        default:
          break;
      }
    }

    userInput.close();
  }

  /**
   * We start here.
   */
  public static void main(String[] args) {
    showMenu();
    //compareAlgorithms("src/main/resources/labyrinth_long.png");
  }
}
