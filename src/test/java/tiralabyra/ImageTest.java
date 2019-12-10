package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ImageTest {
  private Image testImage1;
  private Image testImage2;

  /**
   * The test image should have an entry point here.
   */
  private final Point correctEntryPoint = new Point(7, 1);

  /**
   * The test image should have an exit point here.
   */
  private final Point correctExitPoint  = new Point(6, 3);

  /**
   * Set up test data.
   * @throws Exception IOException in case the test data can't be read.
   */
  @Before
  public void setUp() throws Exception {
    testImage1 = new Image("src/test/resources/testImage1.png");
    testImage2 = new Image("src/test/resources/testImage2.png");
  }

  /**
   * The entry point in the test image must be recognized.
   */
  @Test
  public void imageHasAnEntryPoint() {
    assertEquals(true, testImage1.hasEntryPointAt(correctEntryPoint));
    assertEquals(false, testImage1.hasEntryPointAt(new Point(-1, -1)));
    assertEquals(false, testImage1.hasEntryPointAt(new Point(0, 0)));
    assertEquals(true, !testImage2.hasEntryPointAt(correctEntryPoint));
  }

  /**
   * The exit point in the test image must be recognized.
   */
  @Test
  public void imageHasAnExitPoint() {
    assertEquals(true, testImage1.hasExitPointAt(correctExitPoint));
    assertEquals(false, testImage1.hasExitPointAt(new Point(-1, -1)));
    assertEquals(false, testImage1.hasExitPointAt(new Point(0, 0)));
    assertEquals(true, !testImage2.hasExitPointAt(correctExitPoint));
  }

  @Test
  public void imageIsTraversableOnlyWhereItShouldBe() {
    assertEquals(true, testImage1.isTraversableAt(new Point(1, 1)));
    assertEquals(true, testImage1.isTraversableAt(correctExitPoint));
    assertEquals(true, testImage1.isTraversableAt(correctEntryPoint));
    assertEquals(false, testImage1.isTraversableAt(new Point(0, 0)));
    assertEquals(false, testImage1.isTraversableAt(new Point(10, 0)));
  }

  @Test
  public void imageOnlyContainsPositionsInsideBorder() {
    assertEquals(true, testImage1.containsPosition(new Point(0, 0)));
    assertEquals(false, testImage1.containsPosition(new Point(-1, 0)));
    assertEquals(false, testImage1.containsPosition(new Point(0, -1)));
    assertEquals(false, testImage1.containsPosition(new Point(10, 0)));
    assertEquals(false, testImage1.containsPosition(new Point(0, 10)));
  }

}
