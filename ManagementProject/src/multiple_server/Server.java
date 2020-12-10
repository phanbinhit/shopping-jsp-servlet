package multiple_server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import entities.Product;
import model.BO.ProductBoImpl;

public class Server {
	static ServerSocket server;
	private static ProductBoImpl bo = new ProductBoImpl();
	public static void main(String[] args) {
		try {
			server = new ServerSocket(5000);
			while (true) {
				Socket socket = server.accept();
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				Product product = bo.getMaxPrice();
				System.out.println(socket);
				dos.writeUTF(product.getTitle() + ": " + product.getPrice() + " $");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
