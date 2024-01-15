package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import model.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Pixel;

/**
 * The class reads and loads Images in most formats (except PPM).
 */
public class ImageUtil {

  /**
   * This method loads an Image from the given file name.
   *
   * @param filename the name of the file.
   * @return the image that has been loaded from the files.
   */
  protected static Image load(String filename) {
    // setting the variables
    // setting maxValue as 8bits only goes up to 255.
    int maxValue = 255;

    int pixelRGB;
    int r;
    int g;
    int b;

    BufferedImage image;

    try {
      image = ImageIO.read(new File(filename));
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot read file.");
    }

    try {
      Pixel[][] pixelArray = new Pixel[image.getHeight()][image.getWidth()];
      Pixel pix;
      for (int row = 0; row < image.getHeight(); row ++) {
        for (int col = 0; col < image.getWidth(); col ++) {
          pixelRGB = image.getRGB(col, row);
          Color color = new Color(pixelRGB, false);
          r = color.getRed();
          g = color.getGreen();
          b = color.getBlue();
          pix = new Pixel(r, g, b);
          pixelArray[row][col] = pix;
        }
      }
      return new Image(image.getHeight(), image.getWidth(), maxValue, pixelArray);
    } catch (NullPointerException e) {
      throw new IllegalArgumentException("");
    }
  }
}