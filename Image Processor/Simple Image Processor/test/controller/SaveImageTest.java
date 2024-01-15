package controller;

import org.junit.Before;
import org.junit.Test;

import model.Image;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * A class that test the method in the SameImage class.
 */
public class SaveImageTest {

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

  // Test to see if this image is saved correctly name.ppm is saved in res
  @Test
  public void testSave() {
    SaveImage save = new SaveImage();
    Pixel[][] arr = new Pixel[1][1];
    Pixel pixel = new Pixel(10, 10, 10);
    arr[0][0] = pixel;
    Image img = new Image(1, 1, 255, arr);
    String imagePath = "res/Test/name.ppm";
    save.executeCommand(imagePath, img);

    assertEquals(1, img.getHeight());
    assertEquals(1, img.getWidth());

    Pixel[][] arr2 = new Pixel[1][2];
    Pixel pixel3 = new Pixel(10, 10, 10);
    Pixel pixel4 = new Pixel(10, 10, 10);
    arr2[0][0] = pixel3;
    arr2[0][1] = pixel4;
    Image img2 = new Image(1, 2, 255, arr2);
    String imagePath2 = "res/Test/apic.ppm";
    save.executeCommand(imagePath2, img2);
    assertEquals(1, img2.getHeight());
    assertEquals(2, img2.getWidth());
  }

  @Test
  public void testSavePNG() {
    init();
    SaveImage saver = new SaveImage();
    String imagePath = "res/Test/Test.png";
    Image image = ImageUtil.load(imagePath);
    String imagePath2 = "res/Test/Test2.png";
    saver.executeCommand(imagePath2, image);

    Image image2 = ImageUtil.load(imagePath2);

    assertEquals(image.getWidth(), image2.getWidth());
    assertEquals(image.getHeight(), image2.getHeight());
    assertEquals(image.getMax(), image2.getMax());


    assertEquals(image.getPixelAt(0, 0).getR(), image2.getPixelAt(0, 0).getR());
    assertEquals(image.getPixelAt(0, 0).getG(), image2.getPixelAt(0, 0).getG());
    assertEquals(image.getPixelAt(0, 0).getB(), image2.getPixelAt(0, 0).getB());

    assertEquals(image.getPixelAt(0, 1).getR(), image2.getPixelAt(0, 1).getR());
    assertEquals(image.getPixelAt(0, 1).getG(), image2.getPixelAt(0, 1).getG());
    assertEquals(image.getPixelAt(0, 1).getB(), image2.getPixelAt(0, 1).getB());

    assertEquals(image.getPixelAt(0, 2).getR(), image2.getPixelAt(0, 2).getR());
    assertEquals(image.getPixelAt(0, 2).getG(), image2.getPixelAt(0, 2).getG());
    assertEquals(image.getPixelAt(0, 2).getB(), image2.getPixelAt(0, 2).getB());


    assertEquals(image.getPixelAt(1, 0).getR(), image2.getPixelAt(1, 0).getR());
    assertEquals(image.getPixelAt(1, 0).getG(), image2.getPixelAt(1, 0).getG());
    assertEquals(image.getPixelAt(1, 0).getB(), image2.getPixelAt(1, 0).getB());

    assertEquals(image.getPixelAt(1, 1).getR(), image2.getPixelAt(1, 1).getR());
    assertEquals(image.getPixelAt(1, 1).getG(), image2.getPixelAt(1, 1).getG());
    assertEquals(image.getPixelAt(1, 1).getB(), image2.getPixelAt(1, 1).getB());

    assertEquals(image.getPixelAt(1, 2).getR(), image2.getPixelAt(1, 2).getR());
    assertEquals(image.getPixelAt(1, 2).getG(), image2.getPixelAt(1, 2).getG());
    assertEquals(image.getPixelAt(1, 2).getB(), image2.getPixelAt(1, 2).getB());
  }

