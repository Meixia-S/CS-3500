package view;

import model.Image;

/**
 * Mock view that is used for testing.
 */
public class MockView implements IImageProcessView {
  final StringBuilder log;

  /**
   * A constructor that takes in one parameter, the log.
   *
   * @param log a stringBuilder to see if the communication between the controller and view is
   *            working correctly.
   */
  public MockView(StringBuilder log) {
    this.log = new StringBuilder();
  }

  @Override
  public void visible() {
    log.append("Visible method hit\n");
  }

  @Override
  public void refresh(Image image) {
    log.append("Refresh method hit\n");
  }

  @Override
  public String openFile() {
    log.append("File opened in view\n");
    return null;
  }

  @Override
  public String saveImage() {
    log.append("File saved in view\n");
    return null;
  }

  @Override
  public void renderMessage(String message) {
    log.append("Message rendered: " + message);
  }
}