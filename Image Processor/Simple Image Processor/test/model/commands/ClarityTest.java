package model.commands;

import org.junit.Before;
import org.junit.Test;

import model.Image;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * A class that tests the method in the Clarity class.
 */
public class ClarityTest {

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
  Pixel[][] pixelArray;

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

    this.pixelArray = new Pixel[3][3];
    this.pixelArray[0] = new Pixel[]{this.p1, this.p2, this.p3};
    this.pixelArray[1] = new Pixel[]{this.p4, this.p5, this.p6};
    this.pixelArray[2] = new Pixel[]{this.p7, this.p8, this.p9};

    this.image = new Image(this.heightImage1, this.widthImage1, this.max, this.pixelArray);
  }

  // Test Blur on an image
  @Test
  public void testBlur() {
    Image newImage = new Clarity("blur").execute(this.image);

    assertEquals(1, newImage.getPixelAt(0, 0).getR());
    assertEquals(1, newImage.getPixelAt(0, 0).getG());
    assertEquals(1, newImage.getPixelAt(0, 0).getB());

    assertEquals(2, newImage.getPixelAt(0, 2).getR());
    assertEquals(2, newImage.getPixelAt(0, 2).getG());
    assertEquals(2, newImage.getPixelAt(0, 2).getB());

    assertEquals(2, newImage.getPixelAt(1, 0).getR());
    assertEquals(2, newImage.getPixelAt(1, 0).getG());
    assertEquals(2, newImage.getPixelAt(1, 0).getB());

    assertEquals(3, newImage.getPixelAt(1, 2).getR());
    assertEquals(3, newImage.getPixelAt(1, 2).getG());
    assertEquals(3, newImage.getPixelAt(1, 2).getB());

    assertEquals(1, newImage.getPixelAt(2, 0).getR());
    assertEquals(1, newImage.getPixelAt(2, 0).getG());
    assertEquals(2, newImage.getPixelAt(2, 0).getB());

    assertEquals(2, newImage.getPixelAt(2, 2).getR());
    assertEquals(2, newImage.getPixelAt(2, 2).getG());
    assertEquals(2, newImage.getPixelAt(2, 2).getB());
  }

  // Test Sharpen on an image
  @Test
  public void testSharpen() {
    Image newImage = new Clarity("sharpen").execute(this.image);

    assertEquals(1, newImage.getPixelAt(0, 0).getR());
    assertEquals(1, newImage.getPixelAt(0, 0).getG());
    assertEquals(1, newImage.getPixelAt(0, 0).getB());

    assertEquals(4, newImage.getPixelAt(0, 2).getR());
    assertEquals(4, newImage.getPixelAt(0, 2).getG());
    assertEquals(4, newImage.getPixelAt(0, 2).getB());

    assertEquals(5, newImage.getPixelAt(1, 0).getR());
    assertEquals(5, newImage.getPixelAt(1, 0).getG());
    assertEquals(6, newImage.getPixelAt(1, 0).getB());

    assertEquals(9, newImage.getPixelAt(1, 2).getR());
    assertEquals(9, newImage.getPixelAt(1, 2).getG());
    assertEquals(9, newImage.getPixelAt(1, 2).getB());

    assertEquals(1, newImage.getPixelAt(2, 0).getR());
    assertEquals(3, newImage.getPixelAt(2, 0).getG());
    assertEquals(4, newImage.getPixelAt(2, 0).getB());

    assertEquals(4, newImage.getPixelAt(2, 2).getR());
    assertEquals(6, newImage.getPixelAt(2, 2).getG());
    assertEquals(7, newImage.getPixelAt(2, 2).getB());
  }
}