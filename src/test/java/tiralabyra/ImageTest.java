package tiralabyra;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

public class ImageTest {

  /**
   * Test image as a bitmap byte array.
   */
  private byte[] testImageBytes;

  /**
   * Test image, Java internal representation.
   */
  private BufferedImage testImageBuffer;

  /**
   * Test image, in the class to be tested.
   */
  private Image testImage;

  /**
   * Set up test data.
   * @throws Exception IOException in case the hardcoded test data can't be read
   *         (unlikely).
   */
  @Before
  public void setUp() throws Exception {

    /*
     * The test image is a 2x2 "labyrinth" with one entry pixel (E),
     * one wall (W), one traversable pixel (.) and one exit pixel (X).
     *
     *   EW
     *   .X
     *
     */
    final byte bFF = (byte) 0xFF;
    final byte b00 = (byte) 0x00;
    testImageBytes = new byte[] {
        b00, b00, bFF, bFF,
        b00, b00, b00, bFF,
        bFF, bFF, bFF, bFF,
        b00, bFF, b00, bFF
    };

    testImageBuffer = ImageIO.read(new ByteArrayInputStream(testImageBytes));
    testImage = new Image(testImageBuffer);
  }

  /**
   * The entry point in the test image must be recognized.
   */
  @Test
  public void imageHasEntryPoint() {
    assertEquals(true, testImage.hasEntryPointAt(new Point(0, 0)));
  }

}
