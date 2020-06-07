package com.creational.prototype;

class PrototypeFactory {
    AbstractSpoon prototypeSpoon;
    AbstractFork prototypeFork;
    
    public PrototypeFactory(AbstractSpoon spoon, AbstractFork fork) {
       prototypeSpoon = spoon;
       prototypeFork = fork;
   }
    
   public AbstractSpoon makeSpoon() {
       return (AbstractSpoon)prototypeSpoon.clone();
   }
   public AbstractFork makeFork() {
       return (AbstractFork)prototypeFork.clone();
   }
}

abstract class AbstractSpoon implements Cloneable {  
   String spoonName; 
    
   public void setSpoonName(String spoonName) {
       this.spoonName = spoonName;
   }
   public String getSpoonName() {
       return this.spoonName;
   }
   
   public Object clone() {
       Object object = null;
       try {
           object = super.clone();
       } catch (CloneNotSupportedException exception) {
           System.err.println("AbstractSpoon is not Cloneable");
       }
       return object;
   }
}

abstract class AbstractFork implements Cloneable
{  
   String forkName; 
    
   public void setForkName(String forkName) {
       this.forkName = forkName;
   }
   public String getForkName() {
       return this.forkName;
   }
   
   public Object clone() 
   {
       Object object = null;
       try {
           object = super.clone();
       } catch (CloneNotSupportedException exception) {
           System.err.println("AbstractFork is not Cloneable");
       }
       return object;
   }   
}

class SoupSpoon extends AbstractSpoon {  
   public SoupSpoon() {
       setSpoonName("Soup Spoon");
   }
}

class SaladSpoon extends AbstractSpoon {  
   public SaladSpoon() {
       setSpoonName("Salad Spoon");     
   }
}

class SaladFork extends AbstractFork {  
   public SaladFork() {
       setForkName("Salad Fork");
   }
}

public class TestPrototype { 
   public static void main(String[] args) {
       System.out.println("Creating a Prototype Factory with " + " a SoupSpoon and a SaladFork");
       PrototypeFactory prototypeFactory = new PrototypeFactory(new SoupSpoon(), new SaladFork());
       AbstractSpoon spoon =   prototypeFactory.makeSpoon();
	   AbstractSpoon spoon2 =   prototypeFactory.makeSpoon();
	   if (spoon==spoon2) 
	    System.out.println("equals");
		
       AbstractFork fork =   prototypeFactory.makeFork();
       System.out.println("Getting the Spoon and Fork name:");
       System.out.println("Spoon: " + spoon.getSpoonName() + ", Fork: " + fork.getForkName());
       System.out.println(" ");       
       System.out.println("Creating a Prototype Factory " +  "with a SaladSpoon and a SaladFork");
       prototypeFactory =   new PrototypeFactory(new SaladSpoon(), new SaladFork());
       spoon = prototypeFactory.makeSpoon();
       fork = prototypeFactory.makeFork();
       System.out.println("Getting the Spoon and Fork name:");
       System.out.println("Spoon: " + spoon.getSpoonName() + ", Fork: " + fork.getForkName());
    }
}
