package ua.qa.training.sandbox;

/**
 * Created by osoboleva on 9/11/2016.
 */
public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceToPoint(Point p1) {
    return Math.sqrt(Math.pow(p1.x - this.x, 2) + Math.pow(p1.y - this.y, 2));
  }
}
