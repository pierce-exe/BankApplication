/**
 * @ Pierce Ramnarain 500856333
 */
package coe528.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author Pierce
 */
public class Manager extends User{
/**
 * Overview: Manager is a mutable, bounded collection of customers stored in files.
 * @param username Username from ManagerGUIController class
 * @param password Password from ManagerGUIController class
 * @param balance balance from ManagerGUIController
 * @return
 * @throws IOException Thrown when file is not found
 */

    /**
     * Requires: username and password from user input
     * Effects: creates a new customer file given username, password, and 100$ balance
     * @param username Username from ManagerGUIController class
     * @param password Password from ManagerGUIController class
     * @param balance balance from ManagerGUIController class
     * @return boolean
     * @throws IOException Thrown when file is not found
     */
    public boolean addCustomer(String username, String password, double balance) throws IOException{
        File file = new File("./Customers\\" + username + ".txt");
        if(file.exists() || "admin".equals(username))
            return false;
        else{
            file.getParentFile().mkdirs();
            file.createNewFile();
        
            FileWriter writer = new FileWriter(file); 
            writer.write("Username: " + username + "\n" + "Password: " + password + "\n" + "Balance: " + balance ); 
            writer.flush();
            writer.close();
            return true;
        }

    }
    
    /**
     * Requires: username from user input
     * Modifies: file with username
     * Effects: deletes customer file given username
     * @param username Username from ManagerGUIController class
     * @return boolean
     */
    @Override
    public boolean deleteCustomer(String username){
        File file = new File("./Customers\\" + username + ".txt");
        
        if(!file.exists())    
            return false;
        else{
            file.delete();        
            return true;
        }
    }
    
    /**
     * The rep invariant is:
     * RI(c) =  return false if file already exists && return true if each file contains a username, password, and balance
     * @return boolean
     */
    public boolean repOK(){
        File dir = new File("./Customers\\");
        String customers = null;
        File[] directoryListing = dir.listFiles();
        if (directoryListing == null){
            return false;
        }
        for(File child : directoryListing){
            Scanner scanner = new Scanner(System.in);
            if("Username: ".equals(scanner.next("Username:")) && "Password: ".equals(scanner.next("Password:"))){
                if("Balance: ".equals(scanner.next("Balance:")))
                    return true;
            }
        }    
        return true;
    }
    
    
    /**
     * The abstraction function is:
     * AF(c) = {c.dir.listFiles() | directoryListing != null}
     * @return String
     */
    @Override
    public String toString(){
        File dir = new File("./Customers\\");
        String customers = null;
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null){
            for(File child : directoryListing){
                customers = customers + child.getPath();
            }
        }
        return customers;
    }
}
