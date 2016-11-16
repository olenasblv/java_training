package ua.qa.training.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by osoboleva on 9/11/2016.
 */
public class HomeWork {

  public static void main(String[] args) {

    Point p1 = new Point(3, 3);
    Point p2 = new Point(4, 5);
    Point p3 = new Point(4, 5);
    Point p4 = new Point(7, 9);

    double distanceResult = distance(p1, p2);
    System.out.println("растояние между точками p1 и p2 = " + distanceResult);

    System.out.println("расстояние между точками p1 и p2 = " + p1.distanceToPoint(p2));

    // return the symmetric point to p1
    // System.out.println("symmetric point" + p1.symmetric().x + p1.symmetric().y);
    System.out.println("symmetric point " + p1.symmetric());

    // sum of x (class Point2)
    Point2 p = new Point2(3, 5);
    System.out.println("sum of x = " + p.sumX(p1));

    // vector
    Vector v1 = new Vector(p1, p2);
    Vector v2 = new Vector(p3, p4);

    System.out.println("sum of vectors " + Vector.getSumOfVectors(v1,v2) + " with static method");

    System.out.println("sum of vectors " + v1.getSumWithCurrentVector(v2) + " without temp");

    System.out.println("scalar multiplication = " + v1.getScalarMultiplication(v2));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }
}
