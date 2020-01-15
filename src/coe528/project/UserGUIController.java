/**
 * FXML Controller class
 * @ Pierce Ramnarain 500856333
 */
package coe528.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class UserGUIController implements Initializable {
    
    User user = new User();
    Manager manager = new Manager();
    public static String username = new String();
    
    @FXML private TextField userField;
    @FXML private PasswordField passwordField;
    @FXML private RadioButton customerButton;
    @FXML private RadioButton managerButton;
    @FXML private ToggleGroup role;
    @FXML private Button login;
    @FXML private Label outputText;
   
        
    public void loginButtonPushed(ActionEvent event) throws IOException{
        
        String username = userField.getText();
        this.username = username;
        String password = passwordField.getText();
        RadioButton button = (RadioButton) role.getSelectedToggle();
        String state = user.login(username, password, button.getText());
        
        
        if("manager".equals(state)){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ManagerGUI.fxml"));
            Parent root = loader.load();
            Scene managerScene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(managerScene);
            window.show();    
        }
        
        else if("customer".equals(state)){
            Parent customerGUI = FXMLLoader.load(getClass().getResource("CustomerGUI.fxml"));
            Scene customerScene = new Scene(customerGUI);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(customerScene);
            window.show();    
        }
        
        else if("error".equals(state)){
            outputText.setText("Sorry, your login entry doesn't match our records. Please try again.");
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}   


