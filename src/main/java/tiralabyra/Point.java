package tiralabyra;

public class Point {
  /**
   * X position, in pixels.
   */
  private int posX;

  /**
   * Y position, in pixels.
   */
  private int posY;

  /**
   * @param x X position, in pixels.
   * @param y Y position, in pixels.
   */
  public Point(final int x, final int y) {
    posX = x;
    posY = y;
  }

  /**
   * @return X position, in pixels.
   */
  public int getX() {
    return posX;
  }

  /**
   * @return Y position, in pixels.
   */
  public int getY() {
    return posY;
  }

  /**
   * Add two points together.
   * @param a First point.
   * @param b Second point.
   * @return A point with the input points' coordinates summed up.
   */
  static Point add(final Point a, final Point b) {
    return new Point(a.getX() + b.getX(), a.getY() + b.getY());
  }
}
