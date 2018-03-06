package Lab07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessingServer {

	public static void main(String[] args) {
		int port = 5150;

		int high = 0;
		int low = 0;
		int middle = 0;

		try {

			ServerSocket server = new ServerSocket(port);
			Socket socket = server.accept();

			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();

			Scanner scan = new Scanner(input);
			PrintWriter writer = new PrintWriter(output, true);

			while(scan.hasNext()){
				
				low = scan.nextInt();
				high = scan.nextInt();
				middle = (low + high) / 2;
				
				writer.println(middle);
				
				while(scan.hasNext()){
					String line = scan.next();
					
					if(line.equals("low")){
						low = middle;
					}else if(line.equals("high")){
						high = middle;
					}else if(line.equals("lost") || line.equals("won")){
						break;
					}
					
					middle = (low + high) / 2;
					writer.println(middle);
				}
			}
			
			scan.close();
			writer.close();
			socket.close();
			server.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
