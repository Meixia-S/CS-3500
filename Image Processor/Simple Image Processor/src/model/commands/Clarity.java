package model.commands;

import model.Image;

import model.Pixel;


/**
 * This class implements the ICommand interface. It blurs or sharpens the given image.
 */
public class Clarity implements ICommand {
  String command;

  /**
   * The constructor that takes in one parameter, the command.
   *
   * @param command this indicates whether the user wants to blur or sharpen the image.
   */
  public Clarity(String command) {
    this.command = command;
  }

  @Override
  public Image execute(Image image) {
    // setting the variables
    Pixel[][] newPixelImage = new Pixel[image.getHeight()][image.getWidth()];
    double[][] kernel = new double[0][0];
    Pixel pix;
    double r = 0.0;
    double g = 0.0;
    double b = 0.0;

    // determining which Kernel to use based on the command
    if (command.equals("blur")) {
      // creating the Kernel size 3x3
      kernel = new double[][]{
              {0.0625, 0.125, 0.0625},
              {0.125, 0.250, 0.125},
              {0.0625, 0.125, 0.0625}};
    }
    else if (command.equals("sharpen")) {
      // creating the Kernel size 5x5
      kernel = new double[][] {
              {-0.125, -0.125, -0.125, -0.125, -0.125},
              {-0.125, 0.250, 0.250, 0.250, -0.125},
              {-0.125, 0.250, 1.00, 0.250, -0.125},
              {-0.125, 0.250, 0.250, 0.250, -0.125},
              {-0.125, -0.125, -0.125, -0.125, -0.125}};
    }

    // traversing the image
    for (int row = 0; row < image.getHeight(); row++) {
      for (int col = 0; col < image.getWidth(); col++) {
        int currKRow = 0;
        // traversing the Kernel
        for (int krow = row - (kernel.length / 2); krow <=  row + (kernel.length / 2); krow++) {
          int currKCol = 0;
          for (int kcol = col - (kernel.length / 2); kcol <= col + (kernel.length / 2); kcol++) {
            if (krow < 0 || krow >= image.getHeight() || kcol < 0 || kcol >= image.getWidth()) {
              // checks to see if the location of the kernel is within the bounds of the image. If
              // it is not, then we do nothing.
            } else {
              // keeping a running tab on the rbg values and keep adding to them
              pix = image.getPixelAt(krow, kcol);
              r += kernel[currKRow][currKCol] * (double) pix.getR();
              g += kernel[currKRow][currKCol] * (double) pix.getG();
              b += kernel[currKRow][currKCol] * (double) pix.getB();
            }
            currKCol++;
          }
          currKRow++;
        }
        pix = new Pixel((int) r, (int) g,(int) b);
        newPixelImage[row][col] = pix;

        // resetting the rgb values
        r = 0.0;
        g = 0.0;
        b = 0.0;
      }
    }
    return new Image(image.getHeight(), image.getWidth(), image.getMax(), newPixelImage);
  }
}