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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ManagerGUIController implements Initializable {

    @FXML private TextField addUsernameField;
    @FXML private TextField addPasswordField;
    @FXML private TextField deleteCustomerField;
    @FXML private Button addCustomer;
    @FXML private Button deleteCustomer;
    @FXML private Button logout;
    @FXML private Label addCustomerText;
    @FXML private Label addCustomerErrorText;
    @FXML private Label deleteCustomerText;
    @FXML private Label deleteCustomerErrorText;

   
    
    public void addCustomerButton(ActionEvent event) throws IOException{
        addCustomerText.setText("");
        addCustomerErrorText.setText("");
        deleteCustomerText.setText("");
        deleteCustomerErrorText.setText("");
        deleteCustomerField.setText("");
        
        
        String username = String.valueOf(addUsernameField.getText());
        String password = String.valueOf(addPasswordField.getText());

        Manager manager = new Manager();
        if(username.equals("") || password.equals(""))
            addCustomerErrorText.setText("Account must contain letters!");
        else if(manager.addCustomer(username, password, 100) == true)
            addCustomerText.setText("Account Created!");
        else
            addCustomerErrorText.setText("Account already exists!");
    }
    
    public void deleteCustomerButton(ActionEvent event) throws IOException{
        addCustomerText.setText("");
        addCustomerErrorText.setText("");
        deleteCustomerText.setText("");
        deleteCustomerErrorText.setText("");
        addUsernameField.setText("");
        addPasswordField.setText("");
        
        
        String username = String.valueOf(deleteCustomerField.getText());

        Manager manager = new Manager();
        
        if(manager.deleteCustomer(username) == true)
            deleteCustomerText.setText("Account Deleted!");
        else
            deleteCustomerErrorText.setText("Account does not exists!");
    }
    
    public void logout1Button(ActionEvent event) throws IOException{
        Parent userGUI = FXMLLoader.load(getClass().getResource("UserGUI.fxml"));
        Scene userScene = new Scene(userGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(userScene);
        window.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
