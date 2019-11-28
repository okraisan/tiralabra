package tiralabyra;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {

  Heap heap;
  
  @Before
  public void setUp() throws Exception {
    heap = new Heap(16);
  }

  @Test
  public void testRemovalOrder1() {
    System.out.println(heap);
    heap.insert(5.0);
    System.out.println(heap);
    heap.insert(1.0);
    System.out.println(heap);
    heap.insert(8.0);
    System.out.println(heap);
    heap.insert(1000.0);
    System.out.println(heap);
    heap.insert(0.0);
    System.out.println(heap);
    heap.insert(-0.5);
    System.out.println(heap);
    
    assertEquals(-0.5, heap.removeMin(), 1e-6);
    assertEquals(0.0, heap.removeMin(), 1e-6);
    assertEquals(1.0, heap.removeMin(), 1e-6);
    assertEquals(5.0, heap.removeMin(), 1e-6);
    assertEquals(8.0, heap.removeMin(), 1e-6);
    assertEquals(1000.0, heap.removeMin(), 1e-6);
  }
  
  @Test
  public void testRemovalOrder2() {
    heap.insert(-0.5);
    heap.insert(5.0);
    heap.insert(1.0);
    heap.insert(8.0);
    heap.insert(1000.0);
    heap.insert(0.0);
    
    assertEquals(-0.5, heap.removeMin(), 1e-6);
    assertEquals(0.0, heap.removeMin(), 1e-6);
    assertEquals(1.0, heap.removeMin(), 1e-6);
    assertEquals(5.0, heap.removeMin(), 1e-6);
    assertEquals(8.0, heap.removeMin(), 1e-6);
    assertEquals(1000.0, heap.removeMin(), 1e-6);
  }
  
  @Test
  public void testParentIndices() {
    heap.insert(-0.5);
    heap.insert(5.0);
    heap.insert(1.0);
    heap.insert(8.0);
    heap.insert(1000.0);
    heap.insert(0.0);
    heap.insert(0.0);
    heap.insert(0.0);
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
    heap.insert(-0.5);
    heap.insert(5.0);
    heap.insert(1.0);
    heap.insert(8.0);
    heap.insert(1000.0);
    heap.insert(0.0);
    heap.insert(0.0);
    heap.insert(0.0);
    heap.insert(0.0);
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

}
