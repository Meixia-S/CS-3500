package model.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import org.junit.Test;

import model.Image;

import model.Pixel;

/**
 * A class that tests the method in the GreyScale class.
 */
public class VisualizeTest {
  // Example image height
  int heightImage2;

  // Example image width
  int widthImage1;
  int widthImage2;

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
  Pixel p10;
  Pixel p11;
  Pixel p12;

  // Example 2D Pixel Arrays
  Pixel[][] pixelArray;

  // Example Image
  Image image;

  @Before
  public void init() {
    this.heightImage2 = 3;

    this.widthImage2 = 4;

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
    this.p10 = new Pixel(4, 5, 6);
    this.p11 = new Pixel(5, 6, 7);
    this.p12 = new Pixel(6, 7, 8);

    this.pixelArray = new Pixel[3][4];
    this.pixelArray[0] = new Pixel[]{this.p1, this.p2, this.p3, this.p4};
    this.pixelArray[1] = new Pixel[]{this.p5, this.p6, this.p7, this.p8};
    this.pixelArray[2] = new Pixel[]{this.p9, this.p10, this.p11, this.p12};

    this.image = new Image(this.heightImage2, this.widthImage2, this.max, this.pixelArray);
  }

  // Testing the red-component
  @Test
  public void testRedComponent() {
    Image newImage = new Visualize("red").execute(this.image);

    assertEquals(1, newImage.getPixelAt(0, 0).getR());
    assertEquals(1, newImage.getPixelAt(0, 0).getG());
    assertEquals(1, newImage.getPixelAt(0, 0).getB());

    assertEquals(4, newImage.getPixelAt(0, 3).getR());
    assertEquals(4, newImage.getPixelAt(0, 3).getG());
    assertEquals(4, newImage.getPixelAt(0, 3).getB());

    assertEquals(3, newImage.getPixelAt(2, 0).getR());
    assertEquals(3, newImage.getPixelAt(2, 0).getG());
    assertEquals(3, newImage.getPixelAt(2, 0).getB());

    assertEquals(4, newImage.getPixelAt(2, 1).getR());
    assertEquals(4, newImage.getPixelAt(2, 1).getG());
    assertEquals(4, newImage.getPixelAt(2, 1).getB());

    assertEquals(5, newImage.getPixelAt(2, 2).getR());
    assertEquals(5, newImage.getPixelAt(2, 2).getG());
    assertEquals(5, newImage.getPixelAt(2, 2).getB());

    assertEquals(6, newImage.getPixelAt(2, 3).getR());
    assertEquals(6, newImage.getPixelAt(2, 3).getG());
    assertEquals(6, newImage.getPixelAt(2, 3).getB());
  }

  // Testing the green-component
  @Test
  public void testGreenComponent() {
    Image newImage = new Visualize("green").execute(this.image);

    assertEquals(1, newImage.getPixelAt(0, 0).getR());
    assertEquals(1, newImage.getPixelAt(0, 0).getG());
    assertEquals(1, newImage.getPixelAt(0, 0).getB());

    assertEquals(4, newImage.getPixelAt(0, 3).getR());
    assertEquals(4, newImage.getPixelAt(0, 3).getG());
    assertEquals(4, newImage.getPixelAt(0, 3).getB());

    assertEquals(4, newImage.getPixelAt(2, 0).getR());
    assertEquals(4, newImage.getPixelAt(2, 0).getG());
    assertEquals(4, newImage.getPixelAt(2, 0).getB());

    assertEquals(5, newImage.getPixelAt(2, 1).getR());
    assertEquals(5, newImage.getPixelAt(2, 1).getG());
    assertEquals(5, newImage.getPixelAt(2, 1).getB());

    assertEquals(6, newImage.getPixelAt(2, 2).getR());
    assertEquals(6, newImage.getPixelAt(2, 2).getG());
    assertEquals(6, newImage.getPixelAt(2, 2).getB());

    assertEquals(7, newImage.getPixelAt(2, 3).getR());
    assertEquals(7, newImage.getPixelAt(2, 3).getG());
    assertEquals(7, newImage.getPixelAt(2, 3).getB());
  }

  // Testing the blue-component
  @Test
  public void testBlueComponent() {
    Image newImage = new Visualize("blue").execute(this.image);

    assertEquals(1, newImage.getPixelAt(0, 0).getR());
    assertEquals(1, newImage.getPixelAt(0, 0).getG());
    assertEquals(1, newImage.getPixelAt(0, 0).getB());

    assertEquals(4, newImage.getPixelAt(0, 3).getR());
    assertEquals(4, newImage.getPixelAt(0, 3).getG());
    assertEquals(4, newImage.getPixelAt(0, 3).getB());

    assertEquals(5, newImage.getPixelAt(2, 0).getR());
    assertEquals(5, newImage.getPixelAt(2, 0).getG());
    assertEquals(5, newImage.getPixelAt(2, 0).getB());

    assertEquals(6, newImage.getPixelAt(2, 1).getR());
    assertEquals(6, newImage.getPixelAt(2, 1).getG());
    assertEquals(6, newImage.getPixelAt(2, 1).getB());

    assertEquals(7, newImage.getPixelAt(2, 2).getR());
    assertEquals(7, newImage.getPixelAt(2, 2).getG());
    assertEquals(7, newImage.getPixelAt(2, 2).getB());

    assertEquals(8, newImage.getPixelAt(2, 3).getR());
    assertEquals(8, newImage.getPixelAt(2, 3).getG());
    assertEquals(8, newImage.getPixelAt(2, 3).getB());
  }

