package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Image;
import model.Pixel;

/**
 * This class sole purpose is to save a given Image by converting it into a PPM file.
 */
public class SaveImage {

  /**
   * This method converts the given Image into a PPM file and puts into the given imagePath.
   *
   * @param imagePath the new path the Image should be saved to, with the new name at the end of
   *                  the filepath.
   * @param image     the Image the user wants to save.
   */
  protected void executeCommand(String imagePath, Image image) {
    // add an interface
    if (imagePath.substring(imagePath.length() - 3).equals("ppm")) {
      ppmSave(imagePath, image);
    } else {
      otherSave(imagePath, image);
    }
  }

  /**
   * This method process an image, turns data into the correct PPM format, then creates a new file
   * and saves the image in it with the given name.
   *
   * @param imagePath the path the image needs to be saved at.
   * @param image     the image that is currently being saved
   */
  private void ppmSave(String imagePath, Image image) {

    String pixelString = "";
    Pixel pixel;
    for (int row = 0; row < image.getHeight(); row++) {
      for (int col = 0; col < image.getWidth(); col++) {
        pixel = image.getPixelAt(row, col);
        pixelString = pixelString + pixel.getR() + "\n" +
                pixel.getG() + "\n" + pixel.getB() + "\n";
      }
    }

    try {
      File myObj = new File(imagePath);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        //if creating the file works, try to write to it
        try {
          FileWriter file = new FileWriter(imagePath);
          file.write("P3" + "\n" + image.getWidth() + " " + image.getHeight() + "\n" +
                  image.getMax() + "\n" + pixelString);
          file.close();
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("Save: An error occurred when creating the file.");
      e.printStackTrace();
    }
  }

  /**
   * This method process an image, creates a new file, and saves the image in it with the given
   * name.
   *
   * @param imagePath the path the image needs to be saved at.
   * @param image     the image that is currently being saved
   */
  private void otherSave(String imagePath, Image image) {
    // setting the variable
    Pixel pix;
    int r;
    int g;
    int b;
    String imageType = imagePath.substring(imagePath.length() - 3);

    try {
      BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(),
              BufferedImage.TYPE_INT_RGB);

      for (int row = 0; row < image.getHeight(); row++) {
        for (int col = 0; col < image.getWidth(); col++) {
          pix = image.getPixelAt(row, col);
          r = pix.getR();
          g = pix.getG();
          b = pix.getB();
          Color color = new Color(r, g, b);
          bi.setRGB(col, row, color.getRGB());
        }
      }
      File outputFile = new File(imagePath);
      ImageIO.write(bi, imageType, outputFile);
    } catch (IOException e) {
      throw new IllegalStateException("Image not saved");
    }
  }
  // With this class we decided to only have one Save class as all the needed operations can be
  // done basically within 100 lines of code. Unlike load where PPMUtil class is over 100 lines
  // on its own.
}