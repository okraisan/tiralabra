package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ConnectedGraphTest {
  /**
   * Test image, internal Java representation.
   */
  private Image testImage;

  /**
   * The graph created from the test image.
   */
  private ConnectedGraph testGraph;

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
    testImage = new Image("src/test/resources/testImage1.png");
    testGraph = new ConnectedGraph(testImage);
  }

  /**
   * Entry node is detected from the image and set correctly.
   */
  @Test
  public void hasCorrectEntryNode() {
    assertEquals(correctEntryNodeIndex, testGraph.getEntryNodeIndex());
  }

  /**
   * Exit node is detected from the image and set correctly.
   */
  @Test
  public void hasCorrectExitNode() {
    assertEquals(correctExitNodeIndex, testGraph.getExitNodeIndex());
  }
}
