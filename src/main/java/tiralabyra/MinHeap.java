package tiralabyra;

public class MinHeap {
  private int size = 0;
  private PrioNode[] data;

  public MinHeap() {
    data = new PrioNode[1];
  }

  /**
   * Initialize a minimum heap with initial allocated size.
   * @param reservedSize Initial size of the internal container.
   */
  public MinHeap(int reservedSize) {
    if (reservedSize > 0) {
      data = new PrioNode[reservedSize];
    } else {
      data = new PrioNode[1];
    }
  }

  public int size() {
    return size;
  }

  public int getParent(int index) {
    return (index - 1) / 2;
  }

  /**
   * Get the index of this node's left child, or -1 if nonexistent.
   * @param index Which node to ask child for.
   * @return Index to left child, or -1 if nonexistent.
   */
  public int getLeftChild(int index) {
    int childIndex = 2 * index + 1;
    if (childIndex >= size) {
      return -1;
    } else {
      return childIndex;
    }
  }

  /**
   * Get the index of this node's right child, or -1 if nonexistent.
   * @param index Which node to ask child for.
   * @return Index to right child, or -1 if nonexistent.
   */
  public int getRightChild(int index) {
    int childIndex = 2 * index + 2;
    if (childIndex >= size) {
      return -1;
    } else {
      return childIndex;
    }
  }

  /**
   * Double the size of the internal storage.
   */
  private void reallocate() {
    PrioNode[] newData = new PrioNode[data.length * 2];
    for (int i = 0; i < data.length; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  /**
   * Recursively check that heap hierarchy is satisfied starting at a node
   * index, and reorder if necessary.
   * @param index Which node to start from.
   */
  private void heapify(int index) {
    int left = getLeftChild(index);
    int right = getRightChild(index);
    int next;
    if (left > 0 && left < size && data[left].compareTo(data[index]) < 0) {
      next = left;
    } else {
      next = index;
    }
    if (right > 0 && right < size && data[right].compareTo(data[next]) < 0) {
      next = right;
    }
    if (next != index) {
      PrioNode tmp = data[index];
      data[index] = data[next];
      data[next] = tmp;
      heapify(next);
    }
  }

  /**
   * Insert a new node into the heap.
   */
  public void insert(PrioNode newnode) throws RuntimeException {
    if (size == data.length) {
      reallocate();
    }

    size++;
    int index = size - 1;
    while (index > 0 && data[getParent(index)].compareTo(newnode) > 0) {
      data[index] = data[getParent(index)];
      index = getParent(index);
    }
    data[index] = newnode;
  }

  /**
   * Return and remove the first (smallest) element in the heap.
   */
  public PrioNode removeMin() {
    if (size == 0) {
      return null;
    }

    final PrioNode min = data[0];
    data[0] = data[size - 1];
    size--;
    heapify(0);
    return min;
  }
}
