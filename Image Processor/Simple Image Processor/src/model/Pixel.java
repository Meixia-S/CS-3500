package model;

/**
 * This class represents a singular Pixel.
 */
public class Pixel {
  private int r;
  private int g;
  private int b;

  /**
   * A constructor that takes in three parameters the red pigment, green pigment, and blue pigment.
   *
   * @param r the red pigment of the Pixel.
   * @param g the green pigment of the Pixel.
   * @param b the blue pigment of the Pixel.
   */
  public Pixel(int r, int g, int b) {
    if (r < 0) {
      r = 0;
    }
    if (r > 255) {
      r = 255;
    }
    if (g < 0) {
      g = 0;
    }
    if (g > 255) {
      g = 255;
    }
    if (b < 0) {
      b = 0;
    }
    if (b > 255) {
      b = 255;
    }

    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * A method that allows me to retrieve this particular field of the Pixel class.
   *
   * @return the red pigment of the Pixel.
   */
  public int getR() {
    return this.r;
  }

  /**
   * A method that allows me to retrieve this particular field of the Pixel class.
   *
   * @return the green pigment of the Pixel.
   */
  public int getG() {
    return this.g;
  }

  /**
   * A method that allows me to retrieve this particular field of the Pixel class.
   *
   * @return the blue pigment of the Pixel.
   */
  public int getB() {
    return this.b;
  }

  /**
   *  A method that finds the largest value of rgb in a Pixel.
   *
   * @return the largest value of rgb.
   */
  public int maxValue() {
    int greaterColor = Math.max(r, g);
    int color = Math.max(greaterColor, b);
    return color;
  }
}