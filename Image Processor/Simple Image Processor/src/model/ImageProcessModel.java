package model;

import java.util.Map;

import java.util.HashMap;

import model.commands.ICommand;

/**
 * This class implements the IImageProcessModel interface. It houses the log of images users would
 * be loading, editing, and editing. User can access HashMap values and add to it as well.
 */
public class ImageProcessModel implements IImageProcessModel {
  // the log that keeps track of all the images the user wants
  private Map<String, Image> imageLog;

  /**
   * A Constructor that takes in zero parameters but initiates the imageLog, which houses image
   * names' and images.
   */
  public ImageProcessModel() {
    this.imageLog = new HashMap<>();
  }

  @Override
  public void addImage(String imageName, Image image) {
    this.imageLog.put(imageName, image);
  }

  @Override
  public Image getImage(String imageName) {
    return this.imageLog.get(imageName);
  }

  @Override
  public void runCommand(String oldName, String newName, ICommand command) {
    this.imageLog.put(newName, command.execute(imageLog.get(oldName)));
  }
}