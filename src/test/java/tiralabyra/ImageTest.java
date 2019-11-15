package tiralabyra;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
   * @throws Exception
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
        bFF, bFF, b00, b00, // Entry point.
        bFF, b00, b00, b00, // Wall.
        bFF, bFF, bFF, bFF, // Traversable.
        bFF, b00, bFF, b00  // Exit.
    };

    testImageBuffer = ImageIO.read(new ByteArrayInputStream(testImageBytes));
  }

  @Test
  public void imageHasEntryPoint() {
    assertEquals(true, testImage.hasEntryPointAt(new Point(0, 0)));
  }

}
