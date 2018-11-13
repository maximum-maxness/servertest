package serverproject;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Server {
    
    String text;

    public static void main(String args[]) throws IOException {
        Server server = new Server();
    }
    
    public Server () throws IOException {
        
        ServerSocket serverSocket = new ServerSocket(12445);
        Socket socket = serverSocket.accept();
        Scanner socketScanner = new Scanner(socket.getInputStream());

        int i = 0;
        while (i < 1) {
            
            try {
                text = socketScanner.nextLine();
            } catch (NoSuchElementException e) {
                
            }
            
            

            PrintStream printStream = new PrintStream(socket.getOutputStream());
            
            printStream.println(text);
            printStream.println(text);
            printStream.println(text);
            
            
            System.out.println(text);
            System.out.println("sent");
        }
    }

}
