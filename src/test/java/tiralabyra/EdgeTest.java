package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EdgeTest {

  /**
   * The test edge.
   */
  private Edge edge;

  /**
   * Set up variables.
   */
  @Before
  public void setUp() {
    edge = new Edge(1, 2, 1.0);
  }

  /**
   * Endpoint node getters.
   */
  @Test
  public void testEdgeReturnsCorrectEndpoints() {
    assertEquals(1, edge.getNode1());
    assertEquals(2, edge.getNode2());
  }

  /**
   * Weight getter.
   */
  @Test
  public void testEdgeReturnsCorrectWeight() {
    assertEquals(1, edge.getNode1());
    assertEquals(2, edge.getNode2());
  }

}
