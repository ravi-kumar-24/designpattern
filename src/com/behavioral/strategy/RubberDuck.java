package com.behavioral.strategy;

public class RubberDuck extends Duck {
 public RubberDuck() {
   quackBehavior = new Squeak();
   flyBehavior = new FlyNoWay();
  }

  public void display() {
    System.out.println(" I'm a real Rubber duck");
  }
}


 