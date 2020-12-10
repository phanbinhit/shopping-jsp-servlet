package controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Xuly {
	
	public Xuly() {
		
	}
	
	public String connect() {
		String output = "";
		try {
			Socket socket = new Socket("localhost", 5000);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			output = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
}
