/**
 * Bank Service Application
 * Account Class
 * By Zachary Tarell
 * 9/11/2017
 */

public abstract class FA2017LAB2_Account_Tarell {

    protected String name;
    protected int acctNumber;
    protected double balance;

    public FA2017LAB2_Account_Tarell(String n, int aNumber, double bal) {
        name = n;
        acctNumber = aNumber;
        balance = bal;
    }
    
    public abstract void openNewAccount();
    public abstract void makeDeposit();
    public abstract void makeWithdraw();
    public abstract void printStatement();
    public abstract void checkBalance ();

    // to String
    public String toString() {
            
        String s = "Account Name: " + name 
                + "\nAccount Number: " + acctNumber
                + "\nBalance: $" + balance;
        return s;
    }
}
