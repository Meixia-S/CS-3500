package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the methods in the Image class.
 */

public class ImageTest {

  // Example image height
  int heightImage1;
  int heightImage2;
  int height0;

  // Example image width
  int widthImage1;
  int widthImage2;
  int width0;

  // Example image max value
  int max;
  int max0;
  int max256;

  // Example Pixels
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
  Pixel[][] pixelArray1;
  Pixel[][] pixelArray2;

  Pixel[][] pixelArrayN;

  // Example Images
  Image image1;
  Image image2;
  Image image;

  @Before
  public void init() {
    this.heightImage1 = 3;
    this.heightImage2 = 3;

    this.widthImage1 = 3;
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

    this.pixelArray1 = new Pixel[3][3];
    this.pixelArray1[0] = new Pixel[] {this.p1, this.p2, this.p3};
    this.pixelArray1[1] = new Pixel[] {this.p4, this.p5, this.p6};
    this.pixelArray1[2] = new Pixel[] {this.p7, this.p8, this.p9};

    this.pixelArray2 = new Pixel[3][4];
    this.pixelArray2[0] = new Pixel[] {this.p1, this.p2, this.p3, this.p4};
    this.pixelArray2[1] = new Pixel[] {this.p5, this.p6, this.p7, this.p8};
    this.pixelArray2[2] = new Pixel[] {this.p9, this.p10, this.p11, this.p12};

    this.image1 = new Image(this.heightImage1, this.widthImage1, this.max, this.pixelArray1);
    this.image2 = new Image(this.heightImage2, this.widthImage2, this.max, this.pixelArray2);
  }

  @Test
  public void testGetHeight() {
    assertEquals(this.heightImage1, this.image1.getHeight());
    assertEquals(this.heightImage2, this.image2.getHeight());
  }

  @Test
  public void testGetWidth() {
    assertEquals(this.widthImage1, this.image1.getWidth());
    assertEquals(this.widthImage2, this.image2.getWidth());
  }

  @Test
  public void testGetMax() {
    assertEquals(this.max, this.image1.getMax());
  }

  @Test
  public void testGetPixelAtImage1() {
    assertEquals(this.p1, this.image1.getPixelAt(0, 0));
    assertEquals(this.p3, this.image1.getPixelAt(0, 2));
    assertEquals(this.p7, this.image1.getPixelAt(2, 0));
    assertEquals(this.p9, this.image1.getPixelAt(2, 2));
  }

  @Test
  public void testGetPixelAtImage2() {
    assertEquals(this.p1, this.image2.getPixelAt(0, 0));
    assertEquals(this.p4, this.image2.getPixelAt(0,3));
    assertEquals(this.p9, this.image2.getPixelAt(2, 0));
    assertEquals(this.p12, this.image2.getPixelAt(2, 3));
  }

  // Test exception (where height is below 0)
  @Test(expected = IllegalArgumentException.class)
  public void testHeightIsBelow() {
    Image image = new Image(-1, 1, 255,
            this.pixelArray1);
  }

  // Test exception (where width is below 0)
  @Test(expected = IllegalArgumentException.class)
  public void testWidthIsBelow() {
    Image image = new Image(1, -1, 255,
            this.pixelArray1);
  }

  // Test exception (where max is below 0)
  @Test(expected = IllegalArgumentException.class)
  public void testMaxIsBlow() {
    Image image = new Image(1, 1, -1,
            this.pixelArray1);
  }


  // Test exception (where max is above 255)
  @Test(expected = IllegalArgumentException.class)
  public void testMaxIsAbove() {
    Image image = new Image(1, 1, 256,
            this.pixelArray1);
  }
}