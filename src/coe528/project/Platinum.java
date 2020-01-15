/*
 * @ Pierce Ramnarain 500856333
 */
package coe528.project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Platinum implements AccountState {
    
    @Override
    public boolean doOnlinePurchase(String username, double amount, double purchase) throws IOException{
        File file = new File("C:\\Users\\Pierce\\OneDrive\\Documents\\Year 3\\COE 528\\Labs\\TD Canada Trust\\Customers\\" + username + ".txt");
        Path path = file.toPath();
        double newBalance = amount - purchase;
        
        if(!file.exists())
            return false;
        else if(newBalance < 0){
            return false;
        }
        else{
            //Update balance in file, needs to be implemented
            ArrayList<String> newLines = new ArrayList<>();
            for(String line : Files.readAllLines(path)){
                if(line.contains("Balance:"))
                    newLines.add(line.replace("Balance: " + amount, "Balance: " + newBalance));
                else{
                    newLines.add(line);
                }
            }
            Files.write((path), newLines);
            System.out.println("online purchase success");
            return true;
        }
    }
}
