package tiralabyra;

import static org.junit.Assert.*;

import org.junit.*;

public class PointTest {
  
  private Point testPoint1;
  private Point testPoint2;

  @Before
  public void setup() {
    testPoint1 = new Point(5, 2);
    testPoint2 = new Point(10, 11);
  }
  
  @Test
  public void pointReportsPosition() {
    assertEquals(testPoint1.getX(), 5);
    assertEquals(testPoint1.getY(), 2);
  }
  
  @Test
  public void pointsCanBeAdded() {
    Point sumPoint = Point.add(testPoint1, testPoint2);
    assertEquals(sumPoint.getX(), 15);
    assertEquals(sumPoint.getY(), 13);
  }
}
