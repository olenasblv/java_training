package ua.qa.training.sandbox;

/**
 * Created by osoboleva on 9/11/2016.
 */
public class Square {

  public double l;

  public Square(double l){

    this.l = l;  // .l - атрибут, l- аргумент функции
  }


  public double area (){
    return this.l * this.l;
  }

}
