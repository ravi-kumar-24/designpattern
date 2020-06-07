package com.structural.proxy.RMI;

import java.rmi.*;

public class MyRemoteClient {
 public static void main(String [] args) {
   try
   {
	MyRemote service = (MyRemote) Naming.lookup("rmi://cocreate-f18043/RemoteHello");
	 int sum = service.sum(10,20);
	 System.out.println("Sum(using RMI):"+sum);
	} catch(Exception e) {
	  e.printStackTrace();
  }
  }
 } 		 