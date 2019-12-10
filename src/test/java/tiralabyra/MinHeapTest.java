package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MinHeapTest {

  MinHeap heap;
  MinHeap heapWithSmallInitialSize;

  @Before
  public void setUp() throws Exception {
    heap = new MinHeap(16);
    heapWithSmallInitialSize = new MinHeap();
  }

  @Test
  public void testRemovalOrderWhenInsertedSmallestLast() {
    heap.insert(new PrioNode(1, 1000.0));
    heap.insert(new PrioNode(2, 8.0));
    heap.insert(new PrioNode(3, 5.0));
    heap.insert(new PrioNode(4, 1.0));
    heap.insert(new PrioNode(5, 0.0));
    heap.insert(new PrioNode(6, -0.5));

    assertEquals(6, heap.removeMin().getIndex());
    assertEquals(5, heap.removeMin().getIndex());
    assertEquals(4, heap.removeMin().getIndex());
    assertEquals(3, heap.removeMin().getIndex());
    assertEquals(2, heap.removeMin().getIndex());
    assertEquals(1, heap.removeMin().getIndex());
  }

  @Test
  public void testRemovalOrderWhenInsertedSmallestFirst() {
    heap.insert(new PrioNode(1, -0.5));
    heap.insert(new PrioNode(2, 0.0));
    heap.insert(new PrioNode(3, 1.0));
    heap.insert(new PrioNode(4, 5.0));
    heap.insert(new PrioNode(5, 8.0));
    heap.insert(new PrioNode(6, 1000.0));

    assertEquals(1, heap.removeMin().getIndex());
    assertEquals(2, heap.removeMin().getIndex());
    assertEquals(3, heap.removeMin().getIndex());
    assertEquals(4, heap.removeMin().getIndex());
    assertEquals(5, heap.removeMin().getIndex());
    assertEquals(6, heap.removeMin().getIndex());
  }

  @Test
  public void testRemovalOrderWhenInsertedOutOfOrder() {
    heap.insert(new PrioNode(1, 5.0));
    heap.insert(new PrioNode(2, 8.0));
    heap.insert(new PrioNode(3, -0.5));
    heap.insert(new PrioNode(4, 0.0));
    heap.insert(new PrioNode(5, 1000.0));
    heap.insert(new PrioNode(6, 1.0));

    assertEquals(3, heap.removeMin().getIndex());
    assertEquals(4, heap.removeMin().getIndex());
    assertEquals(6, heap.removeMin().getIndex());
    assertEquals(1, heap.removeMin().getIndex());
    assertEquals(2, heap.removeMin().getIndex());
    assertEquals(5, heap.removeMin().getIndex());
  }

  @Test
  public void testParentIndices() {
    heap.insert(new PrioNode(1, 1000.0));
    heap.insert(new PrioNode(2, 8.0));
    heap.insert(new PrioNode(3, 1.0));
    heap.insert(new PrioNode(4, 0.0));
    heap.insert(new PrioNode(5, 5.0));
    heap.insert(new PrioNode(6, -0.5));
    heap.insert(new PrioNode(7, -0.5));
    heap.insert(new PrioNode(8, -0.5));
    heap.insert(new PrioNode(9, -0.5));

    assertEquals(0, heap.getParent(1));
    assertEquals(0, heap.getParent(2));
    assertEquals(1, heap.getParent(3));
    assertEquals(1, heap.getParent(4));
    assertEquals(2, heap.getParent(5));
    assertEquals(2, heap.getParent(6));
    assertEquals(3, heap.getParent(7));
    assertEquals(3, heap.getParent(8));
  }

  @Test
  public void testChildIndices() {
    heap.insert(new PrioNode(1, 1000.0));
    heap.insert(new PrioNode(2, 8.0));
    heap.insert(new PrioNode(3, 1.0));
    heap.insert(new PrioNode(4, 0.0));
    heap.insert(new PrioNode(5, 5.0));
    heap.insert(new PrioNode(6, -0.5));
    heap.insert(new PrioNode(7, -0.5));
    heap.insert(new PrioNode(8, -0.5));
    heap.insert(new PrioNode(9, -0.5));

    assertEquals(1, heap.getLeftChild(0));
    assertEquals(2, heap.getRightChild(0));
    assertEquals(3, heap.getLeftChild(1));
    assertEquals(4, heap.getRightChild(1));
    assertEquals(5, heap.getLeftChild(2));
    assertEquals(6, heap.getRightChild(2));
    assertEquals(7, heap.getLeftChild(3));
    assertEquals(8, heap.getRightChild(3));
    assertEquals(-1, heap.getRightChild(8));
  }

  @Test
  public void testReallocation() {
    heapWithSmallInitialSize.insert(new PrioNode(1, 1000.0));
    heapWithSmallInitialSize.insert(new PrioNode(2, 8.0));
    heapWithSmallInitialSize.insert(new PrioNode(3, 5.0));
    heapWithSmallInitialSize.insert(new PrioNode(4, 1.0));
    heapWithSmallInitialSize.insert(new PrioNode(5, 0.0));
    heapWithSmallInitialSize.insert(new PrioNode(6, -0.5));

    assertEquals(6, heapWithSmallInitialSize.removeMin().getIndex());
    assertEquals(5, heapWithSmallInitialSize.removeMin().getIndex());
    assertEquals(4, heapWithSmallInitialSize.removeMin().getIndex());
    assertEquals(3, heapWithSmallInitialSize.removeMin().getIndex());
    assertEquals(2, heapWithSmallInitialSize.removeMin().getIndex());
    assertEquals(1, heapWithSmallInitialSize.removeMin().getIndex());
  }

  @Test(expected=RuntimeException.class)
  public void testCantGetParentOfRoot() {
    heap.getParent(0);
  }

  @Test(expected=RuntimeException.class)
  public void testCantCreateWithZeroReservedSize() {
    MinHeap zeroHeap = new MinHeap(0);
    System.out.println("This won't be reached but silences 'unused' warning "
                     + "about " + zeroHeap);
  }

  @Test
  public void testRemoveFromEmpty() {
    heap.insert(new PrioNode(1, 1000.0));
    heap.removeMin();

    assertEquals(null, heap.removeMin());
  }

}
