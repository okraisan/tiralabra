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
    testGraph1 = new ConnectedGraph(testImage1);
    testGraph3 = new ConnectedGraph(testImage3);
    result1 = astar.solve(testGraph1, false);
    result3 = astar.solve(testGraph3, false);
  }

  /**
   * Algorithm can solve a solvable labyrinth.
   */
  @Test
  public void solvesLabyrinthOnlyIfSolvable() {
    assertEquals(true, result1.wasSolved());
    assertEquals(false, result3.wasSolved());
  }

}
