package controller;

/**
 * The interface that houses the method that the controller can operate.
 */
public interface IImageProcessController {

  /**
   * This runs the program that takes in user's input and then executes the commanded operations.
   *
   * @throws IllegalArgumentException if the given command has not been accounted for or does not
   *                                  exist.
   */
  public void run() throws IllegalArgumentException;
}