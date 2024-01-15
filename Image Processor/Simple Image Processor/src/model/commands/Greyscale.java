package model.commands;

import model.Image;

import model.Pixel;

/**
 * This class implements the ICommand interface. It applies the greyscale and sepia editing feature
 * on the given image.
 */
public class Greyscale implements ICommand {
  private String command;

  /**
   * The constructor that takes in one parameter, the command.
   *
   * @param command this indicates whether the user wants to blur or sharpen the image.
   */
  public Greyscale(String command) {
    this.command = command;
  }

  @Override
  public Image execute(Image image) {
    // setting the variables
    Pixel[][] newPixelImage = new Pixel[image.getHeight()][image.getWidth()];
    double[][] colorMatrix = new double[0][0];
    Pixel pix;
    double r;
    double newRedComponent;
    double g;
    double newGreenComponent;
    double b;
    double newBlueComponent;

    // determining which matrix to use based on the command
    if (command.equals("greyscale")) {
      colorMatrix = new double[][] {
              {0.2126, 0.7152, 0.0722},
              {0.2126, 0.7152, 0.0722},
              {0.2126, 0.7152, 0.0722}};

    } else if (command.equals("sepia")) {
      colorMatrix = new double[][] {
              {0.393, 0.769, 0.189},
              {0.349, 0.686, 0.168},
              {0.272, 0.534, 0.131}};
    }

    for (int row = 0; row < image.getHeight(); row++) {
      for (int col = 0; col < image.getWidth(); col++) {
        r = image.getPixelAt(row, col).getR();
        g = image.getPixelAt(row, col).getG();
        b = image.getPixelAt(row, col).getB();

        newRedComponent =
                ((r * colorMatrix[0][0]) + (g * colorMatrix[0][1]) + (b * colorMatrix[0][2]));
        newGreenComponent =
                ((r * colorMatrix[1][0]) + (g * colorMatrix[1][1]) + (b * colorMatrix[1][2]));
        newBlueComponent =
                ((r * colorMatrix[2][0]) + (g * colorMatrix[2][1]) + (b * colorMatrix[2][2]));

        pix = new Pixel((int)newRedComponent, (int)newGreenComponent, (int)newBlueComponent);
        newPixelImage[row][col] = pix;
      }
    }
    return new Image(image.getHeight(), image.getWidth(), image.getMax(), newPixelImage);
  }
}