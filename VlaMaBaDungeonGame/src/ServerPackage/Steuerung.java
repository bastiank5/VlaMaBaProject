package ServerPackage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Steuerung {

    private ServerPanel dasServerPanel;
    private Server derServer;
    private HandleClient derClientHandler;

    public Steuerung(ServerPanel pServerPanel) {
        this.dasServerPanel = pServerPanel;
        derServer = new Server();
        derClientHandler = derServer.getDerClientHandler();
        
//        zeigeConnectedClients();
        
    }
    
    private void zeigeConnectedClients() {
        for (int i = 0; i < derServer.getClients().size(); i++) {
//            System.out.println(derServer.getClients().);
        }
    }

    public void starteServer() {
        try {
            derServer.process();
        } catch (Exception ex) {
            Logger.getLogger(Steuerung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
