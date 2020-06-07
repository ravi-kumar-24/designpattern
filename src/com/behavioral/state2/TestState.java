package com.behavioral.state2;

class DvdStateContext {
   private DvdStateName dvdStateName; 
    
   public DvdStateContext() {
       setDvdStateName(new DvdStateNameStars());  
       //start with stars
   }
   
   public void setDvdStateName(DvdStateName dvdStateNameIn) {
       this.dvdStateName = dvdStateNameIn;
   }
   
   public void showName(String nameIn) {
       this.dvdStateName.showName(this, nameIn);
   }
}

interface DvdStateName {  
   public void showName(DvdStateContext dvdStateContext, String nameIn);  
}

class DvdStateNameExclaim implements DvdStateName {  
    public DvdStateNameExclaim() {}
    
    public void showName(DvdStateContext dvdStateContext,String nameIn) {
         System.out.println(nameIn.replace(' ','!'));
         //show exclaim only once, switch back to stars
         dvdStateContext.setDvdStateName(new DvdStateNameStars());
    }  
}

 class DvdStateNameStars implements DvdStateName {  
    int starCount;
    
    public DvdStateNameStars() {
        starCount = 0;
    }
    
    public void showName(DvdStateContext dvdStateContext,String nameIn) {
         System.out.println(nameIn.replace(' ','*'));
         // show stars twice, switch to exclamation point
         if (++starCount > 1) {
             dvdStateContext.setDvdStateName( new DvdStateNameExclaim());
         }       
    }  
}
public class TestState {
   public static void main(String[] args) 
   {
       DvdStateContext stateContext = new DvdStateContext();
       stateContext.showName("Sponge Bob Squarepants - "+"Nautical Nonsense and Sponge Buddies");
       stateContext.showName("Jay and Silent Bob Strike Back");  
       stateContext.showName("Buffy The Vampire Slayer Season 2");
       stateContext.showName("The Sopranos Season 2");
   }
}