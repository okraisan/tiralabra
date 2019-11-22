package tiralabyra;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Represents a bitmap image of a labyrinth.
 */
public class Image {
  /**
   *  Color of the entry pixel in the image.
   */
  private final int entryPointColor  = 0xFFFF0000;

  /**
   * Color of the exit pixel in the image.
   */
  private final int exitPointColor   = 0xFF00FF00;

  /**
   * Color of walls, i.e. non-passable pixels.
   */
  private final int wallColor        = 0xFF000000;

  /**
   * Java internal representation of the image in memory.
   */
  private BufferedImage bufferedImage;

  /**
   * Read an image from a given file.
   * @param path Filesystem path to the input file.
   */
  public Image(final String path) {
    try {
      bufferedImage = ImageIO.read(new File(path));
    } catch (IOException e) {
      System.out.println("Kuva ei aukea");
      return;
    }
  }

  /**
   * Read an image from a BufferedImage.
   * @param buf The input buffer.
   */
  public Image(final BufferedImage buf) {
    bufferedImage = buf;
  }

  /**
   * @return Image width in pixels.
   */
  public int getWidth() {
    return bufferedImage.getWidth();
  }

  /**
   * @return Image height in pixels.
   */
  public int getHeight() {
    return bufferedImage.getHeight();
  }

  /**
   * @return Total area of the image, in pixels.
   */
  public int getNumberOfPixels() {
    return bufferedImage.getWidth() * bufferedImage.getHeight();
  }

  /**
   * @param point XY position of the pixel on the image.
   * @return A linear index for the given pixel coordinates.
   */
  public int getIndexForPixel(final Point point) {
    return point.getY() * bufferedImage.getWidth() + point.getX();
  }

  /**
   * @return A list of all possible pixels on the image.
   */
  public Point[] getPixelPositions() {
    Point[] result = new Point[getNumberOfPixels()];
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        result[y * getWidth() + x] = new Point(x, y);
      }
    }
    return result;
  }

  /**
   * Draw a filled square around the coordinates indicated by the given linear
   * pixel index. Wall pixels are left as is. Used to draw thicker lines
   * around a path for better clarity.
   * @param index Linear index pointing to the center pixel of the drawing
   * action.
   * @param brushRadius Size of the drawing brush.
   * @param color Which color to use.
   */
  public void plotPathAroundIndex(final int index, final int brushRadius,
                                  final int color) {
    Point centerPoint = new Point(index % bufferedImage.getWidth(),
                                  index / bufferedImage.getWidth());

    for (int deltaY = -brushRadius; deltaY <= brushRadius; deltaY++) {
      for (int deltaX = -brushRadius; deltaX <= brushRadius; deltaX++) {
        Point plotPoint = Point.add(centerPoint, new Point(deltaX, deltaY));
        if (containsPosition(plotPoint) && isTraversableAt(plotPoint)) {
          bufferedImage.setRGB(plotPoint.getX(), plotPoint.getY(), color);
        }
      }
    }
  }

  /**
   * @return True if the given coordinates are inside the image boundary.
   * @param point Coordinates of the requested pixel.
   */
  public boolean containsPosition(final Point point) {
    return (point.getX() >= 0 && point.getY() >= 0
            && point.getX() < bufferedImage.getWidth()
            && point.getY() < bufferedImage.getHeight());
  }

  /**
   * @return True if there's a non-wall pixel at the given coordinates.
   * @param point Coordinates of the requested pixel.
   */
  public boolean isTraversableAt(final Point point) {
    return (containsPosition(point)
            && bufferedImage.getRGB(point.getX(), point.getY()) != wallColor);
  }

  /**
   * @return True if there's an entry point pixel at the given coordinates.
   * @param point Coordinates of the requested pixel.
   */
  public boolean hasEntryPointAt(final Point point) {
    return (containsPosition(point)
            && bufferedImage.getRGB(point.getX(), point.getY())
            == entryPointColor);
  }

  /**
   * @return True if there's an exit point pixel at the given coordinates.
   * @param point Coordinates of the requested pixel.
   */
  public boolean hasExitPointAt(final Point point) {
    return (containsPosition(point)
            && bufferedImage.getRGB(point.getX(), point.getY())
            == exitPointColor);
  }

  /**
   * Save this image as a file.
   * @param path Filesystem path of the image to be written.
   */
  public void save(final String path) {
    try {
      ImageIO.write(bufferedImage, "png", new File(path));
    } catch (IOException e) {
      System.out.println("Can't open file for writing");
    }
  }

}
