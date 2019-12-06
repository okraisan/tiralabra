package main;

import java.util.Scanner;
import tiralabyra.AStar;
import tiralabyra.BreadthFirstSearch;
import tiralabyra.ConnectedGraph;
import tiralabyra.Image;
import tiralabyra.SolvedResult;

public final class Main {

  /**
   * Solve one maze from an image file and draw the result onto an output image.
   */
  public static void solveAndSave(String inFileName, String outFileName) {
    final int backtrackColor = 0xFFFF0000;

    Image image = new tiralabyra.Image(inFileName);

    ConnectedGraph graph = new tiralabyra.ConnectedGraph();
    graph.build(image);
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
    System.out.println("n = " + image.getNumberOfPixels());

    System.out.println();
    System.out.println("A* WITH HEURISTICS");

    ConnectedGraph graph = new tiralabyra.ConnectedGraph();
    AStar astar = new AStar();

    long startTime = System.nanoTime();
    graph.build(image);
    SolvedResult result = astar.solve(graph, true);
    long elapsedTime = System.nanoTime() - startTime;

    if (result.wasSolved()) {
      System.out.println(String.format("Length:     %.1f px", result.getLength()));
      System.out.println(String.format("Exec time:  %.1f ms", elapsedTime / 1000000.0));
    }

    System.out.println();
    System.out.println("A* WITHOUT HEURISTICS");

    startTime = System.nanoTime();
    result = astar.solve(graph, false);
    elapsedTime = System.nanoTime() - startTime;

    if (result.wasSolved()) {
      System.out.println(String.format("Length:     %.1f px", result.getLength()));
      System.out.println(String.format("Exec time:  %.1f ms", elapsedTime / 1000000.0));
    }

    System.out.println();
    System.out.println("BREADTH-FIRST SEARCH");

    BreadthFirstSearch bfs = new BreadthFirstSearch();

    startTime = System.nanoTime();
    result = bfs.solve(graph);
    elapsedTime = System.nanoTime() - startTime;

    if (result.wasSolved()) {
      System.out.println(String.format("Length:     %.1f px", result.getLength()));
      System.out.println(String.format("Exec time:  %.1f ms", elapsedTime / 1000000.0));
    }
  }

  static void printHeading(String headingText) {
    System.out.println(headingText);
    for (int i = 0; i < headingText.length(); i++) {
      System.out.print("=");
    }
    System.out.print("\n\n");
  }

  static void showMenu() {
    Scanner userInput = new Scanner(System.in);

    printHeading("TIRALABYRA");

    boolean done = false;

    while (!done) {

      printHeading("MENU");

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

        case "2":
          printHeading("DIFFICULT LABYRINTH");
          compareAlgorithms("src/main/resources/labyrinth_long.png");

          System.out.println();
          printHeading("EASY LABYRINTH");
          compareAlgorithms("src/main/resources/labyrinth_short.png");
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
  }
}
