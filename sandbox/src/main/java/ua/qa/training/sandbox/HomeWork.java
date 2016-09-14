package ua.qa.training.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by osoboleva on 9/11/2016.
 */
public class HomeWork {

  public static void main(String[] args) {

    Point p1 = new Point(1, 3);
    Point p2 = new Point(4, 5);
    Point p3 = new Point(3, 7);
    Point p4 = new Point(4, 5);

    // вывод в консоль результата статического метода класса с объявлением переменной distanceResult
    double distanceResult = distance(p1, p2);
    System.out.println("растояние между точками p1 и p2 = " + distanceResult);

    // вывод в консоль результата метода объекта без объявления промежуточной переменной
    System.out.println("расстояние между точками p1 и p2 = " + p1.distanceToPoint(p2));

    // return the symmetric point to p1
    // System.out.println("symmetric point" + p1.symmetric().x + p1.symmetric().y);
    System.out.println("symmetric point " + p1.symmetric());

    // sum of x (class Point2)
    Point2 p = new Point2(3, 5);
    System.out.println("sum of x = " + p.sumX(p1));

    // vector
    Vector v1 = new Vector (p1, p2);
    Vector v2 = new Vector (p3, p4);
    Vector.getSumOfVectors(v1,v2);
    v1.getSumWithCurrentVector(v2);
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }
}
