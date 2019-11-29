package tiralabyra;

public class Point {
  private int posX;
  private int posY;

  /**
   * A point in 2D space with integer coordinates.
   * @param x X position, in pixels.
   * @param y Y position, in pixels.
   */
  public Point(int x, int y) {
    posX = x;
    posY = y;
  }

  public int getX() {
    return posX;
  }

  public int getY() {
    return posY;
  }

  /**
   * Add two points together.
   * @param a First point.
   * @param b Second point.
   * @return A point with the input points' coordinates summed up.
   */
  static Point add(Point a, Point b) {
    return new Point(a.getX() + b.getX(), a.getY() + b.getY());
  }

  /**
   * Euclidean distance to another point.
   */
  public double distanceTo(Point other) {
    double dx = other.getX() - posX;
    double dy = other.getY() - posY;
    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public String toString() {
    return "(" + posX + "," + posY + ")";
  }
}
