package serverproject;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        int number, temp;
        Scanner kbScanner = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 12445);
        Scanner socketScanner = new Scanner(socket.getInputStream());

        int i = 0;
        while (i < 1) {
            System.out.println("Enter a number");
            number = kbScanner.nextInt();
            PrintStream printSocket = new PrintStream(socket.getOutputStream());
            printSocket.println(number);
            temp = socketScanner.nextInt();
            System.out.println(temp);
        }
    }

}

