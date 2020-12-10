package multiple_server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import bo.ProductBo;
import entities.Product;

public class Server {
	static ServerSocket server;
	private static ProductBo bo = new ProductBo();
	public static void main(String[] args) {
		try {
			server = new ServerSocket(5000);
			System.out.println("Server is running...");
			while (true) {
				Socket socket = server.accept();
				System.out.println("Socket: " + socket);
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				Product product = bo.getMaxPrice();
				dos.writeUTF(product.getTitle() + ": " + product.getPrice() + " $");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
