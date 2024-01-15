package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The class that tests the methods in the Pixel class.
 */
public class PixelTest {

  // Pixel examples
  Pixel p1;
  Pixel p2;
  Pixel p1V1;

  @Before
  public void init() {
    // Pixel examples
    this.p1 = new Pixel(1, 2, 3);
    this.p2 = new Pixel(4, 5, 6);
  }

  // Testing getting the red value
  @Test
  public void testGetR() {
    assertEquals(1, p1.getR());
    assertEquals(4, p2.getR());
  }

  // Testing getting the green value
  @Test
  public void testGetG() {
    assertEquals(2, p1.getG());
    assertEquals(5, p2.getG());
  }

  // Testing getting the blue value
  @Test
  public void testGetB() {
    assertEquals(3, p1.getB());
    assertEquals(6, p2.getB());
  }

  // Testing getting the max rgb value in a Pixel
  @Test
  public void testMaxValue() {
    assertEquals(3, this.p1.maxValue());
    assertEquals(6, this.p2.maxValue());
  }
}