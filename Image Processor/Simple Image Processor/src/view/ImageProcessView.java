package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;


import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.GUIController;
import controller.IGUI;

import model.ImageProcessModel;
import model.Image;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import javax.swing.Timer;

/**
 * The class that implements the IImageProcessView and ActionListener interface.
 * This class houses all the operations and setup of the user interface.
 */
public class ImageProcessView extends JFrame implements IImageProcessView, ActionListener {
  private Font buttonFont;
  private Font dropdownFont;
  private JComboBox clarityList;
  private JComboBox flipList;
  private JComboBox greyscaleList;
  private JComboBox visualizeList;
  private JLabel imageLabel;
  private String newName;
  private String oldName;
  private IGUI controller;
  private JPanel hisP;
  private Histogram histogram;

  /**
   * This constructor initializes the GUI view.
   */
  public ImageProcessView() {
    this.controller = new GUIController(new ImageProcessModel(), this);

    // setting the name, how the program can be ended, and the dimensions of the initial window.
    setTitle("Simple Image Processor");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(1000, 880));
    setResizable(false);
    setLayout(new BorderLayout());
    setVisible(true);

    // setting up the main panel and adding it to the window
    JPanel mainPanel = new JPanel();
    JPanel histogramPanel = new JPanel();
    mainPanel.setLayout(null);
    add(mainPanel);


    // setting up the sidebar that has all the buttons
    JPanel activityBar = new JPanel();
    activityBar.setBackground(Color.lightGray);
    activityBar.setBounds(0, 0, 250, 880);
    activityBar.setBorder(new EmptyBorder(25, 25, 25, 25));
    GridLayout layout = new GridLayout(9, 1);
    activityBar.setLayout(layout);

    buttonFont = new Font("times new roman", Font.PLAIN, 17);
    dropdownFont = new Font("times new roman", Font.ITALIC, 14);

    JPanel button1 = new JPanel();
    JButton open = new JButton("Open File");
    open.setFont(buttonFont);
    open.setActionCommand("open");
    open.addActionListener(this);
    button1.add(open);

    JPanel button2 = new JPanel();
    JButton save = new JButton("Save File");
    save.setFont(buttonFont);
    save.setActionCommand("save");
    save.addActionListener(this);
    button2.add(save);

    JPanel button3 = new JPanel();
    JButton brightness = new JButton("Brightness");
    brightness.setFont(buttonFont);
    brightness.setActionCommand("brightness");
    brightness.addActionListener(this);
    button3.add(brightness);

    JPanel button4 = new JPanel();
    button4.setLayout(new GridLayout(2, 1));
    button4.setBorder(new EmptyBorder(10, 50, 10, 50));
    JButton clarity = new JButton("Clarity");
    clarity.setFont(buttonFont);
    clarity.setActionCommand("clarity");
    clarity.addActionListener(this);
    button4.add(clarity);
    String[] clarityL = new String[]{"blur", "sharpen"};
    clarityList = new JComboBox(clarityL);
    clarityList.setFont(dropdownFont);
    clarityList.addActionListener(this);
    button4.add(clarityList);

    JPanel button5 = new JPanel();
    button5.setLayout(new GridLayout(2, 1));
    button5.setBorder(new EmptyBorder(10, 50, 10, 50));
    JButton flip = new JButton("Flip");
    flip.setFont(buttonFont);
    flip.setActionCommand("flip");
    flip.addActionListener(this);
    button5.add(flip);
    String[] flipL = new String[]{"horizontal", "vertical"};
    flipList = new JComboBox(flipL);
    flipList.setFont(dropdownFont);
    flipList.addActionListener(this);
    button5.add(flipList);

    JPanel button6 = new JPanel();
    button6.setLayout(new GridLayout(2, 1));
    button6.setBorder(new EmptyBorder(10, 50, 10, 50));
    JButton greyscale = new JButton("Greyscale");
    greyscale.setFont(buttonFont);
    greyscale.setActionCommand("greyscale");
    greyscale.addActionListener(this);
    button6.add(greyscale);
    String[] greyscaleL = new String[]{"greyscale", "sepia"};
    greyscaleList = new JComboBox(greyscaleL);
    greyscaleList.setFont(dropdownFont);
    greyscaleList.addActionListener(this);
    button6.add(greyscaleList);

