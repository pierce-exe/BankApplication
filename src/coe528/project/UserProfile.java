/*
 * @ Pierce Ramnarain 500856333
 */
package coe528.project;

import java.io.IOException;

public interface UserProfile {

    public String login(String username, String password, String role) throws IOException;
    
    public void logout();
    
    public boolean depositBalance();
    
    public boolean withdrawBalance();
    
    public double getBalance();
    
    public void doOnlinePurchase();
    
    public boolean addCustomer(String username);
    
    public boolean deleteCustomer(String username);

}
