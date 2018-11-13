/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject.serverBackend;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author gamer
 */
public class Server {

    public int port;
    public String ip;
    public boolean alreadyStarted;
    public ServerSocket serverSocket;
    public Socket socket;

    public Server(int port) throws IOException {
//        this.ip = ip;
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
        this.alreadyStarted = false;
    }

    public void start() throws IOException {
        if (!this.alreadyStarted) {
            this.socket = serverSocket.accept();
            this.alreadyStarted = true;
            System.out.println("Started Server!");
        }
    }

    public void stop() throws IOException {
        if (this.alreadyStarted) {
            this.socket.close();
            this.alreadyStarted = false;
            System.out.println("Closed the Server!");
        }
    }

    public String getNextLine() throws IOException {
        Scanner socketScanner = new Scanner(this.socket.getInputStream());
        String reply = socketScanner.nextLine();
        System.out.println("Received Reply: " + reply);
        return reply;
    }

    public void sendLine(String text) throws IOException {
        PrintStream printStream = new PrintStream(this.socket.getOutputStream());
        printStream.println(text);
        System.out.println("Sent :" + text);
    }
}
