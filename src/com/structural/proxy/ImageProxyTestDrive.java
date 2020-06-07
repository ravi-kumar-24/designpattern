package com.structural.proxy;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ImageProxyTestDrive {
	ImageComponent imageComponent;
	JFrame frame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
	Hashtable cds = new Hashtable();
 
	public static void main (String[] args) throws Exception {
		ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
	}
 
	public ImageProxyTestDrive() throws Exception{		
        cds.put("Window 1","http://localhost/Photos/Room1Window.jpg");
        cds.put("Window 2","http://localhost/Photos/Room2Window1.jpg");
        cds.put("Window 3","http://localhost/Photos/Room2Window2.jpg");        
        cds.put("Doors","http://localhost/Photos/Room1and2Doors.jpg");

		URL initialURL = new URL((String)cds.get("Doors"));
		menuBar = new JMenuBar();
		menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

		for(Enumeration e = cds.keys(); e.hasMoreElements();) {
			String name = (String)e.nextElement();
        	JMenuItem menuItem = new JMenuItem(name);
        	menu.add(menuItem); 
        	menuItem.addActionListener(new ActionListener() {
          		  public void actionPerformed(ActionEvent event) {
           		     imageComponent.setIcon(new ImageProxy(getCDUrl(event.getActionCommand())));
					frame.repaint();
           	      }
        	});
		}
 		
		// set up frame and menus
 
		Icon icon = new ImageProxy(initialURL);
		imageComponent = new ImageComponent(icon);
		frame.getContentPane().add(imageComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);

	}

	URL getCDUrl(String name) {
		try {
			return new URL((String)cds.get(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
