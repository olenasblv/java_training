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

  public double distanceToPoint(Point p) {
    return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
  }



  public Point symmetric() {
    return new Point(-1 * x, -1 * y);
  }

  public String toString() {
    return "x = " + x + " y = " + y;
  }
}


