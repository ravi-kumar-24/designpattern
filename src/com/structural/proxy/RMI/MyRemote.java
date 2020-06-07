package com.structural.proxy.RMI;

import java.rmi.*;
public interface MyRemote extends Remote {
  public int sum(int i, int j) throws RemoteException;
 }
