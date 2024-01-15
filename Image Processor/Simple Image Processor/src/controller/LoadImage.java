package controller;

import model.IImageProcessModel;

import model.Image;

/**
 * This class sole purpose is to load a particular Image from the Model's HashMap.
 */
public class LoadImage {

  /**
   * This method retrieves an Image with the imagePath from the Model's HashMap.
   *
   * @param imagePath the path in which the image is saved.
   * @param imageName the name of the image.
   * @param model the model class.
   */
  protected void executeCommand(String imagePath, String imageName, IImageProcessModel model) {
    Image image;
    if (imagePath.substring(imagePath.length() - 3).equals("ppm")) {
      image = PPMUtil.load(imagePath);
    } else {
      image = ImageUtil.load(imagePath);
    }

    // give this new image to the model to add to its Hashmap
    model.addImage(imageName, image);
  }
}