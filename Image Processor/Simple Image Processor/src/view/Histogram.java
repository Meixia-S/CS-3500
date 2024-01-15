package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import model.Image;

import javax.swing.JPanel;

import static java.awt.Color.blue;
import static java.awt.Color.green;
import static java.awt.Color.red;

/**
 * This class represents the histogram that show the frequency of each rgb value of the image.
 */
public class Histogram extends JPanel {
  private final int BarWidth = 1;
  private Image image;
  private ArrayList<Integer> graphRed;
  private ArrayList<Integer> graphGreen;
  private ArrayList<Integer> graphBlue;

  /**
   * Counts the frequency of each pixel color value(rgb).
   *
   * @param arr the list of the pixel rgb value.
   * @return an array that has the frequency of each value between 0 - 255.
   */
  private ArrayList<Integer> organize(ArrayList<Integer> arr) {
    ArrayList<Integer> graph = new ArrayList<Integer>();
    for (int i = 0; i < image.getMax(); i++) {
      int count2 = 0;
      for (int j = 0; j < arr.size(); j++) {
        if (arr.get(j) == i) {
          count2++;
        }
        graph.set(j, count2);
      }
    }
    return graph;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics = (Graphics2D) g.create();
    graphics.setColor(Color.WHITE);

    for (Integer num : graphRed) {
      Rectangle2D bar = new Rectangle2D.Float((float) (num * (image.getWidth() / 255)),
              image.getHeight() - (float) Math.min(255, graphRed.indexOf(num) * .10), BarWidth,
              (float) Math.min(255, graphRed.indexOf(num) * 0.05));
      graphics.setPaint(red);
      graphics.fill(bar);
      graphics.draw(bar);
    }

    for (Integer num : graphGreen) {
      Rectangle2D bar = new Rectangle2D.Float((float) (num * (image.getWidth() / 255)),
              image.getHeight() - (float) Math.min(255, graphGreen.indexOf(num) * .10),
              BarWidth, (float) Math.min(255, graphGreen.indexOf(num) * 0.05));
      graphics.setPaint(green);
      graphics.fill(bar);
      graphics.draw(bar);
    }

    for (Integer num : graphBlue) {
      Rectangle2D bar = new Rectangle2D.Float((float) (num * (image.getWidth() / 255)),
              image.getHeight() - (float) Math.min(255, graphBlue.indexOf(num) * .10),
              BarWidth, (float) Math.min(255, graphBlue.indexOf(num) * 0.10));
      graphics.setPaint(blue);
      graphics.fill(bar);
      graphics.draw(bar);

    }
  }

  private void setImage(Image image) {
    ArrayList<Integer> redComp = new ArrayList<Integer>();
    ArrayList<Integer> greenComp = new ArrayList<Integer>();
    ArrayList<Integer> blueComp = new ArrayList<Integer>();

    int count = 0;

    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int pixValueR = image.getPixelAt(i, j).getR();
        int pixValueG = image.getPixelAt(i, j).getG();
        int pixValueB = image.getPixelAt(i, j).getB();
        redComp.add(pixValueR);
        greenComp.add(pixValueG);
        blueComp.add(pixValueB);
        count++;
      }
    }
    this.graphRed = organize(redComp);
    this.graphGreen = organize(greenComp);
    this.graphBlue = organize(blueComp);
  }
}