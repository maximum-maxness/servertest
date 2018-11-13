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
                    case 202:
                        server.sendLine("302");
                        text = server.getNextLine();
                        server.sendLine("301");
                        break;
                    case 205:
                        server.sendLine("303");
                        server.sendLine(text);
                        server.sendLine("301");
                        break;
                    case 250:
                        server.stop();
                        break;
                }
            } catch (NoSuchElementException e) {

            }
        }
    }

}
