package com.structural.proxy.RMI;

import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

public int sum(int i,int j) {
	return i+j;
}
 public MyRemoteImpl() throws RemoteException{}

public static void main(String[] args) {
  try
     {
	   MyRemote service = new MyRemoteImpl();
	   Naming.rebind("RemoteHello",service);
	 }catch(Exception ex)
    {
		ex.printStackTrace();
	}
 }
}	