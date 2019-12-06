/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabyra;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author windy
 */
public class PrioNodeTest {
    
    PrioNode firstNode;
    PrioNode secondNode;
    PrioNode anotherSecondNode;
    PrioNode thirdNode;
    
    public PrioNodeTest() {
    }
    
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