  @Test
  public void testSaveJPG() {
    init();
    SaveImage saver = new SaveImage();
    String imagePath = "res/Test/Test.jpg";
    Image image = ImageUtil.load(imagePath);
    String imagePath2 = "res/Test/Test2.jpg";
    saver.executeCommand(imagePath2, image);

    Image image2 = ImageUtil.load(imagePath2);

    assertEquals(image.getWidth(), image2.getWidth());
    assertEquals(image.getHeight(), image2.getHeight());
    assertEquals(image.getMax(), image2.getMax());


    assertEquals(image.getPixelAt(0, 0).getR(), image2.getPixelAt(0, 0).getR());
    assertEquals(image.getPixelAt(0, 0).getG(), image2.getPixelAt(0, 0).getG());
    assertEquals(image.getPixelAt(0, 0).getB(), image2.getPixelAt(0, 0).getB());

    assertEquals(image.getPixelAt(0, 1).getR(), image2.getPixelAt(0, 1).getR());
    assertEquals(image.getPixelAt(0, 1).getG(), image2.getPixelAt(0, 1).getG());
    assertEquals(image.getPixelAt(0, 1).getB(), image2.getPixelAt(0, 1).getB());

    assertEquals(image.getPixelAt(0, 2).getR(), image2.getPixelAt(0, 2).getR());
    assertEquals(image.getPixelAt(0, 2).getG(), image2.getPixelAt(0, 2).getG());
    assertEquals(image.getPixelAt(0, 2).getB(), image2.getPixelAt(0, 2).getB());


    assertEquals(image.getPixelAt(1, 0).getR(), image2.getPixelAt(1, 0).getR());
    assertEquals(image.getPixelAt(1, 0).getG(), image2.getPixelAt(1, 0).getG());
    assertEquals(image.getPixelAt(1, 0).getB(), image2.getPixelAt(1, 0).getB());

    assertEquals(image.getPixelAt(1, 1).getR(), image2.getPixelAt(1, 1).getR());
    assertEquals(image.getPixelAt(1, 1).getG(), image2.getPixelAt(1, 1).getG());
    assertEquals(image.getPixelAt(1, 1).getB(), image2.getPixelAt(1, 1).getB());

    assertEquals(image.getPixelAt(1, 2).getR(), image2.getPixelAt(1, 2).getR());
    assertEquals(image.getPixelAt(1, 2).getG(), image2.getPixelAt(1, 2).getG());
    assertEquals(image.getPixelAt(1, 2).getB(), image2.getPixelAt(1, 2).getB());
  }

  @Test
  public void testSaveBMP() {
    init();
    SaveImage saver = new SaveImage();
    String imagePath = "res/Test/Test.bmp";
    Image image = ImageUtil.load(imagePath);
    String imagePath2 = "res/Test/Test2.bmp";
    saver.executeCommand(imagePath2, image);

    Image image2 = ImageUtil.load(imagePath2);

    assertEquals(image.getWidth(), image2.getWidth());
    assertEquals(image.getHeight(), image2.getHeight());
    assertEquals(image.getMax(), image2.getMax());


    assertEquals(image.getPixelAt(0, 0).getR(), image2.getPixelAt(0, 0).getR());
    assertEquals(image.getPixelAt(0, 0).getG(), image2.getPixelAt(0, 0).getG());
    assertEquals(image.getPixelAt(0, 0).getB(), image2.getPixelAt(0, 0).getB());

    assertEquals(image.getPixelAt(0, 1).getR(), image2.getPixelAt(0, 1).getR());
    assertEquals(image.getPixelAt(0, 1).getG(), image2.getPixelAt(0, 1).getG());
    assertEquals(image.getPixelAt(0, 1).getB(), image2.getPixelAt(0, 1).getB());

    assertEquals(image.getPixelAt(0, 2).getR(), image2.getPixelAt(0, 2).getR());
    assertEquals(image.getPixelAt(0, 2).getG(), image2.getPixelAt(0, 2).getG());
    assertEquals(image.getPixelAt(0, 2).getB(), image2.getPixelAt(0, 2).getB());


    assertEquals(image.getPixelAt(1, 0).getR(), image2.getPixelAt(1, 0).getR());
    assertEquals(image.getPixelAt(1, 0).getG(), image2.getPixelAt(1, 0).getG());
    assertEquals(image.getPixelAt(1, 0).getB(), image2.getPixelAt(1, 0).getB());

    assertEquals(image.getPixelAt(1, 1).getR(), image2.getPixelAt(1, 1).getR());
    assertEquals(image.getPixelAt(1, 1).getG(), image2.getPixelAt(1, 1).getG());
    assertEquals(image.getPixelAt(1, 1).getB(), image2.getPixelAt(1, 1).getB());

    assertEquals(image.getPixelAt(1, 2).getR(), image2.getPixelAt(1, 2).getR());
    assertEquals(image.getPixelAt(1, 2).getG(), image2.getPixelAt(1, 2).getG());
    assertEquals(image.getPixelAt(1, 2).getB(), image2.getPixelAt(1, 2).getB());
  }
}