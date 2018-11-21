package serverproject;

import java.io.IOException;
import java.util.NoSuchElementException;
import serverproject.serverBackend.Server;

public class Runner {

    String text;

    public static void main(String args[]) throws IOException {
        Runner server = new Runner();
    }

    public Runner() throws IOException {

        Server server = new Server(12445);
        server.start();
        int i = 0;
        while (i < 1) {
            try {
                int command = Integer.parseInt(server.getNextLine());

                switch (command) {
                    case 202: //Upload to server
                        System.out.println("Upload from client.");
                        server.sendLine("302"); //Server Ready
                        text = server.getNextLine();
                        System.out.println("Recieved line: " + text);
                        if (server.getNextLine() == "206") {
                            server.sendLine("301"); //Server Finished
                            System.out.println("Done");
                        } else {
                            System.out.println("Client didn't reply with finished upload...");
                        }
                        break;
                    case 205: //Download from Server
                        System.out.println("Download to client");
                        server.sendLine("303"); //Begin Transfer
                        server.sendLine(text);
                        System.out.println("Sent: " + text);
                        server.sendLine("301"); //Server Finished
                        break;
                    case 250: //Disconnect
                        server.stop();
                        break;
                }
            } catch (NoSuchElementException e) {

            }
        }
    }

}
