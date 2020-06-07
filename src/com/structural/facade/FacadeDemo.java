package com.structural.facade;

class FacadeCuppaMaker {
   boolean teaBagIsSteeped; 
    
   public FacadeCuppaMaker() {
       System.out.println(
         "FacadeCuppaMaker ready to make you a cuppa!");
   }
   
   public FacadeTeaCup makeACuppa() {
       FacadeTeaCup cup = new FacadeTeaCup();
       FacadeTeaBag teaBag = new FacadeTeaBag();
       FacadeWater water = new FacadeWater();
       cup.addFacadeTeaBag(teaBag);
       water.boilFacadeWater();
       cup.addFacadeWater(water);
       cup.steepTeaBag();
       return cup;
   }
}

class FacadeTeaCup {  
   boolean teaBagIsSteeped; 
   FacadeWater facadeWater;
   FacadeTeaBag facadeTeaBag;
    
   public FacadeTeaCup() {
       setTeaBagIsSteeped(false);
       System.out.println("behold the beautiful new tea cup");
   }    
   
   public void setTeaBagIsSteeped(boolean isTeaBagSteeped) {
       teaBagIsSteeped = isTeaBagSteeped;
   }
   public boolean getTeaBagIsSteeped() {
       return teaBagIsSteeped;
   }
    
   public void addFacadeTeaBag(FacadeTeaBag facadeTeaBagIn) {
       facadeTeaBag = facadeTeaBagIn;
       System.out.println("the tea bag is in the tea cup");
   }
   
   public void addFacadeWater(FacadeWater facadeWaterIn) {
       facadeWater = facadeWaterIn;
       System.out.println("the water is in the tea cup");  
   }   
   
   public void steepTeaBag() {
       if ( (facadeTeaBag != null) && 
             ( (facadeWater != null) && 
               (facadeWater.getWaterIsBoiling()) )
          ) {
          System.out.println("the tea is steeping in the cup");
          setTeaBagIsSteeped(true);
       } else {
          System.out.println("the tea is not steeping in the cup");
          setTeaBagIsSteeped(false);
       }           
   }
   
   public String toString() {
       if (this.getTeaBagIsSteeped()) {
           return ("A nice cuppa tea!");
       } else {
           String tempString = new String("A cup with ");
           if (facadeWater != null) {
                if (facadeWater.getWaterIsBoiling()) {
                    tempString = (tempString + "boiling water ");
                } else {
                    tempString = (tempString + "cold water ");
                }
           } else {
                tempString = (tempString + "no water ");
           }
 
           if (facadeTeaBag != null) {
                tempString = (tempString + "and a tea bag");
           } else {
                tempString = (tempString + "and no tea bag");
           } 
           return tempString;
       }
                        
   }
}

class FacadeWater {  
   boolean waterIsBoiling; 
    
   public FacadeWater() {
       setWaterIsBoiling(false);
       System.out.println("behold the wonderous water");       
   }
   
   public void boilFacadeWater() {
       setWaterIsBoiling(true);
       System.out.println("water is boiling");
   }
   
   public void setWaterIsBoiling(boolean isWaterBoiling) {
       waterIsBoiling = isWaterBoiling;
   }
   public boolean getWaterIsBoiling() {
       return waterIsBoiling;
   }
}

class FacadeTeaBag {  
   public FacadeTeaBag() {
       System.out.println("behold the lovely tea bag");
   }
}

public class FacadeDemo {
   public static void main(String[] args) {
       FacadeCuppaMaker cuppaMaker = new FacadeCuppaMaker();
       FacadeTeaCup teaCup = cuppaMaker.makeACuppa();
       System.out.println(teaCup);
   }
}
