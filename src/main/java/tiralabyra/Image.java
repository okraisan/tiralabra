package tiralabyra;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Represents a bitmap image of a labyrinth.
 */
public class Image {
  private final int entryPointColor  = 0xFFFF0000;
  private final int exitPointColor   = 0xFF00FF00;
  private final int wallColor        = 0xFF000000;
  
  private BufferedImage bufferedImage;
  
  /**
   * Read an image from a given file.
   * @param path Filesystem path to the input file.
   */
  public Image(String path) {
    try {
      bufferedImage = ImageIO.read(new File(path));
    } catch (IOException e) {
      System.out.println("Kuva ei aukea");
      return;
    }
  }
  
  public int getWidth() {
    return bufferedImage.getWidth();
  }
  
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
   * @return A linear index for the given pixel coordinates.
   */
  public int getIndexForPixel(Point point) {
    return point.getY() * bufferedImage.getWidth() + point.getX();
  }
  
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
   * Draw a filled square around the coordinates indicated by the given linear pixel index.
   */
  public void plotPathAroundIndex(int index, int color) {
    Point centerPoint = new Point(index % bufferedImage.getWidth(), index / bufferedImage.getWidth());

    for (int deltaY = -1; deltaY <= 1; deltaY++) {
      for (int deltaX = -1; deltaX <= 1; deltaX++) {
        Point plotPoint = Point.add(centerPoint, new Point(deltaX, deltaY));
        if (containsPosition(plotPoint) && isTraversableAt(plotPoint)) {
          bufferedImage.setRGB(plotPoint.getX(), plotPoint.getY(), color);
        }    
      }
    }
    
    
  }
  
  /**
   * @return True if the given coordinates are inside the image boundary.
   */
  public boolean containsPosition(Point point) {
    return (point.getX() >= 0 && point.getY() >= 0
            && point.getX() < bufferedImage.getWidth() && point.getY() < bufferedImage.getHeight());
  }
  
  /**
   * @return True if there's a non-wall pixel at the given coordinates.
   */
  public boolean isTraversableAt(Point point) {
    return (containsPosition(point)
            && bufferedImage.getRGB(point.getX(),  point.getY()) != wallColor);
  }
  
  /**
   * @return True if there's an entry point pixel at the given coordinates.
   */
  public boolean hasEntryPointAt(Point point) {
    return (containsPosition(point)
            && bufferedImage.getRGB(point.getX(), point.getY()) == entryPointColor);
  }
  
  /**
   * @return True if there's an exit point pixel at the given coordinates.
   */
  public boolean hasExitPointAt(Point point) {
    return (containsPosition(point)
            && bufferedImage.getRGB(point.getX(), point.getY()) == exitPointColor);
  }
  
  /**
   * Save this image as a file.
   * @param path Filesystem path of the image to be written.
   */
  public void save(String path) {
    try {
      System.out.println("Save");
      ImageIO.write(bufferedImage, "png", new File(path));
    } catch (IOException e) {
      System.out.println("Can't open file for writing");
    }
  }

}
