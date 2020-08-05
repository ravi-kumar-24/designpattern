package com.behavioral.MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Watch2L extends JFrame implements ActionListener, ItemListener, Subject {

Button Close;
JRadioButton red, green, blue;
Vector observers;
//------------------------------------------
public Watch2L() {
super("Change 2 other frames");
//list of observing frames
observers = new Vector();
//add panel to content pane
JPanel p = new JPanel(true);
p.setLayout(new BorderLayout());
getContentPane().add("Center", p);
//vertical box layout
Box box = new Box(BoxLayout.Y_AXIS);
p.add("Center", box);
//add 3 radio buttons
box.add(red = new JRadioButton("Red"));
box.add(green = new JRadioButton("Green"));
box.add(blue = new JRadioButton("Blue"));
//listen for clicks on radio buttons
blue.addItemListener(this);
red.addItemListener(this);
green.addItemListener(this);
//make all part of same button group
ButtonGroup bgr = new ButtonGroup();
bgr.add(red);
bgr.add(green);
bgr.add(blue);
ColorFrame cframe = new ColorFrame(this);
//ListFrame lframe = new ListFrame(this);
}
 public void registerInterest(Observer obs) {
//adds observer to list in Vector
observers.addElement(obs);
}

 @Override
 public void actionPerformed(ActionEvent e) {

 }

 @Override
 public void itemStateChanged(ItemEvent e) {

 }
}