package com.structural.decorator.io;

import java.io.*;

public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in);
	}
 
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char)c));
	}
			
}
