package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PointTest {

  private Point testPoint1;
  private Point testPoint2;

  /**
   * Set up test variables.
   */
  @Before
  public void setup() {
    testPoint1 = new Point(5, 2);
    testPoint2 = new Point(6, -3);
  }

  /**
   * A point must return the position it was initialized with.
   */
  @Test
  public void pointReportsPosition() {
    assertEquals(testPoint1.getX(), 5);
    assertEquals(testPoint1.getY(), 2);
  }

  /**
   * Two points, when added, must have a correct sum.
   */
  @Test
  public void pointsCanBeAdded() {
    Point sumPoint = Point.add(testPoint1, testPoint2);
    assertEquals(sumPoint.getX(), 5 + 6);
    assertEquals(sumPoint.getY(), 2 - 3);
  }
}
