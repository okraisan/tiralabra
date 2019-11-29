package tiralabyra;

public class MinHeap {
  
  private int maxSize = 0;
  private int size = 0;
  private PrioNode[] data;
  
  public MinHeap(int maxSz) {
    maxSize = maxSz;
    data = new PrioNode[maxSz];
  }
  
  public int getParent(int index) {
    return (index - 1) / 2;
  }
  
  /**
   * @param index Which node to ask child for.
   * @return Index to left child, or -1 if nonexistent.
   */
  public int getLeftChild(int index) {
    if (2 * index + 1 >= size) {
      return -1;
    } else {
      return 2 * index + 1;
    }
  }
  
  public int getRightChild(int index) {
    if (2 * index + 2 >= size) {
      return -1;
    } else {
      return 2 * index + 2;
    }
  }
  
  private void heapify(int index) {
    int l = getLeftChild(index);
    int r = getRightChild(index);
    int next;
    if (l > 0 && l < size && data[l].compareTo(data[index]) < 0) {
      next = l;
    } else {
      next = index;
    }
    if (r > 0 && r < size && data[r].compareTo(data[next]) < 0) {
      next = r;
    }
    if (next != index) {
      PrioNode tmp = data[index];
      data[index] = data[next];
      data[next] = tmp;
      heapify(next);
    }
  }
  
  public void insert(PrioNode newnode) {
    // if (size == maxSz) throw exception
    size++;
    int index = size - 1;
    while (index > 0 && data[getParent(index)].compareTo(newnode) > 0) {
      data[index] = data[getParent(index)];
      index = getParent(index);
    }
    data[index] = newnode;
  }
  
  public int size() {
    return size;
  }
  
  public String toString() {
    String result = "[" + size + "/" + maxSize + "] ";
    for (int i = 0; i < size; i++) {
      result += data[i] + " ";
    }
    result += "| ";
    for (int i = size; i < maxSize; i++) {
      result += data[i] + " ";
    }
    return result;
  }
  
  public PrioNode removeMin() {
    // todo throw exception if empty
    PrioNode min = data[0];
    data[0] = data[size - 1];
    size--;
    heapify(0);
    return min;
  }
}
