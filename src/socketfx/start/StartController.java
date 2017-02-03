package socketfx.start;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Arturh
 */
public class StartController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void start(ActionEvent event) throws IOException {
        
        Button button = (Button) event.getSource();
        String side = button.getText();
        
        System.out.println("Inicializando el " + side + "...");
        
        this.openFXML("/socketfx/" + side.toLowerCase() + "/" + side + "FXML.fxml", side);
        
        button.getScene().getWindow().hide();
        
    }
    
    @FXML
    private void openFXML(String fxml, String title) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml)); 
       
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        
        stage.setTitle(title);
        stage.show();
        
    }
    
}
