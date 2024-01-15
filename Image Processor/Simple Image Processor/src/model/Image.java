package model;

/**
 * This class represents an Image the user is loading, editing, or saving.
 */
public class Image {
  private int height;
  private int width;
  private int max;
  private Pixel[][] image;

  /**
   * A constructor that takes in four parameters the name, height, width, max, and image.
   *
   * @param height the height of the image.
   * @param width the width of the image.
   * @param max the maximum brightness of an image (on a pixel rgb level).
   * @param image the 2D array of Pixels that make up the image.
   * @throws IllegalArgumentException if any of these fields are null.
   */
  public Image(int height, int width,  int max, Pixel[][] image)
          throws IllegalArgumentException {

    if (height < 0 || width < 0 || image == null || max < 0 || max > 255) {
      throw new IllegalArgumentException("One of all of the inputs are invalid: \n" +
              "- height and width cannot be less then 0 \n" +
              "- imageName cannot be an empty String\n" +
              "- max value cannot be below 0 or above 255.");
    }

    this.height = height;
    this.width = width;
    this.max = max;
    this.image = image;
  }

  /**
   * A method that allows me to retrieve this particular field of the image class.
   *
   * @return the height of the image.
   */
  public int getHeight() {
    return this.height;
  }


  /**
   * A method that allows me to retrieve this particular field of the image class.
   *
   * @return the width of the image.
   */
  public int getWidth() {
    return this.width;
  }


  /**
   * A method that allows me to retrieve this particular field of the image class.
   *
   * @return the max of the image.
   */
  public int getMax() {
    return this.max;
  }


  /**
   * A method that allows me to retrieve a given Pixel from an image.
   *
   * @param row the row in which this Pixel is in.
   * @param col the column in which is Pixel is in.
   * @return the Pixel at the given coordinate.
   */
  public Pixel getPixelAt(int row, int col) {
    return this.image[row][col];
  }
}