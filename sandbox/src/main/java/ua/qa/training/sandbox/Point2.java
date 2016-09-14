package ua.qa.training.sandbox;

/**
 * Created by osoboleva on 9/11/2016.
 */
public class Point2 {

  public double x;
  public double y;

  public Point2(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double sumX(Point p) {
    return x + p.x;
  }

}