  // Testing the value-component
  @Test
  public void testValueComponent() {
    Image newImage = new Visualize("value").execute(this.image);

    assertEquals(1, newImage.getPixelAt(0, 0).getR());
    assertEquals(1, newImage.getPixelAt(0, 0).getG());
    assertEquals(1, newImage.getPixelAt(0, 0).getB());

    assertEquals(4, newImage.getPixelAt(0, 3).getR());
    assertEquals(4, newImage.getPixelAt(0, 3).getG());
    assertEquals(4, newImage.getPixelAt(0, 3).getB());

    assertEquals(5, newImage.getPixelAt(2, 0).getR());
    assertEquals(5, newImage.getPixelAt(2, 0).getG());
    assertEquals(5, newImage.getPixelAt(2, 0).getB());

    assertEquals(6, newImage.getPixelAt(2, 1).getR());
    assertEquals(6, newImage.getPixelAt(2, 1).getG());
    assertEquals(6, newImage.getPixelAt(2, 1).getB());

    assertEquals(7, newImage.getPixelAt(2, 2).getR());
    assertEquals(7, newImage.getPixelAt(2, 2).getG());
    assertEquals(7, newImage.getPixelAt(2, 2).getB());

    assertEquals(8, newImage.getPixelAt(2, 3).getR());
    assertEquals(8, newImage.getPixelAt(2, 3).getG());
    assertEquals(8, newImage.getPixelAt(2, 3).getB());
  }

  // Testing the intensity-component
  @Test
  public void testIntensityComponent2() {
    Image newImage = new Visualize("intensity").execute(this.image);

    assertEquals(1, newImage.getPixelAt(0, 0).getR());
    assertEquals(1, newImage.getPixelAt(0, 0).getG());
    assertEquals(1, newImage.getPixelAt(0, 0).getB());

    assertEquals(4, newImage.getPixelAt(0, 3).getR());
    assertEquals(4, newImage.getPixelAt(0, 3).getG());
    assertEquals(4, newImage.getPixelAt(0, 3).getB());

    assertEquals(4, newImage.getPixelAt(2, 0).getR());
    assertEquals(4, newImage.getPixelAt(2, 0).getG());
    assertEquals(4, newImage.getPixelAt(2, 0).getB());

    assertEquals(5, newImage.getPixelAt(2, 1).getR());
    assertEquals(5, newImage.getPixelAt(2, 1).getG());
    assertEquals(5, newImage.getPixelAt(2, 1).getB());

    assertEquals(6, newImage.getPixelAt(2, 2).getR());
    assertEquals(6, newImage.getPixelAt(2, 2).getG());
    assertEquals(6, newImage.getPixelAt(2, 2).getB());

    assertEquals(7, newImage.getPixelAt(2, 3).getR());
    assertEquals(7, newImage.getPixelAt(2, 3).getG());
    assertEquals(7, newImage.getPixelAt(2, 3).getB());
  }

  // Testing the luma-component
  @Test
  public void testLumaComponent2() {
    Image newImage = new Visualize("luma").execute(this.image);

    assertEquals(1, newImage.getPixelAt(0, 0).getR());
    assertEquals(1, newImage.getPixelAt(0, 0).getG());
    assertEquals(1, newImage.getPixelAt(0, 0).getB());

    assertEquals(4, newImage.getPixelAt(0, 3).getR());
    assertEquals(4, newImage.getPixelAt(0, 3).getG());
    assertEquals(4, newImage.getPixelAt(0, 3).getB());

    assertEquals(3, newImage.getPixelAt(2, 0).getR());
    assertEquals(3, newImage.getPixelAt(2, 0).getG());
    assertEquals(3, newImage.getPixelAt(2, 0).getB());

    assertEquals(4, newImage.getPixelAt(2, 1).getR());
    assertEquals(4, newImage.getPixelAt(2, 1).getG());
    assertEquals(4, newImage.getPixelAt(2, 1).getB());

    assertEquals(5, newImage.getPixelAt(2, 2).getR());
    assertEquals(5, newImage.getPixelAt(2, 2).getG());
    assertEquals(5, newImage.getPixelAt(2, 2).getB());

    assertEquals(6, newImage.getPixelAt(2, 3).getR());
    assertEquals(6, newImage.getPixelAt(2, 3).getG());
    assertEquals(6, newImage.getPixelAt(2, 3).getB());
  }
}