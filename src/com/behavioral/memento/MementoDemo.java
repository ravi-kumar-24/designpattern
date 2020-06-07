package com.behavioral.memento;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.ArrayList;

//the originator

class DvdDetails {  
   private String titleName;  
   private ArrayList stars;
   private char encodingRegion;
    
   public DvdDetails(String titleName, 
                     ArrayList stars, 
                     char encodingRegion) {
       this.setTitleName(titleName);
       this.setStars(stars);
       this.setEncodingRegion(encodingRegion);
   }    
  
   private void setTitleName(String titleNameIn) {
       this.titleName = titleNameIn;
   }
   private String getTitleName() {
       return this.titleName;
   }
   
   private void setStars(ArrayList starsIn) {
       this.stars = starsIn;
   }
   public void addStar(String starIn) {
       stars.add(starIn);
   }
   private ArrayList getStars() {
       return this.stars;
   }
   private static String getStarsString(ArrayList starsIn) {
       int count = 0;
       StringBuffer sb = new StringBuffer();
       ListIterator starsIterator = starsIn.listIterator();
       while (starsIterator.hasNext()) {
           if (count++ > 0) {sb.append(", ");} 
           sb.append((String) starsIterator.next());
       }
       return sb.toString();
   } 
   
   private void setEncodingRegion(char encodingRegionIn) {
      this.encodingRegion = encodingRegionIn;
   }
   private char getEncodingRegion() {
       return this.encodingRegion;
   }  
   
   public String formatDvdDetails() {
       return ("DVD: " + this.getTitleName() + 
               ", starring: " + getStarsString(getStars()) + 
               ", encoding region: " + this.getEncodingRegion()); 
   }   
   
   //sets current state to what DvdMemento has
   public void setDvdMemento(DvdMemento dvdMementoIn) {
       dvdMementoIn.getState();
   }
   //save current state of DvdDetails in a DvdMemento
   public DvdMemento createDvdMemento() {
       DvdMemento mementoToReturn = new DvdMemento();
       mementoToReturn.setState();
       return mementoToReturn;
   }
   
   //an inner class for the memento
   class DvdMemento {
       private String mementoTitleName;  
       private ArrayList mementoStars;
       private char mementoEncodingRegion;       
       
       //sets DvdMementoData to DvdDetails
       public void setState() {
            //Because String are immutable we can just set 
            //  the DvdMemento Strings to = the DvdDetail Strings.
            mementoTitleName = getTitleName();
            mementoEncodingRegion = getEncodingRegion();
            //However, ArrayLists are not immutable,
            //  so we need to instantiate a new ArrayList. 
            mementoStars = new ArrayList(getStars());
       } 
       //resets DvdDetails to DvdMementoData
       public void getState() {
            setTitleName(mementoTitleName);
            setStars(mementoStars);
            setEncodingRegion(mementoEncodingRegion);  
       }    
       
       //only useful for testing
       public String showMemento() {
            return ("DVD: " + mementoTitleName + 
                    ", starring: " + getStarsString(mementoStars) + 
                    ", encoding region: " + mementoEncodingRegion); 
       }      
   }
}


public class MementoDemo {
   public static void main(String[] args) {
       DvdDetails.DvdMemento dvdMementoCaretaker;  
       //the Caretaker
       
       ArrayList stars = new ArrayList();
       stars.add(new String("Guy Pearce"));
       DvdDetails dvdDetails = 
         new DvdDetails("Memento", stars, '1'); 
       dvdMementoCaretaker = dvdDetails.createDvdMemento();
       System.out.println("as first instantiated");
       System.out.println(dvdDetails.formatDvdDetails());
       
       System.out.println("");       
       dvdDetails.addStar("edskdzkvdfb");  
       //oops - Cappuccino on the keyboard!
       System.out.println("after star added incorrectly");
       System.out.println(dvdDetails.formatDvdDetails());
       
       System.out.println("");
       System.out.println("the memento");
       System.out.println(dvdMementoCaretaker.showMemento());
       //show the memento
       
       System.out.println("");
       dvdDetails.setDvdMemento(dvdMementoCaretaker);
       //back off changes
       System.out.println(
         "after DvdMemento state is restored to DvdDetails");
       System.out.println(dvdDetails.formatDvdDetails());
   }
}  
