package controller;

import model.Image;
import model.Pixel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A class that tests the LoadImage class methods.
 */
public class LoadTest {

  Pixel pixel00;
  Pixel pixel01;
  Pixel pixel02;

  Pixel pixel10;
  Pixel pixel11;
  Pixel pixel12;


  @Before
  public void init() {
    pixel00 = new Pixel(134, 136, 153);
    pixel01 = new Pixel(205, 205, 206);
    pixel02 = new Pixel(96, 97, 99);

    pixel10 = new Pixel(111, 117, 134);
    pixel11 = new Pixel(167, 166, 170);
    pixel12 = new Pixel(101, 99, 105);
  }

  @Test
  public void testLoadPNG() {

    init();
    String imagePath = "res/Test/Test.png";
    Image image = ImageUtil.load(imagePath);

    assertEquals(3, image.getWidth());
    assertEquals(2, image.getHeight());
    assertEquals(255, image.getMax());

    assertEquals(pixel00.getR(), image.getPixelAt(0, 0).getR());
    assertEquals(pixel00.getG(), image.getPixelAt(0, 0).getG());
    assertEquals(pixel00.getB(), image.getPixelAt(0, 0).getB());

    assertEquals(pixel01.getR(), image.getPixelAt(0, 1).getR());
    assertEquals(pixel01.getG(), image.getPixelAt(0, 1).getG());
    assertEquals(pixel01.getB(), image.getPixelAt(0, 1).getB());

    assertEquals(pixel02.getR(), image.getPixelAt(0, 2).getR());
    assertEquals(pixel02.getG(), image.getPixelAt(0, 2).getG());
    assertEquals(pixel02.getB(), image.getPixelAt(0, 2).getB());

    assertEquals(pixel10.getR(), image.getPixelAt(1, 0).getR());
    assertEquals(pixel10.getG(), image.getPixelAt(1, 0).getG());
    assertEquals(pixel10.getB(), image.getPixelAt(1, 0).getB());

    assertEquals(pixel11.getR(), image.getPixelAt(1, 1).getR());
    assertEquals(pixel11.getG(), image.getPixelAt(1, 1).getG());
    assertEquals(pixel11.getB(), image.getPixelAt(1, 1).getB());

    assertEquals(pixel12.getR(), image.getPixelAt(1, 2).getR());
    assertEquals(pixel12.getG(), image.getPixelAt(1, 2).getG());
    assertEquals(pixel12.getB(), image.getPixelAt(1, 2).getB());
  }

  @Test
  public void testLoadBMP() {

    init();
    String imagePath = "res/Test/Test.bmp";
    Image image = ImageUtil.load(imagePath);

    assertEquals(3, image.getWidth());
    assertEquals(2, image.getHeight());
    assertEquals(255, image.getMax());

    assertEquals(pixel00.getR(), image.getPixelAt(0, 0).getR());
    assertEquals(pixel00.getG(), image.getPixelAt(0, 0).getG());
    assertEquals(pixel00.getB(), image.getPixelAt(0, 0).getB());

    assertEquals(pixel01.getR(), image.getPixelAt(0, 1).getR());
    assertEquals(pixel01.getG(), image.getPixelAt(0, 1).getG());
    assertEquals(pixel01.getB(), image.getPixelAt(0, 1).getB());

    assertEquals(pixel02.getR(), image.getPixelAt(0, 2).getR());
    assertEquals(pixel02.getG(), image.getPixelAt(0, 2).getG());
    assertEquals(pixel02.getB(), image.getPixelAt(0, 2).getB());

    assertEquals(pixel10.getR(), image.getPixelAt(1, 0).getR());
    assertEquals(pixel10.getG(), image.getPixelAt(1, 0).getG());
    assertEquals(pixel10.getB(), image.getPixelAt(1, 0).getB());

    assertEquals(pixel11.getR(), image.getPixelAt(1, 1).getR());
    assertEquals(pixel11.getG(), image.getPixelAt(1, 1).getG());
    assertEquals(pixel11.getB(), image.getPixelAt(1, 1).getB());

    assertEquals(pixel12.getR(), image.getPixelAt(1, 2).getR());
    assertEquals(pixel12.getG(), image.getPixelAt(1, 2).getG());
    assertEquals(pixel12.getB(), image.getPixelAt(1, 2).getB());
  }

  @Test
  public void testLoadJPG() {

    init();
    String imagePath = "res/Test/Test.jpg";
    Image image = ImageUtil.load(imagePath);

    assertEquals(3, image.getWidth());
    assertEquals(2, image.getHeight());
    assertEquals(255, image.getMax());

    assertEquals(pixel00.getR(), image.getPixelAt(0, 0).getR());
    assertEquals(pixel00.getG(), image.getPixelAt(0, 0).getG());
    assertEquals(pixel00.getB(), image.getPixelAt(0, 0).getB());

    assertEquals(pixel01.getR(), image.getPixelAt(0, 1).getR());
    assertEquals(pixel01.getG(), image.getPixelAt(0, 1).getG());
    assertEquals(pixel01.getB(), image.getPixelAt(0, 1).getB());

    assertEquals(pixel02.getR(), image.getPixelAt(0, 2).getR());
    assertEquals(pixel02.getG(), image.getPixelAt(0, 2).getG());
    assertEquals(pixel02.getB(), image.getPixelAt(0, 2).getB());

    assertEquals(pixel10.getR(), image.getPixelAt(1, 0).getR());
    assertEquals(pixel10.getG(), image.getPixelAt(1, 0).getG());
    assertEquals(pixel10.getB(), image.getPixelAt(1, 0).getB());

    assertEquals(pixel11.getR(), image.getPixelAt(1, 1).getR());
    assertEquals(pixel11.getG(), image.getPixelAt(1, 1).getG());
    assertEquals(pixel11.getB(), image.getPixelAt(1, 1).getB());

    assertEquals(pixel12.getR(), image.getPixelAt(1, 2).getR());
    assertEquals(pixel12.getG(), image.getPixelAt(1, 2).getG());
    assertEquals(pixel12.getB(), image.getPixelAt(1, 2).getB());
  }

  @Test(expected = IllegalArgumentException.class)
  public void LoadException() {
    Image image = ImageUtil.load("res/DOESNOTEXESIT.png");
  }
}