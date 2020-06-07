package com.structural.proxy2;// virtual Proxy

//PotOfTeaInterface will insure that the proxy 
//  has the same methods as it's real subject

interface PotOfTeaInterface {   
   public void pourTea();
}
class PotOfTeaProxy implements PotOfTeaInterface {  
   PotOfTea potOfTea;
    
   public PotOfTeaProxy() {}
   
   public void pourTea() {
       potOfTea = new PotOfTea();
       potOfTea.pourTea();
   }
}


class PotOfTea implements PotOfTeaInterface {  
   public PotOfTea() {
       System.out.println("Making a pot of tea");
   }
   
   public void pourTea() {
       System.out.println("Pouring tea");
   }   
}
public class ProxyDemo {
   public static void main(String[] args) {
       System.out.println("TestProxy: instantiating PotOfTeaProxy");
       PotOfTeaInterface potOfTea = new PotOfTeaProxy();
       System.out.println(" ");
       System.out.println("TestProxy: pouring tea");
       potOfTea.pourTea();
   }
}
