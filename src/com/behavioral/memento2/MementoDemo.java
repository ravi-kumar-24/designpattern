package com.behavioral.memento2;

import java.util.*;

class Originator {
 
    private String state;
    /* lots of memory consumptive private data that is not necessary to define the
     * state and should thus not be saved. Hence the small memento object. */
 
    public void set(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }
 
    public Object saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }
 
    public void restoreFromMemento(Object m) {
        if (m instanceof Memento) {
            Memento memento = (Memento) m;
            state = memento.getSavedState();
            System.out.println("Originator: State after restoring from Memento: " + state);
        }
    }
 
    private static class Memento {
 
        private String state;
 
        public Memento(String stateToSave) {
            state = stateToSave;
        }
 
        public String getSavedState() {
            return state;
        }
 
    }
 
}
 

 
class Caretaker {
 
    private List<Object> savedStates = new ArrayList<Object>();
 
    public void addMemento(Object m) {
        savedStates.add(m);
    }
 
    public Object getMemento(int index) {
        return savedStates.get(index);
    }
 
}
 
public class MementoDemo {
 
    public static void main(String[] args) {
 
        Caretaker caretaker = new Caretaker();
 
        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        caretaker.addMemento(originator.saveToMemento());
        originator.set("State3");
        caretaker.addMemento(originator.saveToMemento());
        originator.set("State4");
 
        originator.restoreFromMemento(caretaker.getMemento(1));
 
    }
 
}