    JPanel button7 = new JPanel();
    JButton visualize = new JButton("Visualize");
    visualize.setFont(buttonFont);
    visualize.setActionCommand("visualize");
    visualize.addActionListener(this);
    button7.add(visualize);
    String[] visualizeL = new String[]{"red-component", "green-component", "blue-component",
        "value-component", "intensity-component", "luma-component"};
    visualizeList = new JComboBox(visualizeL);
    visualizeList.setFont(dropdownFont);
    visualizeList.addActionListener(this);
    button7.add(visualizeList);

    JPanel button8 = new JPanel();
    JButton guide = new JButton("Guide");
    guide.setFont(buttonFont);
    guide.setActionCommand("guide");
    guide.addActionListener(this);
    button8.add(guide);

    // adding all the Button panels to the activityBar
    activityBar.add(button1);
    activityBar.add(button2);
    activityBar.add(button3);
    activityBar.add(button4);
    activityBar.add(button5);
    activityBar.add(button6);
    activityBar.add(button7);
    activityBar.add(button8);
    mainPanel.add(activityBar);


    // adding the panel that houses the image being edited (implements JScrollPanel)
    JPanel imagePanel = new JPanel();
    imagePanel.setBackground(Color.white);
    imagePanel.setBounds(244, -4, 750, 600);
    imageLabel = new JLabel(new ImageIcon());
    JScrollPane scroller = new JScrollPane(imageLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroller.setPreferredSize(new Dimension(742, 600));
    scroller.setViewportView(imageLabel);
    imagePanel.add(scroller);
    mainPanel.add(imagePanel);


    // adding the panel and space for the histogram
    histogramPanel = new JPanel();
    histogramPanel.setBackground(Color.darkGray);
    String histogramTitle = "Image Histogram";
    Font histogramFont = new Font("times new roman", Font.ITALIC, 15);
    Color histogramColor = Color.white;
    TitledBorder titledBorder = (BorderFactory.createTitledBorder(null, histogramTitle,
            TitledBorder.LEFT, TitledBorder.TOP, histogramFont, histogramColor));
    histogramPanel.setBorder(titledBorder);
    histogramPanel.setBounds(250, 600, 736, 186);
    // tried to add histogram to the window/panels.
    //histogramPanel.add(histogram);

    mainPanel.add(histogramPanel);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "open":
        this.controller.open();
        break;
      case "save":
        this.controller.save();
        break;
      case "clarity":
        String cInput = (String) clarityList.getSelectedItem();
        newName = getNewName();
        oldName = getOldName(newName);
        this.controller.clarity(cInput, oldName, newName);
        break;
      case "brightness":
        // making a new frame for user input
        JFrame bInput = new JFrame("Add Factor");
        String inputV = JOptionPane.showInputDialog(bInput, "Please Enter An Integer:");
        int inputVale = 0;
        try {
          inputVale = Integer.parseInt(inputV);
        } catch (NumberFormatException c) {
          renderMessage("Please Enter An Integer. \n   No Strings Or Symbols Are Allowed.");
          return;
        }
        newName = getNewName();
        oldName = getOldName(newName);
        this.controller.brightness(inputVale, oldName, newName);
        break;
      case "flip":
        String fInput = (String) flipList.getSelectedItem();
        newName = getNewName();
        oldName = getOldName(newName);
        this.controller.flip(fInput, oldName, newName);
        break;
      case "greyscale":
        String gInput = (String) greyscaleList.getSelectedItem();
        newName = getNewName();
        oldName = getOldName(newName);
        this.controller.greyscale(gInput, oldName, newName);
        break;
      case "visualize":
        String vInput = (String) visualizeList.getSelectedItem();
        newName = getNewName();
        oldName = getOldName(newName);
        this.controller.visualize(vInput, oldName, newName);
        break;
      case "guide":
        // making text panel for the guide
        JFrame guide = new JFrame("Guide For The Simple Image Processor");
        guide.setSize(new Dimension(580, 450));
        JTextArea messageArea = new JTextArea(0, 200);
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.append(" Thank you for using our simple image processor! :)"
                +
                "\n Here are the supported commands and how to use them: \n"
                +
                "\n Brightness: brightens or darkens an image"
                +
                        "\n                   (use a negative integer to darken an image) \n"
                +
                "\n Clarity: changes the quality of the image \n"
                +
                "\n Flip: vertical flips the image on the x-axis"
                +
                        "\n         horizontal flips the image on the y-axis \n"
                +
                "\n Greyscale: greyscale turns the image colors into shades of black, "
                +
                "grey, and white"
                +
                "\n                  sepia adds a yellow hue, thereby making the image grey "
                +
                "and yellow \n"
                +
                "\n Visualize: red-component makes the image grey based on the red hue"
                +
                "\n                 green-component makes the image grey based on the green hue"
                +
                "\n                 blue-component makes the image grey based on the blur hue"
                +
                "\n                 value-component makes the image grey by using the highest rbg"
                +
                                  " value"
                +
                "\n                 intensity-component the makes image grey by averaging rbg "
                +
                                  "values"
                +
                "\n                 luma-component makes the image grey by applying an equation to "

                +
                "the rgb values \n"
                +
                "\n Naming convention is VERY important for this program. "
                +
                "\n You must use the original name when creating a new name for an edited image."
                +
                "\n Example: blur Donkey Donkey-blur  (command  oldName  newName) ");
        messageArea.setFont(dropdownFont);
        guide.add(messageArea);
        guide.setVisible(true);
        break;
      default:
        this.renderMessage("Not supported");
    }
  }

  @Override
  public void visible() {
    setVisible(true);
  }

  @Override
  public void refresh(Image image) {
    BufferedImage buffImage = new BufferedImage(image.getWidth(), image.getHeight(), TYPE_INT_RGB);

    for (int col = 0; col < buffImage.getHeight(); col++) {
      for (int row = 0; row < buffImage.getWidth(); row++) {
        Color color = new Color(
                image.getPixelAt(col, row).getR(),
                image.getPixelAt(col, row).getG(),
                image.getPixelAt(col, row).getB());
        buffImage.setRGB(row, col, color.getRGB());
      }
    }
    try {
      ImageIcon iconImage = new ImageIcon(buffImage);
      imageLabel.setIcon(iconImage);
    } catch (Exception e) {
      renderMessage("Refresh Failed");
      return;
    }
  }

  @Override
  public String openFile() {
    JFileChooser fileChooser = new JFileChooser();
    String fileName = null;
    fileChooser.setFileFilter(
            new FileNameExtensionFilter("Images", "ppm", "png", "jpg", "bpm"));
    if (fileChooser.showOpenDialog((Component) this) == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      fileName = file.getAbsolutePath();
      try {
        BufferedImage buffImage = ImageIO.read(file);
        ImageIcon iconImage = new ImageIcon(buffImage);
        imageLabel.setIcon(iconImage);
        repaint();
        renderMessage("Loaded Image Successfully...");
      } catch (IOException e) {
        renderMessage("Error Accrued When Loading Image..." + "\n" + "Please Try Again");
      }
    }
    return fileName;
  }

  @Override
  public String saveImage() {
    return newName;
  }

  @Override
  public void renderMessage(String message) {
    JFrame frame = new JFrame("Message");
    frame.setSize(new Dimension(450, 100));
    JTextArea area = new JTextArea(0, 100);

    area.setEditable(false);
    area.setLineWrap(true);
    area.append("  " + message);
    area.setFont(buttonFont);
    frame.add(area);
    frame.setVisible(true);

    // gets any message that appear to disappear after 3 seconds
    Timer timer = new Timer(3000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
      }
    });
    timer.start();
  }

  /**
   * Gets the user's input from a JOptionPane.
   *
   * @return the input the user gave
   */
  private String getNewName() {
    JFrame input = new JFrame("New Name");
    newName = JOptionPane.showInputDialog(input, "Please Enter A New Name For This Image:");
    if (!newName.contains("-")) {
      renderMessage("Please Make Sure To Use A Dash After The Original Name: " +
              "\n        Current Name Has NOT Been Saved!");
      newName = JOptionPane.showInputDialog(input,
              "Please Enter A New Name For This Image:");
    }
    return newName;
  }

  /**
   * Calculates the original name of the image.
   *
   * @param newName the new name the user assigns to the image.
   * @return the old name.
   */
  private String getOldName(String newName) {
    int first = newName.indexOf("-");
    int last = newName.lastIndexOf("-");

    // This if statement checks to see how many dashes there are in the newName
    // If there is only one, we know the original name is before the dash.
    // If there are more than one, we know the original name is right before the last dash.
    if (first == last) {
      oldName = newName.substring(0, first);
    } else {
      oldName = newName.substring(0, last);
    }
    return (oldName);
  }
}