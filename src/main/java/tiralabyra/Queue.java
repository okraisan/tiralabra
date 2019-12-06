package tiralabyra;

public class Queue {
  private int size = 0;
  private int[] data;
  private int head = 0;

  public Queue() {
    data = new int[1];
  }

  /**
   * Initialize a minimum heap with initial allocated size.
   * @param reservedSize Initial size of the internal container.
   */
  public Queue(int reservedSize) {
    if (reservedSize > 0) {
      data = new int[reservedSize];
    } else {
      data = new int[1];
    }
  }

  public int size() {
    return size;
  }

  /**
   * Double the size of the internal storage.
   */
  private void reallocate() {
    int[] newData = new int[data.length * 2];
    for (int i = 0; i < size; i++) {
      newData[i] = data[(head + i) % data.length];
    }

    data = newData;
  }

  /**
   * Insert a new node into the queue.
   */
  public void insert(int newnode) throws RuntimeException {
    if (size == data.length) {
      reallocate();
    }

    size++;
    int tail = (head + size) % data.length;
    data[tail] = newnode;
  }

  /**
   * Return and remove the first element in the queue.
   */
  public int pop() {
    // TODO Exception if size == null

    int result = data[head];
    head = (head + 1) % data.length;
    size--;

    return result;
  }
}
