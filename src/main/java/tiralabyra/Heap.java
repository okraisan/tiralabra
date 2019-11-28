package tiralabyra;

public class Heap {
  
  private int maxSize = 0;
  private int size = 0;
  private double[] data;
  
  public Heap(int maxSz) {
    maxSize = maxSz;
    data = new double[maxSz];
  }
  
  public int getParent(int index) {
    return (index - 1) / 2;
  }
  
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
    if (l >= 0 && l < size - 1 && data[l] < data[index]) {
      next = l;
    } else {
      next = index;
    }
    if (r >= 0 && r < size - 1 && data[r] < data[next]) {
      next = r;
    }
    if (next != index) {
      double tmp = data[index];
      data[index] = data[next];
      data[next] = tmp;
      heapify(next);
    }
  }
  
  public void insert(double val) {
    // if (size == maxSz) throw exception
    size++;
    int index = size - 1;
    while (index > 0 && data[getParent(index)] > val) {
      data[index] = data[getParent(index)];
      index = getParent(index);
    }
    data[index] = val;
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
  
  public double removeMin() {
    // todo throw exception if empty
    double min = data[0];
    data[0] = data[size - 1];
    size--;
    heapify(0);
    return min;
  }
}
