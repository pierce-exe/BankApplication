/*
 * @ Pierce Ramnarain 500856333
 */
package coe528.project;

import java.io.IOException;

public interface AccountState {
    
    boolean doOnlinePurchase(String username, double amount, double purchase)throws IOException;
    
}
