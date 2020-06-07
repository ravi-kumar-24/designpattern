package com.behavioral.strategy;

public class MiniDuckSimulator {
 public static void main(String[] args) {
   Duck mallard = new MallardDuck();
   mallard.performQuack();
   mallard.performFly();
   
   System.out.println();
   
   Duck  rubber = new RubberDuck();
   rubber.performQuack();
   rubber.performFly();
  }
}