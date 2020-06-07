package com.structural.bridge2;

/* abstraction */
abstract class Soda {  
   SodaImp sodaImp; 
   
   public void setSodaImp() {
       this.sodaImp = SodaImpSingleton.getTheSodaImp();
   }
   public SodaImp getSodaImp() {
       return this.sodaImp;
   }
   
   public abstract void pourSoda();
}

/* RefinedAbstraction */
 class MediumSoda extends Soda {  
   public MediumSoda() {
       setSodaImp();
   }
   
   public void pourSoda() {
       SodaImp sodaImp = this.getSodaImp();
       for (int i = 0; i < 2; i++) {
           System.out.print("...glug...");
           sodaImp.pourSodaImp();
       }
       System.out.println(" ");
   }
}

class SuperSizeSoda extends Soda {  
   public SuperSizeSoda() {
       setSodaImp();
   }
   
   public void pourSoda() {
       SodaImp sodaImp = this.getSodaImp();
       for (int i = 0; i < 5; i++) {
           System.out.print("...glug...");
           sodaImp.pourSodaImp();
       }
       System.out.println(" ");       
   }
}

/* Implementation */
 abstract class SodaImp {  
   public abstract void pourSodaImp();
}

class CherrySodaImp extends SodaImp {
   CherrySodaImp() {}
    
   public void pourSodaImp() {
       System.out.println("Yummy Cherry Soda!");
   }
}

class GrapeSodaImp extends SodaImp {
   GrapeSodaImp() {}
    
   public void pourSodaImp() {
       System.out.println("Delicious Grape Soda!");
   }
}

class OrangeSodaImp extends SodaImp {  
   OrangeSodaImp() {}
    
   public void pourSodaImp() {
       System.out.println("Citrusy Orange Soda!");
   }
}

class SodaImpSingleton {  
    private static SodaImp sodaImp;
   
    public SodaImpSingleton(SodaImp sodaImpIn) {
        this.sodaImp = sodaImpIn;
    }
    
    public static SodaImp getTheSodaImp() {
        return sodaImp;
    }
}





public class BridgeDemo1 {
   public static void testCherryPlatform() {
       SodaImpSingleton sodaImpSingleton = 
         new SodaImpSingleton(new CherrySodaImp());
       System.out.println(
         "testing medium soda on the cherry platform");
       MediumSoda mediumSoda = new MediumSoda();
       mediumSoda.pourSoda();
       System.out.println(
         "testing super size soda on the cherry platform");
       SuperSizeSoda superSizeSoda = new SuperSizeSoda();
       superSizeSoda.pourSoda();       
   }
   
   public static void testGrapePlatform() {
       SodaImpSingleton sodaImpSingleton = 
         new SodaImpSingleton(new GrapeSodaImp());
       System.out.println(
         "testing medium soda on the grape platform");
       MediumSoda mediumSoda = new MediumSoda();
       mediumSoda.pourSoda();
       System.out.println(
         "testing super size soda on the grape platform");
       SuperSizeSoda superSizeSoda = new SuperSizeSoda();
       superSizeSoda.pourSoda();       
   }   
   
   public static void testOrangePlatform() {
       SodaImpSingleton sodaImpSingleton = 
         new SodaImpSingleton(new OrangeSodaImp());
       System.out.println(
         "testing medium soda on the orange platform");
       MediumSoda mediumSoda = new MediumSoda();
       mediumSoda.pourSoda();
       System.out.println(
         "testing super size soda on the orange platform");
       SuperSizeSoda superSizeSoda = new SuperSizeSoda();
       superSizeSoda.pourSoda();       
   }
    
   public static void main(String[] args) {
        testCherryPlatform();
        testGrapePlatform();
        testOrangePlatform();
   }
}
