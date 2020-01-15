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

public class CustomerGUIController implements Initializable {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("UserGUI.fxml"));
    UserGUIController userGUIController = loader.getController();
    Manager manager = new Manager();
    
    String username = new String();
    @FXML private TextField depositField;
    @FXML private TextField withdrawField;
    @FXML private TextField purchaseField;
    @FXML private Button logout;
    @FXML private Label usernameText;
    @FXML private Label depositText;
    @FXML private Label depositErrorText;
    @FXML private Label withdrawText;
    @FXML private Label withdrawErrorText;    
    @FXML private Label purchaseText;
    @FXML private Label purchaseErrorText;
    @FXML private Label balanceText;


    public void depositButton(ActionEvent event) throws IOException{
        depositText.setText("");
        depositErrorText.setText("");
        withdrawText.setText("");
        withdrawErrorText.setText("");
        purchaseText.setText("");
        purchaseErrorText.setText("");
        balanceText.setText("");
        withdrawField.setText("");
        purchaseField.setText("");
        
        Customer customer = new Customer();
        String user = userGUIController.username;//customerGUIController.getName();//this.getName();
        double balance = customer.doubleBalance(user);
        if(balance == -1.0)
            depositErrorText.setText("File does not exist!");
        
        String amount = String.valueOf(depositField.getText());        
        if(!amount.matches("[0-9]+"))
            depositErrorText.setText("Please enter a number!");
        else{
            String regex = "Balance: ";
            amount = amount.replaceAll(regex, "");
            double dblamount = Double.valueOf(amount);
            System.out.println(dblamount);
            System.out.println(user);
            if (customer.depositBalance(user, balance, dblamount) == true) {
                depositText.setText("Deposit Successful");
            } else {
                depositErrorText.setText("Error");
            }
        }        
    }
    
    public void withdrawButton(ActionEvent event) throws IOException{
        depositText.setText("");
        depositErrorText.setText("");
        withdrawText.setText("");
        withdrawErrorText.setText("");
        purchaseText.setText("");
        purchaseErrorText.setText("");
        balanceText.setText("");
        depositField.setText("");
        purchaseField.setText("");
        
        
        Customer customer = new Customer();
        String user = userGUIController.username;
        double balance = customer.doubleBalance(user);
        String amount = String.valueOf(withdrawField.getText());
        if(!amount.matches("[0-9]+"))
            withdrawErrorText.setText("Please enter a number!");
        
        String regex = "Balance: ";
        amount = amount.replaceAll(regex, "");
        double dblamount = Double.valueOf(amount);
        System.out.println(dblamount);
        customer.withdrawBalance(user, balance, dblamount);

        if ((customer.withdrawBalance(user, balance, dblamount)) == true) {
            withdrawText.setText("Withdrawal successful");
        } else {
            withdrawErrorText.setText("Withdrawal unsuccessful");
        }
    }
        
    public void onlinePurchaseButton(ActionEvent event) throws IOException{
        depositText.setText("");
        depositErrorText.setText("");
        withdrawText.setText("");
        withdrawErrorText.setText("");
        purchaseText.setText("");
        purchaseErrorText.setText("");
        balanceText.setText("");
        withdrawField.setText("");
        depositField.setText("");
        
        
        Customer customer = new Customer();
        String user = userGUIController.username;
        double balance = customer.doubleBalance(user);
        String amount = String.valueOf(purchaseField.getText());
        if(!amount.matches("[0-9]+"))
            purchaseErrorText.setText("Please enter a number!");
        
        String regex = "Balance: ";
        amount = amount.replaceAll(regex, "");
        double dblamount = Double.valueOf(amount);
        System.out.println(dblamount);
        customer.doOnlinePurchase(user, balance, dblamount);

        if ((customer.doOnlinePurchase(user, balance, dblamount)) == true) {
            purchaseText.setText("Purchase successful!");
        } else {
            purchaseErrorText.setText("Purchase must be greater than $50 and NOT greater than the balance!");
        }
    }
    
    public void getBalanceButton(ActionEvent event) throws IOException{
        depositText.setText("");
        depositErrorText.setText("");
        withdrawText.setText("");
        withdrawErrorText.setText("");
        purchaseText.setText("");
        purchaseErrorText.setText("");
        withdrawField.setText("");
        depositField.setText("");
        purchaseField.setText("");
        
        Customer customer = new Customer();
        double doublebalance = Double.valueOf(customer.doubleBalance(userGUIController.username));
        
        if (doublebalance < 10000) {
            balanceText.setText("$" + doublebalance + " - Silver level");
        } 
        else if (doublebalance >= 10000 && doublebalance < 20000) {
            balanceText.setText("$" + doublebalance + " - Gold level");
        } 
        else if (doublebalance >= 20000) {
            balanceText.setText("$" + doublebalance + " - Platinum level");
        }

        
    }
            
    public void logoutButton(ActionEvent event) throws IOException{
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
