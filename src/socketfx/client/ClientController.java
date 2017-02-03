package socketfx.client;

import java.net.InetAddress;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import socketfx.client.utils.SocketClient;

/**
 *
 * @author Arturh
 */
public class ClientController implements Initializable {
    
    @FXML
    private TextField messageTF;
    
    private SocketClient client;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.client = new SocketClient("192.168.0.2", 5556);
    }
    
    @FXML
    private void send() {
        
        String message = this.messageTF.getText();
        
        if (!message.trim().isEmpty()) {
            
            client.println(message);
            System.out.println(client.readLine());
            
        }
        
    }
    
}
