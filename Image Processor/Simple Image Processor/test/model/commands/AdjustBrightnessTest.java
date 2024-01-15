package model.commands;

import org.junit.Before;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import model.Image;

import model.Pixel;

/**
 * A class that tests the method in the AdjustBrightness class.
 */
public class AdjustBrightnessTest {

  // Example image height
  int heightImage1;

  // Example image width
  int widthImage1;

  // Example image max value
  int max;

  // Example Pixels Before
  Pixel p1;
  Pixel p2;
  Pixel p3;
  Pixel p4;
  Pixel p5;
  Pixel p6;
  Pixel p7;
  Pixel p8;
  Pixel p9;

  // Example 2D Pixel Arrays
  Pixel[][] pixelArray1;

  // Example Images
  Image image;

  @Before
  public void init() {
    this.heightImage1 = 3;
    this.widthImage1 = 3;
    this.max = 255;

    this.p1 = new Pixel(1, 1, 1);
    this.p2 = new Pixel(2, 2, 2);
    this.p3 = new Pixel(3, 3, 3);
    this.p4 = new Pixel(4, 4, 4);
    this.p5 = new Pixel(5, 5, 5);
    this.p6 = new Pixel(6, 6, 6);
    this.p7 = new Pixel(1, 2, 3);
    this.p8 = new Pixel(2, 3, 4);
    this.p9 = new Pixel(3, 4, 5);

    this.pixelArray1 = new Pixel[3][3];
    this.pixelArray1[0] = new Pixel[] {this.p1, this.p2, this.p3};
    this.pixelArray1[1] = new Pixel[] {this.p4, this.p5, this.p6};
    this.pixelArray1[2] = new Pixel[] {this.p7, this.p8, this.p9};

    this.image = new Image(this.heightImage1, this.widthImage1, this.max, this.pixelArray1);
  }

  // Test brighten with an image
  @Test
  public void testBrightness() {
    Image newImage = new AdjustBrightness(20).execute(this.image);

    assertEquals(21, newImage.getPixelAt(0, 0).getR());
    assertEquals(21, newImage.getPixelAt(0, 0).getG());
    assertEquals(21, newImage.getPixelAt(0, 0).getB());

    assertEquals(25, newImage.getPixelAt(1, 1).getR());
    assertEquals(25, newImage.getPixelAt(1, 1).getG());
    assertEquals(25, newImage.getPixelAt(1, 1).getB());

    assertEquals(23, newImage.getPixelAt(2, 2).getR());
    assertEquals(24, newImage.getPixelAt(2, 2).getG());
    assertEquals(25, newImage.getPixelAt(2, 2).getB());
  }

  // Test darken with an image
  @Test
  public void testExecuteDarken() {
    Image newImage = new AdjustBrightness(-1).execute(this.image);

    assertEquals(0, newImage.getPixelAt(0, 0).getR());
    assertEquals(0, newImage.getPixelAt(0, 0).getG());
    assertEquals(0, newImage.getPixelAt(0, 0).getB());

    assertEquals(4, newImage.getPixelAt(1, 1).getR());
    assertEquals(4, newImage.getPixelAt(1, 1).getG());
    assertEquals(4, newImage.getPixelAt(1, 1).getB());

    assertEquals(2, newImage.getPixelAt(2, 2).getR());
    assertEquals(3, newImage.getPixelAt(2, 2).getG());
    assertEquals(4, newImage.getPixelAt(2, 2).getB());
  }
}