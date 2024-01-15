package model.commands;

import model.Image;

import model.Pixel;

/**
 * This class implements the ICommand interface. It grey-scales the image one of six ways.
 * The first option is red, second is green, third is blue, fourth is value, fifth is intensity,
 * and the sixth is luma.
 */
public class Visualize implements ICommand {
  String command;

  /**
   * The constructor that takes in one parameter, the command.
   *
   * @param command this indicates which type of greyscale is desired by the user.
   */
  public Visualize(String command) {
    this.command = command;
  }

  @Override
  public Image execute(Image image) {
    Pixel[][] newPixelImage = new Pixel[image.getHeight()][image.getWidth()];
    Pixel pix;
    int color = 0;
    double value = 0.0;

    for (int row = 0; row < image.getHeight(); row++) {
      for (int col = 0; col < image.getWidth(); col++) {
        if (this.command.equals("red-component")) {
          color = image.getPixelAt(row, col).getR();
        } else if (this.command.equals("green-component")) {
          color = image.getPixelAt(row, col).getG();
        } else if (this.command.equals("blue-component")) {
          color = image.getPixelAt(row, col).getB();
        } else if (this.command.equals("value-component")) {
          color = image.getPixelAt(row, col).maxValue();
        } else if (this.command.equals("intensity-component")) {
          // find the average of rgb then convert the double to an int
          // then set the int to color
          value = (image.getPixelAt(row, col).getR() +
                  image.getPixelAt(row, col).getG() +
                  image.getPixelAt(row, col).getB()) / 3.0;
          int value2 = (int) value;
          color = value2;
        } else if (this.command.equals("luma-component")) {
          value = (0.2126 * image.getPixelAt(row, col).getR()) +
                  (0.7152 * image.getPixelAt(row, col).getG()) +
                  (0.0722 * image.getPixelAt(row, col).getB());
          int value2 = (int) value;
          color = value2;
        }
        pix = new Pixel(color, color, color);
        newPixelImage[row][col] = pix;
      }
    }
    return new Image(image.getHeight(), image.getWidth(), image.getMax(), newPixelImage);
  }
}