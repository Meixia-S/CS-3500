package model;

import model.commands.ICommand;

/**
 * Defines the set of image processing commands that can be carried out by all types of image
 * processing models like saving an image and running an unspecified list of commands.
 */
public interface IImageProcessModel {

  /**
   * Stores the given image in the HashMap.
   *
   * @param imageName name of the Image which are the Key to the HashMap.
   * @param image the Image that is being added to the HashMap.
   */
  public void addImage(String imageName, Image image);

  /**
   * Retrieves an Image from the HashMap via the Key (aka. imageName).
   *
   * @param imageName name of the Image which are the Key to the HashMap.
   */
  public Image getImage(String imageName);

  /**
   * Runs the desired command on the given image.
   *
   * @param newName the new name for the image after the edit is done.
   * @param imageName the name of the image which is the Key to the Image.
   * @param command the given command from the user to dictates which edit is done upon the Image.
   */
  public void runCommand(String newName, String imageName, ICommand command);
}