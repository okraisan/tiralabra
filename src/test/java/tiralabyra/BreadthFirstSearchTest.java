package tiralabyra;

import tiralabyra.Algorithm.BreadthFirstSearch;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the BFS solver.
 */
public class BreadthFirstSearchTest {
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
  private BreadthFirstSearch bfs;

  private SolvedResult solvableResult;
  private SolvedResult unsolvableResult;
  private SolvedResult heuristicsResult;
  
  public BreadthFirstSearchTest() {
  }
  
  @Before
  public void setUp() {
    bfs = new BreadthFirstSearch();
    testImage1 = new Image("src/test/resources/testImage1.png");
    testImage3 = new Image("src/test/resources/testImage3.png");
    solvableGraph = new ConnectedGraph();
    solvableGraph.build(testImage1);
    unsolvableGraph = new ConnectedGraph();
    unsolvableGraph.build(testImage3);
    solvableResult = bfs.solve(solvableGraph);
    unsolvableResult = bfs.solve(unsolvableGraph);
  }

  /**
   * Algorithm can solve a solvable labyrinth.
   */
  @Test
  public void solvesLabyrinthOnlyIfSolvable() {
    assertEquals(true, solvableResult.wasSolved());
    assertEquals(false, unsolvableResult.wasSolved());
  }
}
