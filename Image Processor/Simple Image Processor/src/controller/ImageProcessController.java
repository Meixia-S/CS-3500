package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import model.IImageProcessModel;
import model.commands.AdjustBrightness;
import model.commands.Clarity;
import model.commands.FlipImage;
import model.commands.Greyscale;
import model.commands.ICommand;
import model.commands.Visualize;

/**
 * This class implements the IImageProcessController interface. The Controller calls upon the
 * Model and user inputs inorder to correctly execute the editing the user wants.
 */
public class ImageProcessController implements IImageProcessController {
  private IImageProcessModel model;
  private Appendable app;
  private Readable rd;

  /**
   * A constructor that takes in two parameters, a model and a Readable.
   *
   * @param model the model.
   * @param rd    the user input.
   * @throws IllegalArgumentException if either input is null.
   */
  public ImageProcessController(IImageProcessModel model, Readable rd)
          throws IllegalArgumentException {
    if (model == null || rd == null) {
      throw new IllegalArgumentException("One or more of the inputs is null.");
    }

    this.model = model;
    this.app = System.out;
    this.rd = rd;
  }

  /**
   * A constructor that takes in three parameters, a model, a Readable, and an Appendable.
   *
   * @param model the model.
   * @param rd    the user input.
   * @param app   the appendable object.
   * @throws IllegalArgumentException if either argument is null.
   */
  public ImageProcessController(IImageProcessModel model, Readable rd, Appendable app)
          throws IllegalArgumentException {
    if (model == null || rd == null || app == null) {
      throw new IllegalArgumentException("One or more of the inputs is null.");
    }

    this.model = model;
    this.app = app;
    this.rd = rd;
  }

  @Override
  public void run() throws IllegalArgumentException {
    Scanner scan = new Scanner(this.rd);
    Map<String, Function<Scanner, ICommand>> knownCommands;

    // adding the commands supported
    knownCommands = new HashMap<>();
    knownCommands.put("flip-vertical", s -> new FlipImage(true));
    knownCommands.put("flip-horizontal", s -> new FlipImage(false));
    knownCommands.put("brighten", s -> new AdjustBrightness(s.nextInt()));
    knownCommands.put("darken", s -> new AdjustBrightness(s.nextInt()));
    knownCommands.put("red-component", s -> new Visualize("red"));
    knownCommands.put("green-component", s -> new Visualize("green"));
    knownCommands.put("blue-component", s -> new Visualize("blue"));
    knownCommands.put("value-component", s -> new Visualize("value"));
    knownCommands.put("intensity-component", s -> new Visualize("intensity"));
    knownCommands.put("luma-component", s -> new Visualize("luma"));
    knownCommands.put("blur", s -> new Clarity("blur"));
    knownCommands.put("sharpen", s -> new Clarity("sharpen"));
    knownCommands.put("greyscale", s -> new Greyscale("greyscale"));
    knownCommands.put("sepia", s -> new Greyscale("sepia"));

    while (scan.hasNext()) {
      String input = scan.next();
      ICommand c;

      // quits the program if user types in q, Q, quit, or Quit.
      if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
        return;
      } else if (input.equalsIgnoreCase("load")) {
        new LoadImage().executeCommand(scan.next(), scan.next(), model);
        transmitMessage("The image has been loaded...");
      } else if (input.equalsIgnoreCase("save")) {
        try {
          new SaveImage().executeCommand(scan.next(), model.getImage(scan.next()));
          transmitMessage("The Image has been saved...");
        } catch (Exception e) {
          this.transmitMessage(e.getMessage());
        }
      } else {
        Function<Scanner, ICommand> command = knownCommands.getOrDefault(input, null);
        try {
          c = command.apply(scan);
          model.runCommand(scan.next(), scan.next(), c);
          this.transmitMessage("Command has been run...");
        } catch (Exception e) {
          this.transmitMessage(e.getMessage());
        }
      }
    }
  }

  /**
   * The helper method that displays the desired message to the user
   * (Takes the place of a View for this assignment).
   *
   * @param message a message that helps the user navigate the program.
   */
  private void transmitMessage(String message) {
    try {
      this.app.append(message + "\n");
    } catch (IOException e) {
      throw new IllegalArgumentException("Could not transmit message");
    }
  }
}