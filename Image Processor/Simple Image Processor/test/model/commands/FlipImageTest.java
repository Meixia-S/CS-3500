package model.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import org.junit.Test;

import model.Image;

import model.Pixel;

/**
 * Class that tests the methods in the FlipImage class.
 */
public class FlipImageTest {

  // Example image height
  int heightImage1;
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
  Pixel[][] pixelArray1;
  Pixel[][] pixelArray2;

  // Example Images
  Image image1;
  Image image2;

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
    this.pixelArray1[0] = new Pixel[]{this.p1, this.p2, this.p3};
    this.pixelArray1[1] = new Pixel[]{this.p4, this.p5, this.p6};
    this.pixelArray1[2] = new Pixel[]{this.p7, this.p8, this.p9};

    this.pixelArray2 = new Pixel[3][4];
    this.pixelArray2[0] = new Pixel[]{this.p1, this.p2, this.p3, this.p4};
    this.pixelArray2[1] = new Pixel[]{this.p5, this.p6, this.p7, this.p8};
    this.pixelArray2[2] = new Pixel[]{this.p9, this.p10, this.p11, this.p12};

    this.image1 = new Image(this.heightImage1, this.widthImage1, this.max, this.pixelArray1);
    this.image2 = new Image(this.heightImage2, this.widthImage2, this.max, this.pixelArray2);
  }

  // Test horizontal flip  with a square image
  @Test
  public void testFlipH1() {
    Image newImage = new FlipImage(false).execute(this.image1);

    assertEquals(3, newImage.getPixelAt(0, 0).getR());
    assertEquals(3, newImage.getPixelAt(0, 0).getG());
    assertEquals(3, newImage.getPixelAt(0, 0).getB());

    assertEquals(2, newImage.getPixelAt(0, 1).getR());
    assertEquals(2, newImage.getPixelAt(0, 1).getG());
    assertEquals(2, newImage.getPixelAt(0, 1).getB());

    assertEquals(1, newImage.getPixelAt(0, 2).getR());
    assertEquals(1, newImage.getPixelAt(0, 2).getG());
    assertEquals(1, newImage.getPixelAt(0, 2).getB());

    assertEquals(3, newImage.getPixelAt(2, 0).getR());
    assertEquals(4, newImage.getPixelAt(2, 0).getG());
    assertEquals(5, newImage.getPixelAt(2, 0).getB());

    assertEquals(2, newImage.getPixelAt(2, 1).getR());
    assertEquals(3, newImage.getPixelAt(2, 1).getG());
    assertEquals(4, newImage.getPixelAt(2, 1).getB());

    assertEquals(1, newImage.getPixelAt(2, 2).getR());
    assertEquals(2, newImage.getPixelAt(2, 2).getG());
    assertEquals(3, newImage.getPixelAt(2, 2).getB());
  }

  // Test horizontal flip  with a rectangular image
  @Test
  public void testFlipH2() {
    Image newImage = new FlipImage(false).execute(this.image2);

    assertEquals(4, newImage.getPixelAt(0, 0).getR());
    assertEquals(4, newImage.getPixelAt(0, 0).getG());
    assertEquals(4, newImage.getPixelAt(0, 0).getB());

    assertEquals(3, newImage.getPixelAt(0, 1).getR());
    assertEquals(3, newImage.getPixelAt(0, 1).getG());
    assertEquals(3, newImage.getPixelAt(0, 1).getB());

    assertEquals(2, newImage.getPixelAt(0, 2).getR());
    assertEquals(2, newImage.getPixelAt(0, 2).getG());
    assertEquals(2, newImage.getPixelAt(0, 2).getB());

    assertEquals(1, newImage.getPixelAt(0, 3).getR());
    assertEquals(1, newImage.getPixelAt(0, 3).getG());
    assertEquals(1, newImage.getPixelAt(0, 3).getB());

    assertEquals(6, newImage.getPixelAt(2, 0).getR());
    assertEquals(7, newImage.getPixelAt(2, 0).getG());
    assertEquals(8, newImage.getPixelAt(2, 0).getB());

    assertEquals(5, newImage.getPixelAt(2, 1).getR());
    assertEquals(6, newImage.getPixelAt(2, 1).getG());
    assertEquals(7, newImage.getPixelAt(2, 1).getB());

    assertEquals(4, newImage.getPixelAt(2, 2).getR());
    assertEquals(5, newImage.getPixelAt(2, 2).getG());
    assertEquals(6, newImage.getPixelAt(2, 2).getB());

    assertEquals(3, newImage.getPixelAt(2, 3).getR());
    assertEquals(4, newImage.getPixelAt(2, 3).getG());
    assertEquals(5, newImage.getPixelAt(2, 3).getB());
  }

  // Test vertical flip  with a square image
  @Test
  public void testFlipV1() {
    Image newImage = new FlipImage(true).execute(this.image1);

    assertEquals(1, newImage.getPixelAt(0, 0).getR());
    assertEquals(2, newImage.getPixelAt(0, 0).getG());
    assertEquals(3, newImage.getPixelAt(0, 0).getB());

    assertEquals(2, newImage.getPixelAt(0, 1).getR());
    assertEquals(3, newImage.getPixelAt(0, 1).getG());
    assertEquals(4, newImage.getPixelAt(0, 1).getB());

    assertEquals(3, newImage.getPixelAt(0, 2).getR());
    assertEquals(4, newImage.getPixelAt(0, 2).getG());
    assertEquals(5, newImage.getPixelAt(0, 2).getB());

    assertEquals(1, newImage.getPixelAt(2, 0).getR());
    assertEquals(1, newImage.getPixelAt(2, 0).getG());
    assertEquals(1, newImage.getPixelAt(2, 0).getB());

    assertEquals(2, newImage.getPixelAt(2, 1).getR());
    assertEquals(2, newImage.getPixelAt(2, 1).getG());
    assertEquals(2, newImage.getPixelAt(2, 1).getB());

    assertEquals(3, newImage.getPixelAt(2, 2).getR());
    assertEquals(3, newImage.getPixelAt(2, 2).getG());
    assertEquals(3, newImage.getPixelAt(2, 2).getB());
  }

  // Test vertical flip  with a rectangular image
  @Test
  public void testFlipV2() {
    Image newImage = new FlipImage(true).execute(this.image2);

    assertEquals(3, newImage.getPixelAt(0, 0).getR());
    assertEquals(4, newImage.getPixelAt(0, 0).getG());
    assertEquals(5, newImage.getPixelAt(0, 0).getB());

    assertEquals(4, newImage.getPixelAt(0, 1).getR());
    assertEquals(5, newImage.getPixelAt(0, 1).getG());
    assertEquals(6, newImage.getPixelAt(0, 1).getB());

    assertEquals(5, newImage.getPixelAt(0, 2).getR());
    assertEquals(6, newImage.getPixelAt(0, 2).getG());
    assertEquals(7, newImage.getPixelAt(0, 2).getB());

    assertEquals(6, newImage.getPixelAt(0, 3).getR());
    assertEquals(7, newImage.getPixelAt(0, 3).getG());
    assertEquals(8, newImage.getPixelAt(0, 3).getB());

    assertEquals(1, newImage.getPixelAt(2, 0).getR());
    assertEquals(1, newImage.getPixelAt(2, 0).getG());
    assertEquals(1, newImage.getPixelAt(2, 0).getB());

    assertEquals(2, newImage.getPixelAt(2, 1).getR());
    assertEquals(2, newImage.getPixelAt(2, 1).getG());
    assertEquals(2, newImage.getPixelAt(2, 1).getB());

    assertEquals(3, newImage.getPixelAt(2, 2).getR());
    assertEquals(3, newImage.getPixelAt(2, 2).getG());
    assertEquals(3, newImage.getPixelAt(2, 2).getB());

    assertEquals(4, newImage.getPixelAt(2, 3).getR());
    assertEquals(4, newImage.getPixelAt(2, 3).getG());
    assertEquals(4, newImage.getPixelAt(2, 3).getB());
  }
}