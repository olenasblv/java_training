package ua.qa.training.sandbox;

/**
 * Created by osoboleva on 9/13/2016.
 */

// реализовать класс Vector, который представляет вектор на плоскости
public class Vector {
  public Point a;
  public Point b;

  public Vector(Point a, Point b) {
    this.a = a;
    this.b = b;
  }

  public Point getVectorCoordinates() {
    double x = b.x - a.x;
    double y = b.y - a.y;
    return new Point(x, y);
  }

  // реализовать функцию для сложения двух векторов
  public static Point getSumOfVectors(Vector v1, Vector v2) {
    Point v1Coordinates = v1.getVectorCoordinates();
    Point v2Coordinates = v2.getVectorCoordinates();
    return new Point(v1Coordinates.x + v2Coordinates.x, v1Coordinates.y + v2Coordinates.y);
  }

  // реализовать то же самое в виде метода в классе Vector
  public Point getSumWithCurrentVector(Vector v) {
    Point vCoordinates = v.getVectorCoordinates();
    Point currentVectorCoordinates = getVectorCoordinates();
    return new Point(vCoordinates.x + currentVectorCoordinates.x, vCoordinates.y + currentVectorCoordinates.y);
  }

  // реализовать метод, вычисляющий скалярное произведение данного вектора на какой-то другой вектор
  public double getScalarMultiplication(Vector vv) {
    Point vvCoordinates = vv.getVectorCoordinates();
    Point currentVectorCoordinates = getVectorCoordinates();
    return vvCoordinates.x * currentVectorCoordinates.x + vvCoordinates.y * currentVectorCoordinates.y;

  }
}



