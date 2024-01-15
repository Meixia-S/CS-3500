package controller;

import org.junit.Before;
import org.junit.Test;

import model.IImageProcessModel;
import model.ImageProcessModel;
import view.MockView;

import static org.junit.Assert.assertEquals;


/**
 * The class that tests the methods in the GUIController class.
 */
public class GUIControllerTest {
  IImageProcessModel m1;
  IImageProcessModel m2;

  // make mock view
  MockView v1;
  MockView v2;
  IGUI c1;

  @Before
  public void init() {
    this.m1 = new ImageProcessModel();
    this.m2 = null;

    StringBuilder log = new StringBuilder();
    this.v1 = new MockView(log);
    this.v2 = null;

    this.c1 = new GUIController(this.m1, this.v1);
  }

  @Test
  public void testVisible() {
    ImageProcessModel mod = new ImageProcessModel();
    StringBuilder log = new StringBuilder();
    MockView view = new MockView(log);
    GUIController cont = new GUIController(mod, view);
    cont.start();
    assertEquals("",  log.toString());
  }

  // test to see if a message is shown if inputs are somehow null
  @Test
  public void testBrightness() {
    ImageProcessModel mod = new ImageProcessModel();
    StringBuilder log = new StringBuilder();
    MockView view = new MockView(log);
    GUIController cont = new GUIController(mod, view);
    cont.brightness(2, null, null);
    assertEquals("Message Rendered: One Or All The Inputs Are Null", log.toString());
  }

  // test to see if a message is shown if inputs are somehow null
  @Test
  public void testClarity() {
    ImageProcessModel mod = new ImageProcessModel();
    StringBuilder log = new StringBuilder();
    MockView view = new MockView(log);
    GUIController cont = new GUIController(mod, view);
    cont.clarity("blur", null, null);
    assertEquals("One Or All The Inputs Are Null", log.toString());
  }

  // test to see if a message is shown if inputs are somehow null
  @Test
  public void testFlip() {
    ImageProcessModel mod = new ImageProcessModel();
    StringBuilder log = new StringBuilder();
    MockView view = new MockView(log);
    GUIController cont = new GUIController(mod, view);
    cont.flip("vertical", null, null);
    assertEquals("One Or All The Inputs Are Null", log.toString());
  }

  // test to see if a message is shown if inputs are somehow null
  @Test
  public void testGreyscale() {
    ImageProcessModel mod = new ImageProcessModel();
    StringBuilder log = new StringBuilder();
    MockView view = new MockView(log);
    GUIController cont = new GUIController(mod, view);
    cont.greyscale("sepia", null, null);
    assertEquals("One Or All The Inputs Are Null", log.toString());
  }

  // test to see if a message is shown if inputs are somehow null
  @Test
  public void testVisualize() {
    ImageProcessModel mod = new ImageProcessModel();
    StringBuilder log = new StringBuilder();
    MockView view = new MockView(log);
    GUIController cont = new GUIController(mod, view);
    cont.visualize("red-component", null, null);
    assertEquals("One Or All The Inputs Are Null", log.toString());
  }

  // All other incorrect input scenarios are caught in the view:
  // -User can input a string and symbol as the integer input for Brightness. Program will tell user
  // to input the factor again and not save the incorrect one.
  // -User can incorrectly input name an image and the program will notify them of the mistake and
  // will re-prompt the user to give the edited image a new name.

  // Test exception (Model is Null)
  @Test(expected = IllegalArgumentException.class)
  public void testModelIsNull() {
    GUIController c2 = new GUIController(this.m2, this.v1);
  }

  // Test exception (View is Null)
  @Test(expected = IllegalArgumentException.class)
  public void testAppendableIsNull() {
    GUIController c3 = new GUIController(this.m1, this.v2);
  }
}