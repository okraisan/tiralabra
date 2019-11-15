package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PointTest {

  /**
   * X coordinate for the first test point.
   */
  private final int point1X = 5;

  /**
   * Y coordinate for the first test point.
   */
  private final int point1Y = 2;

  /**
   * X coordinate for the second test point.
   */
  private final int point2X = 5;

  /**
   * Y coordinate for the second test point.
   */
  private final int point2Y = 2;

  /**
   * A variable to store test data.
   */
  private Point testPoint1;

  /**
   * A variable to store test data.
   */
  private Point testPoint2;

  /**
   * Set up test variables.
   */
  @Before
  public void setup() {
    testPoint1 = new Point(point1X, point1Y);
    testPoint2 = new Point(point2X, point1Y);
  }

  /**
   * A point must return the position it was initialized with.
   */
  @Test
  public void pointReportsPosition() {
    assertEquals(testPoint1.getX(), point1X);
    assertEquals(testPoint1.getY(), point2Y);
  }

  /**
   * Two points, when added, must have a correct sum.
   */
  @Test
  public void pointsCanBeAdded() {
    Point sumPoint = Point.add(testPoint1, testPoint2);
    assertEquals(sumPoint.getX(), point1X + point2X);
    assertEquals(sumPoint.getY(), point1Y + point2Y);
  }
}
