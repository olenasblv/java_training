package ua.qa.training.sandbox;

/**
 * Created by osoboleva on 9/11/2016.
 */
public class HomeWork {

  public static void main(String[] args) {

    Point p1 = new Point(0, 3);
    Point p2 = new Point(4, 5);

    // вывод в консоль результата статического метода класса с объявлением переменной distanceResult
    double distanceResult = distance(p1, p2);
    System.out.println("растояние между точками p1 и p2 = " + distanceResult);

    // вывод в консоль результата метода объекта без объявления промежуточной переменной
    System.out.println("расстояние между точками p1 и p2 = " + p1.distanceToPoint(p2));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }
}
