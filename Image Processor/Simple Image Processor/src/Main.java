import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import controller.GUIController;
import controller.IGUI;
import controller.IImageProcessController;
import controller.ImageProcessController;
import model.IImageProcessModel;
import model.ImageProcessModel;
import view.IImageProcessView;
import view.ImageProcessView;

/**
 * The class that is used to run through the program to check its operations and get an idea of the
 * user's experience.
 */
public class Main {

  /**
   * The method that runs the program.
   *
   * @param args the user input.
   */
  public static void main(String[] args) {
    Readable read = new StringReader("");
    IImageProcessModel model = new ImageProcessModel();
    IImageProcessView view = new ImageProcessView();

    if (args.length == 0) {
      IGUI guiController = new GUIController(model, view);
      guiController.start();
    } else if (args[0].equals("-file")) {
      try {
        read = new FileReader(args[1]);
        IImageProcessController controller2 = new ImageProcessController(model, read);
        controller2.run();
      } catch (IOException e) {
        throw new IllegalArgumentException("File is not valid");
      }
    } else if (args[0].equals("IController")) {
      IImageProcessController controller3 = new ImageProcessController(model, read);
      controller3.run();
      // This allows the user to use the program in the format allowed in HW5, assuming they make a
      // configuration that starts with the word "IController" and no other text.
    }
  }
}