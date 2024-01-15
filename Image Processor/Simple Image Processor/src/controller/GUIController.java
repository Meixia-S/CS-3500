package controller;

import java.io.File;

import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import java.awt.Component;

import model.IImageProcessModel;
import model.commands.AdjustBrightness;
import model.commands.Clarity;
import model.commands.FlipImage;
import model.commands.Greyscale;
import model.commands.Visualize;
import view.IImageProcessView;

/**
 * The class that implements the IGUI interface. The GUIController calls upon the Model to run the
 * desired edits using ICommand classes. To do this, the controller takes in user inputs via the
 * view.
 */
public class GUIController implements IGUI {
  private IImageProcessModel model;
  private IImageProcessView view;

  /**
   * This constructor takes in two parameters, the model and view.
   *
   * @param model the part of the program that handles all the internal logic and operations for the
   *              program.
   * @param view  is the user interface where the user can interact with the program and make edits.
   * @throws IllegalStateException checks to see if either input is null.
   */
  public GUIController(IImageProcessModel model, IImageProcessView view)
          throws IllegalStateException {
    if (model == null || view == null) {
      throw new IllegalStateException("One or both inputs are null.");
    }

    this.model = model;
    this.view = view;

    start();
  }

  /**
   * Determines if the given inputs are null.
   *
   * @param commandName the name of the command being applied.
   * @param oldName     the name of the image the edit is being done to.
   * @param newName     name of the image.
   * @return if any one of them is, it returns true else it returns false.
   */
  private boolean isNull(String commandName, String oldName, String newName) {
    return (commandName == null || oldName == null || newName == null);
  }

  @Override
  public void start() {
    this.view.visible();
  }

  @Override
  public void open() {
    // changing the text for the left button to "open"
    UIManager.put("FileChooser.openButtonText", "open");

    String fileName = this.view.openFile();
    int charValue = (fileName.lastIndexOf("\\")) + 1;
    if (charValue < 0 || charValue > fileName.length() - 1) {
      charValue = 0;
    }
    String imageName;
    imageName = fileName.substring(charValue, fileName.length() - 4);
    new LoadImage().executeCommand(fileName, imageName, this.model);
  }

  @Override
  public void save() {
    // changing the text for the "open" button to "save"
    UIManager.put("FileChooser.openButtonText", "save");

    String imageName = this.view.saveImage();

    String fileName;
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(
            new FileNameExtensionFilter("Images", "ppm", "png", "jpg", "bmp"));

    if (fileChooser.showOpenDialog((Component) this.view) == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      fileName = file.getAbsolutePath();
      new SaveImage().executeCommand(fileName, model.getImage(imageName));
      this.view.renderMessage("Image Saved Successfully...");
    } else {
      this.view.renderMessage("Error Accrued When Loading Image..." + "\n" + "Please Try Again");
    }
  }

  @Override
  public void brightness(int factor, String oldName, String newName) {
    if (oldName == null || newName == null) {
      this.view.renderMessage("One Or All The Inputs Are Null");
    } else {
      this.model.runCommand(oldName, newName, new AdjustBrightness(factor));
      this.view.refresh(this.model.getImage(newName));
    }
  }

  @Override
  public void clarity(String commandName, String oldName, String newName) {
    if (!isNull(commandName, oldName, newName)) {
      this.model.runCommand(oldName, newName, new Clarity(commandName));
      this.view.refresh(this.model.getImage(newName));
    } else {
      this.view.renderMessage("One Or All The Inputs Are Null");
    }
  }

  @Override
  public void flip(String commandName, String oldName, String newName) {
    boolean flipInput = true;
    if (!isNull(commandName, oldName, newName)) {
      if (commandName.equals("horizontal")) {
        flipInput = false;
      } else if (commandName.equals("vertical")) {
        // we could reassign flipInput boolean to true again but that is redundant
      } else {
        this.view.renderMessage("One Or All The Inputs Are Null");
      }
      this.model.runCommand(oldName, newName, new FlipImage(flipInput));
      this.view.refresh(this.model.getImage(newName));
    }
  }

  @Override
  public void greyscale(String commandName, String oldName, String newName) {
    if (!isNull(commandName, oldName, newName)) {
      this.model.runCommand(oldName, newName, new Greyscale(commandName));
      this.view.refresh(this.model.getImage(newName));
    } else {
      this.view.renderMessage("One Or All The Inputs Are Null");
    }
  }

  @Override
  public void visualize(String commandName, String oldName, String newName) {
    if (!isNull(commandName, oldName, newName)) {
      this.model.runCommand(oldName, newName, new Visualize(commandName));
      this.view.refresh(this.model.getImage(newName));
    } else {
      this.view.renderMessage("One Or All The Inputs Are Null");
    }
  }
}