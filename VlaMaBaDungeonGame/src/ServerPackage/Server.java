package ServerPackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private HandleClient derClientHandler;
    private Thread ServerThread;
    private ArrayList<String> users = new ArrayList<>();
    private ArrayList<HandleClient> clients = new ArrayList<>();
    private final int SERVERPORT = 1337;

    public void process() throws Exception {
        ServerSocket ServerSocket = new ServerSocket(SERVERPORT);
        String localIP = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Warte auf Client bei: " + localIP);

        Runnable threadjob = new MeinRunnable(this, ServerSocket);
        ServerThread = new Thread(threadjob);
        ServerThread.start();

//        while (true) {
//            Socket client = ServerSocket.accept();
//
//            System.out.println("Client connected!");
//            //Adde Client zu Clients Vector
//            derClientHandler = new HandleClient(this, client, users, clients);
//            clients.add(derClientHandler);
//        }
    }

    public void broadcast(String user, String message) {
        // Brodcast Message
        for (HandleClient c : clients) {
            c.sendMessage(user, message);
        }
    }

    public HandleClient getDerClientHandler() {
        return derClientHandler;
    }

    public ArrayList<HandleClient> getClients() {
        return clients;
    }

    public class MeinRunnable implements Runnable {

        private Server derServer;
        private ServerSocket derServerSocket;

        public MeinRunnable(Server pServer, ServerSocket pServerSocket) {
            derServer = pServer;
            derServerSocket = pServerSocket;
        }

        @Override
        public void run() {
            while (true) {
                try {

                    Socket client = null;
                    client = derServerSocket.accept();
                    System.out.println("Client with IP: \"" + client.getInetAddress() + "\" connected!");

                    //Adde Client zu Clients Vector
                    derClientHandler = new HandleClient(derServer, client, users, clients);
                    clients.add(derClientHandler);

                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
