import java.io.*;
import java.net.*;

public class Exercise35_TCPClientServerChat {
    public static void main(String[] args) {
        System.out.println("This program contains both the Server and Client code.");
        System.out.println("To run them, you would typically compile this and run the Server and Client in separate threads or processes.");
        
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(5000)) {
                System.out.println("Server listening on port 5000...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                String message = in.readUTF();
                System.out.println("Server received: " + message);
                
                out.writeUTF("Hello from Server! I received your message.");
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        Thread clientThread = new Thread(() -> {
            try {
                // Short wait to ensure server starts first
                Thread.sleep(1000); 
                
                try (Socket socket = new Socket("localhost", 5000)) {
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    
                    out.writeUTF("Hello Server! This is the Client.");
                    
                    String response = in.readUTF();
                    System.out.println("Client received: " + response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        serverThread.start();
        clientThread.start();
    }
}
