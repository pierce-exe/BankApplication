/*
 * @ Pierce Ramnarain 500856333
 */
package coe528.project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Customer extends User{
    String username;
    String password;
    double balance;
//    AccountState state;
    Silver silver;
    Gold gold;
    Platinum platinum;
    
    public Customer(){
        silver = new Silver();
        gold = new Gold();
        platinum = new Platinum();
//        state = new Silver();
    }
    
//    void setState(AccountState state){
//        this.state = state;
//    }

    public boolean depositBalance(String username, double amount, double deposit) throws IOException{
        File file = new File("./Customers\\" + username + ".txt");
        Path path = file.toPath();
        double newBalance = amount + deposit;
        System.out.println(username);
        if(!file.exists())
            return false;
        else{
            //Update balance in file, needs to be implemented
            ArrayList<String> newLines = new ArrayList<>();
            for(String line : Files.readAllLines(path)){
                if(line.contains("Balance: "))
                    newLines.add(line.replace("Balance: " + amount, "Balance: " + newBalance));
                else
                    newLines.add(line);
            }
            Files.write((path), newLines);
            return true;
        }
    }
    
    public boolean withdrawBalance(String username, double amount, double deposit) throws IOException{
        File file = new File("./Customers\\" + username + ".txt");
        Path path = file.toPath();
        double newBalance = amount - deposit;
        
        if(!file.exists())
            return false;
        else if(newBalance < 0){
            return false;
        }
        else{
            //Update balance in file, needs to be implemented
            ArrayList<String> newLines = new ArrayList<>();
            for(String line : Files.readAllLines(path)){
                if(line.contains("Balance: "))
                    newLines.add(line.replace("Balance: " + amount, "Balance: " + newBalance));
                else
                    newLines.add(line);
            }
            Files.write((path), newLines);
            return true;
        }
    }
    
    public String getBalance(String username) throws IOException{
        File file = new File("./Customers\\" + username + ".txt");
        Path path = file.toPath();
        String balance = null;
        
        if(!file.exists())
            return "false";
        else{
            //Update balance in file, needs to be implemented
            for(String line : Files.readAllLines(path)){
                if(line.contains("Balance: "))
                     balance = line;
            }
            String regex = "Balance:";
            balance = balance.replaceAll(regex, "");
            
            return balance;
        }
    }
    
        public Double doubleBalance(String username) throws IOException{
            File file = new File("./Customers\\" + username + ".txt");
            Path path = file.toPath();
            String balance = null;
            
            if (!file.exists())
                return -1.0;
            else {
                //Update balance in file, needs to be implemented
                for (String line : Files.readAllLines(path)) {
                    if (line.contains("Balance: "))
                        balance = line;
                }
                    
            String regex = "Balance: ";
            balance = balance.replaceAll(regex, "");
            double doublebalance = Double.valueOf(balance);
            return doublebalance;
        }
    }
    
    public boolean doOnlinePurchase(String username, double balance, double purchase) throws IOException{
        boolean onlinePurchase = false;
        
        if(purchase >= 50){
            if(balance < 10000){
                onlinePurchase = silver.doOnlinePurchase(username, balance, purchase);
            }
            if(balance >= 10000 && balance < 20000){
                onlinePurchase = gold.doOnlinePurchase(username, balance, purchase);
            }
            if(balance >= 20000){
                onlinePurchase = platinum.doOnlinePurchase(username, balance, purchase);
            }
            return onlinePurchase;
        }
        else{
            return false;
        }
    }    
}
