package ua.qa.training.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by osoboleva on 9/18/2016.
 */
public class PointTests {

  @Test
  public void testDistanceToPoint() {
    Point p1 = new Point(3, 5);
    Point p2 = new Point(6, 7);
    Assert.assertEquals(Math.round(p1.distanceToPoint(p2)), 4);
  }

  @Test
  public void testDistanceToPoint1() {
    Point p1 = new Point(3, 5);
    Point p2 = new Point(6, 7);
    Assert.assertTrue((Math.abs(p1.distanceToPoint(p2)) - 3.6) < 0.01);
  }

  @Test
  public void testDistanceToItself() {
    Point p = new Point(4, 5);
    Assert.assertEquals(p.distanceToPoint(p), 0.0);
  }

  @Test
  public void testDistancePosAndNegCoordinates() {
    Point p1 = new Point(4, 5);
    Point p2 = new Point(-4, -5);
    Assert.assertEquals(Math.round(p1.distanceToPoint(p2)), 13);
  }

  @Test
  public void testDistanceToBothSides(){
    Point p1 = new Point(3, 5);
    Point p2 = new Point(6, 7);
    Assert.assertEquals (p1.distanceToPoint(p2),p2.distanceToPoint(p1));
  }
}

