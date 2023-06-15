import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	static PrintWriter out;

	public static void main(String[] args) {
		// You can use print statements as follows for debugging, they'll be visible
		// when running tests.
		System.out.println("Logs from your program will appear here!");

		// Uncomment this block to pass the first stage
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		int port = 6379;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setReuseAddress(true);
			System.out.print("Connecting");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			// Wait for connection from client.
			clientSocket = serverSocket.accept();
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			out.println("+PONG\r");

		} catch (IOException | InterruptedException e) {
			System.out.println("IOException: " + e.getMessage());
		} finally {
			out.close();
			try {
				if (clientSocket != null) {
					clientSocket.close();
				}
			} catch (IOException e) {
				System.out.println("IOException: " + e.getMessage());
			}
		}
	}
}
