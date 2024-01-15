package model;

import org.junit.Before;
import org.junit.Test;

import model.commands.AdjustBrightness;

import model.commands.ICommand;

import static org.junit.Assert.assertEquals;

/**
 * A class that tests the methods in the ImageProcessModel class.
 */
public class ImageProcessModelTest {

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
  Pixel pD1;
  Pixel pD2;
  Pixel pD3;
  Pixel pD4;
  Pixel pD5;
  Pixel pD6;
  Pixel pD7;
  Pixel pD8;
  Pixel pD9;

  // Example 2D Pixel Arrays
  Pixel[][] pixelArray1;
  Pixel[][] pixelArray2;

  // Example Images
  Image image1;
  Image image2;

  // Example Command
  ICommand c1;

  // Example Model Constructor
  IImageProcessModel m1;

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

    this.pD1 = new Pixel(0, 0, 0);
    this.pD2 = new Pixel(1, 1, 1);
    this.pD3 = new Pixel(2, 2, 2);
    this.pD4 = new Pixel(3, 3, 3);
    this.pD5 = new Pixel(4, 4, 4);
    this.pD6 = new Pixel(5, 5, 5);
    this.pD7 = new Pixel(0, 1, 2);
    this.pD8 = new Pixel(0, 1, 2);
    this.pD9 = new Pixel(1, 2, 3);

    this.pixelArray1 = new Pixel[3][3];
    this.pixelArray1[0] = new Pixel[]{this.p1, this.p2, this.p3};
    this.pixelArray1[1] = new Pixel[]{this.p4, this.p5, this.p6};
    this.pixelArray1[2] = new Pixel[]{this.p7, this.p8, this.p9};

    this.pixelArray2 = new Pixel[3][3];
    this.pixelArray2[0] = new Pixel[]{this.pD1, this.pD2, this.pD3};
    this.pixelArray2[1] = new Pixel[]{this.pD4, this.pD5, this.pD6};
    this.pixelArray2[2] = new Pixel[]{this.pD7, this.pD8, this.pD9};

    this.image1 = new Image(this.heightImage1, this.widthImage1, this.max, this.pixelArray1);
    this.image2 = new Image(this.heightImage1, this.widthImage1, this.max, this.pixelArray2);

    this.c1 = new AdjustBrightness(-1);

    this.m1 = new ImageProcessModel();
  }

  // Testing if an image is added to the log
  @Test
  public void testAddImage() {
    m1.addImage("Hello World", this.image1);
    assertEquals(true, this.image1 == m1.getImage("Hello World"));
  }

  // Testing if the correct image has been retrieved
  @Test
  public void testGetImage() {
    m1.addImage("Hello World", this.image1);
    assertEquals(this.image1, m1.getImage("Hello World"));
  }

  // Testing if the correct command is executed and added to the Hashmap
  @Test
  public void testRunCommand() {
    m1.addImage("Hello World", this.image1);
    m1.runCommand("Hello World", "Hello World-Darken", this.c1);
    assertEquals(this.image2, m1.getImage("Hello World Darken"));
  }
}