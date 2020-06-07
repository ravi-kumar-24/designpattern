package com.behavioral.MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Observer;

class ColorFrame extends JFrame
implements java.util.Observer {
Vector observers;
Color color;
String color_name="black";
JPanel p = new JPanel(true);
//--------------------------------------
public ColorFrame(Subject s) {
super("Colors"); //set frame caption
getContentPane().add("Center", p);
observers = new Vector();
s.registerInterest(this); //register with Subject
setBounds(100, 100, 100, 100);
setVisible(true);
}
//--------------------------------------
public void sendNotify(String s) {
//Observer is notified of change here
color_name = s; //save color name
//set background to that color
if(s.toUpperCase().equals("RED"))
color = Color.red;
if(s.toUpperCase().equals("BLUE"))
color =Color.blue;
if(s.toUpperCase().equals("GREEN"))
color = Color.green;
setBackground(color);
}
//--------------------------------------
public void paint(Graphics g) {
g.drawString(color_name, 20, 50);
}
public void itemStateChanged(ItemEvent e) {
//responds to radio button clicks
//if the button is selected
if(e.getStateChange() == ItemEvent.SELECTED)
notifyObservers((JRadioButton)e.getSource());
}
//-----------------------------------------
private void notifyObservers(JRadioButton rad) {
//sends text of selected button to all observers
String color = rad.getText();
for (int i=0; i< observers.size(); i++) {
((Observer)(observers.elementAt(i))).sendNotify(color);
 }
}
}
