package model.commands;

import model.Image;

/**
 * An interface that houses the method that executes the desired editing of the images.
 */
public interface ICommand {

  /**
   * A method that executes the operations offered in the Controller (when running the program).
   * Current options are grey-scaling, adjusting the brightness, and flipping.
   *
   * @param image is the image that the user wishes to edit in some type of way.
   */
  public Image execute(Image image);
}

