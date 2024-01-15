package controller;

import java.io.Reader;

import model.MockModel;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import model.IImageProcessModel;
import model.Image;
import model.ImageProcessModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * A class that tests the Controller class method.
 */
public class ImageProcessControllerTest {
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

  // Example 2D Pixel Arrays After Horizontal Flip
  Pixel[][] pixelArrayH1;
  Pixel[][] pixelArrayH2;

  // Example 2D Pixel Arrays After Vertical Flip
  Pixel[][] pixelArrayV1;
  Pixel[][] pixelArrayV2;

  // Example Images
  Image image1;
  Image image2;

  // Example Images After Brighten
  Image imageH1;
  Image imageH2;

  // Example Images After Brighten
  Image imageV1;
  Image imageV2;

  // Examples of Appendable
  Appendable app1;
  Appendable app2;

  // Example of Readable
  Readable rd1;
  Readable rd2;

  // Example of Model Constructor
  IImageProcessModel m1;
  IImageProcessModel m2;


  // Example of Controller Constructor
  IImageProcessController c1;

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

    this.pixelArrayH1 = new Pixel[3][3];
    this.pixelArrayH1[0] = new Pixel[]{this.p3, this.p2, this.p1};
    this.pixelArrayH1[1] = new Pixel[]{this.p6, this.p5, this.p4};
    this.pixelArrayH1[2] = new Pixel[]{this.p9, this.p8, this.p7};

    this.pixelArrayH2 = new Pixel[3][4];
    this.pixelArrayH2[0] = new Pixel[]{this.p4, this.p3, this.p2, this.p1};
    this.pixelArrayH2[1] = new Pixel[]{this.p8, this.p7, this.p6, this.p5};
    this.pixelArrayH2[2] = new Pixel[]{this.p12, this.p11, this.p10, this.p9};

    this.pixelArrayV1 = new Pixel[3][3];
    this.pixelArrayV1[0] = new Pixel[]{this.p9, this.p8, this.p7};
    this.pixelArrayV1[1] = new Pixel[]{this.p6, this.p5, this.p4};
    this.pixelArrayV1[2] = new Pixel[]{this.p3, this.p2, this.p1};

    this.pixelArrayV2 = new Pixel[3][4];
    this.pixelArrayV2[0] = new Pixel[]{this.p1, this.p2, this.p3, this.p4};
    this.pixelArrayV2[1] = new Pixel[]{this.p5, this.p6, this.p7, this.p8};
    this.pixelArrayV2[2] = new Pixel[]{this.p9, this.p10, this.p11, this.p12};

    this.image1 = new Image(this.heightImage1, this.widthImage1, this.max, this.pixelArray1);
    this.image2 = new Image(this.heightImage2, this.widthImage2, this.max, this.pixelArray2);

    this.imageH1 = new Image(this.heightImage1, this.widthImage1, this.max, this.pixelArrayH1);
    this.imageH2 = new Image(this.heightImage2, this.widthImage2, this.max, this.pixelArrayH2);

    this.imageV1 = new Image(this.heightImage1, this.widthImage1, this.max, this.pixelArrayV1);
    this.imageV2 = new Image(this.heightImage2, this.widthImage2, this.max, this.pixelArrayV2);

    this.app1 = new StringBuilder("flip-horizontal");
    this.app2 = null;

    this.rd1 = new StringReader(" ");
    this.rd2 = null;

    this.m1 = new ImageProcessModel();
    this.m2 = null;

    this.c1 = new ImageProcessController(this.m1, this.rd1, this.app1);

  }

  @Test
  public void testRun() {
    IImageProcessModel m = new ImageProcessModel();
    Readable r = new InputStreamReader(System.in);
    System.setIn(new ByteArrayInputStream("q".getBytes()));
    Appendable a = new StringBuilder();

    IImageProcessController c = new ImageProcessController(m, r, a);
    this.c1.run();
    assertNotEquals(c1, c);
  }

  @Test
  public void testLoadCommand() {
    Reader in = new StringReader("load res/Donkey.ppm Donkey");
    StringBuilder app = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mock = new MockModel(log);
    ImageProcessController con = new ImageProcessController(mock, in, app);

    con.run();
    assertEquals("add image Donkey\n", log.toString());
  }

  @Test
  public void testLoadAndModification() {
    Reader in = new StringReader("load res/Donkey.ppm Donkey \n sepia Donkey Donkey-Execute");
    StringBuilder app = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mock = new MockModel(log);
    ImageProcessController con = new ImageProcessController(mock, in, app);

    con.run();
    assertEquals("add image Donkey\ncommand ran on Donkey-Execute\n", log.toString());
  }

  @Test
  public void testLoadThenModificationAndSave() {
    Reader in = new StringReader("load res/Donkey.ppm Donkey \n sepia Donkey Donkey-Execute " +
            "\n save res/Donkey-Execute.png Donkey-Execute");
    StringBuilder app = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mock = new MockModel(log);
    ImageProcessController con = new ImageProcessController(mock, in, app);

    con.run();
    assertEquals("add image Donkey\ncommand ran on Donkey-Execute\n" +
            "get image Donkey-Execute\n", log.toString());
  }

  // Test exception (Model is Null)
  @Test(expected = IllegalArgumentException.class)
  public void testModelIsNull() {
    this.c1 = new ImageProcessController(this.m2, this.rd1, this.app1);
  }

  // Test exception (Readable is Null)
  @Test(expected = IllegalArgumentException.class)
  public void testReadableIsNull() {
    this.c1 = new ImageProcessController(this.m1, this.rd2, this.app1);
  }

  // Test exception (Appendable is Null)
  @Test(expected = IllegalArgumentException.class)
  public void testAppendableIsNull() {
    this.c1 = new ImageProcessController(this.m1, this.rd1, this.app2);
  }
}