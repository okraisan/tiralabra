package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ConnectedGraphTest {
  /**
   * A test image of a labyrinth that has an entry and exit point.
   */
  private Image testImage1;

  /**
   * The graph created from the test image.
   */
  private ConnectedGraph testGraph1;

  /**
   * Index of the entry node should be...
   */
  private final int correctEntryNodeIndex = 17;

  /**
   * Index of the exit node should be...
   */
  private final int correctExitNodeIndex  = 36;

  /**
   * Set up variables.
   * @throws Exception IOException in case of failed IO from the test
   *                   image (unlikely).
   */
  @Before
  public void setUp() throws Exception {
    testImage1 = new Image("src/test/resources/testImage1.png");
    testGraph1 = new ConnectedGraph();
    testGraph1.build(testImage1);
  }

  /**
   * Entry node is detected from the image and set correctly.
   */
  @Test
  public void hasCorrectEntryNode() {
    assertEquals(correctEntryNodeIndex, testGraph1.getEntryNodeIndex());
  }

  /**
   * Exit node is detected from the image and set correctly.
   */
  @Test
  public void hasCorrectExitNode() {
    assertEquals(correctExitNodeIndex, testGraph1.getExitNodeIndex());
  }

  /**
   * Distance to exit (for A* heuristics) is correctly measured.
   */
  @Test
  public void knowsDistanceToExit() {
    assertEquals(6.71, testGraph1.getEuclideanDistanceToExit(0), 0.005);
    assertEquals(2.24, testGraph1.getEuclideanDistanceToExit(correctEntryNodeIndex), 0.005);
    assertEquals(0.0, testGraph1.getEuclideanDistanceToExit(correctExitNodeIndex), 0.005);
  }
}