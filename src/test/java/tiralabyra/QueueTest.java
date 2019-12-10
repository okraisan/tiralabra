package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
  Queue queue;
  Queue emptyQueue;

  /**
   * This queue is filled so that a reallocation happens, then popped once.
   */
  Queue oncePoppedAndInsertedQueue;

  public QueueTest() {
  }

  /**
   * Set up queues with known contents, size, and ordering.
   */
  @Before
  public void setUp() {
    queue = new Queue();
    emptyQueue = new Queue();
    for (int i = 1; i <= 32; i++) {
      queue.insert(i);
    }

    oncePoppedAndInsertedQueue = new Queue();
    oncePoppedAndInsertedQueue.insert(1);
    oncePoppedAndInsertedQueue.insert(2);
    oncePoppedAndInsertedQueue.insert(3);
    oncePoppedAndInsertedQueue.insert(4);
    oncePoppedAndInsertedQueue.pop();
    oncePoppedAndInsertedQueue.insert(5);
    oncePoppedAndInsertedQueue.insert(6);
    oncePoppedAndInsertedQueue.pop();
    oncePoppedAndInsertedQueue.pop();
    oncePoppedAndInsertedQueue.pop();
  }

  /**
   * Size should be correct.
   */
  @Test
  public void testSize() {
    assertEquals(0, emptyQueue.size());
    assertEquals(32, queue.size());
  }

  /**
   * An inserted element should be in the queue until popped.
   */
  @Test
  public void testInsert() {
    emptyQueue.insert(1);
    int fromQueue = emptyQueue.pop();
    assertEquals(1, fromQueue);
    assertEquals(0, emptyQueue.size());
  }

  /**
   * Elements should be in FIFO order when popped.
   */
  @Test
  public void testPopOrder() {
    for (int i = 1; i <= 32; i++) {
      assertEquals(i, queue.pop());
    }
  }

  /**
   * Head position should reset after 2^n reallocation.
   */
  @Test
  public void testHeadReset() {
    assertEquals(5, oncePoppedAndInsertedQueue.pop());
  }
}
