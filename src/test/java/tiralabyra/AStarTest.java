package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AStarTest {
  /**
   * A test image of a solvable labyrinth that has an entry and exit point.
   */
  private Image testImage1;

  /**
   * A test image of an unsolvable labyrinth that has an entry and exit point.
   */
  private Image testImage3;

  private ConnectedGraph solvableGraph;
  private ConnectedGraph unsolvableGraph;

  /**
   * A* solver.
   */
  private AStar astar = new AStar();

  private SolvedResult solvableResult;
  private SolvedResult unsolvableResult;
  private SolvedResult heuristicsResult;

  /**
   * Set up test variables.
   * @throws Exception IOException if the test images can't be read.
   */
  @Before
  public void setUp() throws Exception {
    astar = new AStar();
    testImage1 = new Image("src/test/resources/testImage1.png");
    testImage3 = new Image("src/test/resources/testImage3.png");
    solvableGraph = new ConnectedGraph(testImage1);
    unsolvableGraph = new ConnectedGraph(testImage3);
    solvableResult = astar.solve(solvableGraph, false);
    unsolvableResult = astar.solve(unsolvableGraph, false);
    heuristicsResult = astar.solve(solvableGraph, true);
  }

  /**
   * Algorithm can solve a solvable labyrinth.
   */
  @Test
  public void solvesLabyrinthOnlyIfSolvable() {
    assertEquals(true, solvableResult.wasSolved());
    assertEquals(false, unsolvableResult.wasSolved());
  }

  /**
   * Algorithm can solve a solvable labyrinth.
   */
  @Test
  public void solvesLabyrinthUsingHeuristics() {
    assertEquals(true, solvableResult.wasSolved());
    assertEquals(false, unsolvableResult.wasSolved());
  }

}
