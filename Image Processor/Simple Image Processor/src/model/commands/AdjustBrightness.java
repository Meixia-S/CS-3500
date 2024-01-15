package model.commands;

import model.Image;

import model.Pixel;

/**
 * This class implements the ICommand interface. It adjusts the brightness of the image according
 * to the "amount" which is given by the user.
 */
public class AdjustBrightness implements ICommand {
  private int amount;

  /**
   * The constructor that takes in both parameters the factor and isDarken.
   *
   * @param amount is the level/amount in which the user wants to brighten or darken an image.
   */
  public AdjustBrightness(int amount) {
    this.amount = amount;
  }

  @Override
  public Image execute(Image image) {
    Pixel[][] newPixelImage = new Pixel[image.getHeight()][image.getWidth()];
    Pixel pix;

    for (int row = 0; row < image.getHeight(); row ++) {
      for (int col = 0; col < image.getWidth(); col ++) {
        pix = new Pixel(image.getPixelAt(row, col).getR() + this.amount,
                image.getPixelAt(row, col).getG() + this.amount,
                image.getPixelAt(row, col).getB() + this.amount);
        newPixelImage[row][col] = pix;
      }
    }
    return new Image(image.getHeight(), image.getWidth(), image.getMax(), newPixelImage);
  }
}