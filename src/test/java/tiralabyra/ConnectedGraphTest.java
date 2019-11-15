package tiralabyra;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

public class ConnectedGraphTest {

  /**
   * Test image as a bitmap byte array.
   */
  private byte[] testImageBytes;

  /**
   * Test image, internal Java representation.
   */
  private Image testImage;

  /**
   * The graph created from the test image.
   */
  private ConnectedGraph testGraph;

  /**
   * Set up variables.
   * @throws Exception IOException in case of failed IO from the test
   *                   image (unlikely).
   */
  @Before
  public void setUp() throws Exception {

    final byte bFF = (byte) 0xFF;
    final byte b00 = (byte) 0x00;
    testImageBytes = new byte[] {
        b00, b00, bFF, bFF,
        b00, b00, b00, bFF,
        bFF, bFF, bFF, bFF,
        b00, bFF, b00, bFF
    };

    testImage =
        new Image(ImageIO.read(new ByteArrayInputStream(testImageBytes)));
    testGraph = new ConnectedGraph(testImage);
  }

  /**
   * Entry node is detected from the image and set correctly.
   */
  @Test
  public void hasCorrectEntryNode() {
    assertEquals(0, testGraph.getEntryNodeIndex());
  }

  /**
   * Exit node is detected from the image and set correctly.
   */
  @Test
  public void hasCorrectExitNode() {
    assertEquals(3, testGraph.getExitNodeIndex());
  }
}
