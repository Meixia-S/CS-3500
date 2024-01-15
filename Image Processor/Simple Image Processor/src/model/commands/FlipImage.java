package model.commands;

import model.Image;

import model.Pixel;

/**
 * This class implements the ICommand interface. It flips the image either vertically or
 * horizontally.
 */
public class FlipImage implements ICommand {
  private boolean isVertical;

  /**
   * The constructor that takes in one parameter, isDarken.
   *
   * @param isVertical determines whether-or-not the image should be flipped vertically or
   *                   horizontally.
   **/
  public FlipImage(boolean isVertical) {
    this.isVertical = isVertical;
  }

  @Override
  public Image execute(Image image) {
    Pixel[][] newPixelImage = new Pixel[image.getHeight()][image.getWidth()];

    if (isVertical) {
      newPixelImage = vHelper(image, newPixelImage);
    } else {
      newPixelImage = hHelper(image, newPixelImage);
    }
    // creates new image and updates the name
    return new Image(image.getHeight(), image.getWidth(), image.getMax(), newPixelImage);
  }

  /**
   * A helper function that flips the image vertically by traversing the image starting from
   * the bottom left corner. Moving from left to right and up.
   *
   * @param image the image the user wishes to flip.
   * @return the new edited image that has been flipped.
   */
  private Pixel[][] vHelper(Image image, Pixel[][] newPixelImage) {
    Pixel vPix;
    int rowLoc = 0;

    for (int row = image.getHeight() - 1; row >= 0; row--) {
      for (int col = 0; col < image.getWidth(); col++) {
        vPix = image.getPixelAt(row, col);
        newPixelImage[rowLoc][col] = vPix;
      }
      rowLoc ++;
    }
    return newPixelImage;
  }

  /**
   * A helper method that flips the image horizontally by traversing the image starting from
   * the upper right corner. Moving from right to left and down.
   *
   * @param image the image the user wishes to flip.
   * @return the new edited image that has been flipped.
   */
  private Pixel[][] hHelper(Image image, Pixel[][] newPixelImage) {
    Pixel hPix;
    int colLoc = 0;

    for (int col = image.getWidth() - 1; col >= 0; col --) {
      for (int row = 0; row < image.getHeight(); row ++) {
        hPix = image.getPixelAt(row, col);
        newPixelImage[row][colLoc] = hPix;
      }
      colLoc ++;
    }
    return newPixelImage;
  }
}