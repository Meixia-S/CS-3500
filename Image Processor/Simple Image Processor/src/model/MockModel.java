package model;

import java.util.Objects;
import model.commands.ICommand;

/**
 * This class implements the IImageProcessModel interface. It is a mock model of
 * ImageProcessorModel. This class appends to a log whenever the methods are called.
 *
 */
public class MockModel implements IImageProcessModel {

  final StringBuilder log;

  /**
   * A constructor that takes zero parameters and initiates a log.
   * This log keeps track of model usage.
   *
   */
  public MockModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  @Override
  public void addImage(String imageName, Image image) {
    log.append("add image " + imageName + "\n");

  }

  @Override
  public Image getImage(String imageName) {
    log.append("get image " + imageName + "\n");
    return null;
  }

  @Override
  public void runCommand(String imagePath, String imageName, ICommand command) {
    log.append("command ran on " + imageName + "\n");
  }
}
