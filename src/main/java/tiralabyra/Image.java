package tiralabyra;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Represents a bitmap image of a labyrinth.
 */
public class Image {
  private final int kAlkupisteenVari  = 0xFF0000FF;
  private final int kLoppupisteenVari = 0x00FF00FF;
  private final int kSeinanVari       = 0x000000FF;
  
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
  
  public int getNumberOfPixels() {
    return bufferedImage.getWidth() * bufferedImage.getHeight();
  }
  
  public int getIndexForPixel(int x, int y) {
    return y * bufferedImage.getWidth() + x;
  }
  
  public void setPixelAtIndex(int index, int color) {
    int y = index / bufferedImage.getWidth();
    int x = index % y;
    
    if (y >= 0 && x >= 0 && y < bufferedImage.getHeight()) {
      bufferedImage.setRGB(x, y, color);
    }
  }
  
  public boolean containsPosition(int x, int y) {
    return (x >= 0 && y >= 0
            && x < bufferedImage.getWidth() && y < bufferedImage.getHeight());
  }
  
  public boolean isTraversableAt(int x, int y) {
    if (containsPosition(x, y)) {
      System.out.println("pikselin arvo " + bufferedImage.getRGB(x, y));
    }
    return (containsPosition(x, y)
            && bufferedImage.getRGB(x,  y) != kSeinanVari);
  }
  
  public boolean hasEntryPointAt(int x, int y) {
    return (containsPosition(x, y)
            && bufferedImage.getRGB(x, y) == kAlkupisteenVari);
  }
  
  public boolean hasExitPointAt(int x, int y) {
    return (containsPosition(x, y)
            && bufferedImage.getRGB(x, y) == kLoppupisteenVari);
  }
  
  public void save(String path) {
    try {
      ImageIO.write(bufferedImage, "png", new File(path));
    } catch (IOException e) {
      System.out.println("Can't open file for writing");
    }
  }

}
