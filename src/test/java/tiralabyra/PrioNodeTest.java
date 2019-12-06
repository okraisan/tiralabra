package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests related to nodes in the priority queue (minimum heap).
 */
public class PrioNodeTest {
  PrioNode firstNode;
  PrioNode secondNode;
  PrioNode anotherSecondNode;
  PrioNode thirdNode;

  public PrioNodeTest() {
  }

  /**
    * Set up some test nodes with a known order but differing contents.
   */
  @Before
  public void setUp() {
    firstNode = new PrioNode(0, 0.0);
    secondNode = new PrioNode(1, 1.0);
    anotherSecondNode = new PrioNode(0, 1.0);
    thirdNode = new PrioNode(1, 2.0);
  }

  /**
   * Test that ordering is compared correctly.
   */
  @Test
  public void testCompareTo() {
    assertEquals(-1, firstNode.compareTo(secondNode));
    assertEquals(0, secondNode.compareTo(anotherSecondNode));
    assertEquals(1, thirdNode.compareTo(secondNode));
  }
    
}
