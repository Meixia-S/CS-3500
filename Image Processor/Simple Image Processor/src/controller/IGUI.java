package controller;

/**
 * This interface houses the methods that handle the interaction between the user clicking
 * buttons and preforming the desired edits on an image.
 */
public interface IGUI {

  /**
   * Starts the program by setting the Window visibility to true.
   */
  void start();

  /**
   * Handles loading an image.
   */
  void open();

  /**
   * Handles saving the image.
   */
  void save();

  /**
   * Handles adjusting the brightness of the image.
   *
   * @return
   */
  void brightness(int factor, String newName, String imageName);

  /**
   * Handles adjusting the clarity of the image.
   * (Blur and Sharpen)
   */
  void clarity(String commandName,  String imagePath, String imageName);

  /**
   * Handles flipping the image.
   */
  void flip(String commandName, String newName, String imageName);

  /**
   * Handles grey scaling the image.
   * (greyscale and sepia)
   */
  void greyscale(String commandName, String newName, String imageName);

  /**
   * Handles the six different components supported for an image.
   */
  void visualize(String commandName, String newName, String imageName);
}