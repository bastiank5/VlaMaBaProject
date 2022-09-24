package ServerPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class HandleClient extends Thread {

    private Server derServer;
    private BufferedReader input;
    private PrintWriter output;
    private ArrayList dieUsers, dieClients;
    private String name = "";  //client name

    public HandleClient(Server pServer, Socket client, ArrayList pUsers, ArrayList pClients) throws Exception {
        derServer = pServer;
        dieClients = pClients;
        dieUsers = pUsers;

        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        output = new PrintWriter(client.getOutputStream(), true);

        name = input.readLine();
        dieUsers.add(name); 
        derServer.broadcast(name, "Has connected!");
        start();
    }

    public void sendMessage(String username, String message) {
        output.println("[" + username + "]: " + message);
    }

    public String getUserName() {
        return name;
    }

    @Override
    public void run() {
        String message;
        try {
            while (true) {
                message = input.readLine();
                if (message.equals("!end")) {
                    derServer.broadcast(name, "Has disconnected!");
                    dieClients.remove(this);
                    dieUsers.remove(name);
                    break;
                }
                derServer.broadcast(name, message);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
