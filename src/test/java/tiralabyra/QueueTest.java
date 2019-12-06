package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QueueTest {
  Queue queue;
  Queue emptyQueue;

  public QueueTest() {
  }

  /**
   * Set up queues with known contents, size, and ordering.
   */
  @Before
  public void setUp() {
    queue = new Queue();
    emptyQueue = new Queue();
    queue.insert(1);
    queue.insert(2);
    queue.insert(3);
    queue.insert(4);
    queue.insert(5);
  }

  /**
   * Test of size method, of class Queue.
   */
  @Test
  public void testSize() {
    assertEquals(0, emptyQueue.size());
    assertEquals(5, queue.size());
  }

  /**
   * Test of insert method, of class Queue.
   */
  @Test
  public void testInsert() {
    emptyQueue.insert(1);
    int fromQueue = emptyQueue.pop();
    assertEquals(1, fromQueue);
    assertEquals(0, emptyQueue.size());
  }

  /**
   * Test of pop method, of class Queue.
   */
  @Test
  public void testPopOrder() {
    assertEquals(1, queue.pop());
    assertEquals(2, queue.pop());
    assertEquals(3, queue.pop());
    assertEquals(4, queue.pop());
    assertEquals(5, queue.pop());
  }

}
