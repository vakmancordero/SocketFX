package socketfx.client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;

/**
 *
 * @author Arturh
 */
public class ClientController implements Initializable {
    
    @FXML
    private TextField messageTF;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void send() {
        
        String message = this.messageTF.getText();
        
        if (!message.trim().isEmpty()) {
            
            //Enviar jijitl
            
        }
        
    }
    
}
