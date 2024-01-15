package view;

import model.Image;

/**
 * This interface houses the methods required to start the program, load and save an image, refresh
 * the screen, and show any messages to the user.
 */
public interface IImageProcessView {

  /**
   * Sets the window and all the panels within it to true.
   */
  void visible();

  /**
   * Refreshes the screen so the user can see each edit they make to the image in real time.
   */
  void refresh(Image image);

  /**
   * Create a JFileChooser inorder that allows the user to pick the image they want to load.
   */
  String openFile();

  /**
   * Returns the input the user gives.
   */
  String saveImage();

  /**
   * Displays any given message to the user on a three-second timer.
   */
  void renderMessage(String message);
}