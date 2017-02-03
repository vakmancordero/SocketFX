package socketfx.server;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import socketfx.server.utils.SocketServer;

/**
 *
 * @author Arturh
 */
public class ServerController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SocketServer server = new SocketServer(5556, new EchoHandler());
        System.out.println("Server starts.");
        
    }    
    
}
