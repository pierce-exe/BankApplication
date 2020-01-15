/**
 * @ Pierce Ramnarain 500856333
 */
package coe528.project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class User implements UserProfile{
//    
    @Override
    public String login(String username, String password, String role) throws IOException{
        if(username.equals("") || password.equals("")){
            return "error";
        }
        else{
            if("manager".equals(role)){
                if(username.equals("admin") && password.equals("admin"))
                    return "manager";
                else
                    return "error";
            }
            else if("customer".equals(role)){
                File file = new File("C:\\Users\\Pierce\\OneDrive\\Documents\\Year 3\\COE 528\\Labs\\TD Canada Trust\\Customers\\" + username + ".txt");
                Path path = file.toPath();
        
                if(!file.exists())
                    return "error";
                else{
                    for(String line : Files.readAllLines(path)){
                        System.out.println(line);
                        if(line.contains("Password: ")){
                            if(line.contains("Password: " + password))
                                return "customer";
                            else
                                return "error";
                        }
                    }
                }
            }
            return "error";
        }
    }  
    
    

    public void login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean depositBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean withdrawBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doOnlinePurchase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCustomer(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomer(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

