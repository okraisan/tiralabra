package tiralabyra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ImageTest {
  /**
   * Test image, in the class to be tested.
   */
  private Image testImage;

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
    testImage = new Image("src/test/resources/testImage1.png");
  }

  /**
   * The entry point in the test image must be recognized.
   */
  @Test
  public void imageHasEntryPoint() {
    assertEquals(true, testImage.hasEntryPointAt(correctEntryPoint));
  }

  /**
   * The exit point in the test image must be recognized.
   */
  @Test
  public void imageHasExitPoint() {
    assertEquals(true, testImage.hasExitPointAt(correctExitPoint));
  }

}
