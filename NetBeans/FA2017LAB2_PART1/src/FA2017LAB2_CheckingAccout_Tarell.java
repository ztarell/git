
import java.util.*;

/**
 * Bank Service Application Checking Account Class By Zachary Tarell 9/11/2017
 */
public class FA2017LAB2_CheckingAccout_Tarell extends FA2017LAB2_Account_Tarell {

    //data type
    protected double fee, deposit, withDraw;
    String type = "Type: Checking Account";
    //create scanner object
    Scanner input = new Scanner(System.in);

    //constructor with super and fee
    public FA2017LAB2_CheckingAccout_Tarell(String name, int acctNumber, double balance, double fee) {
        super(name, acctNumber, balance);
        this.fee = fee;
    }

    public void openNewAccount() {
        System.out.println(super.toString() + type + "\nMonthly fee: $" + fee + "\n");
    }

    //Taken from the abstract method in Account Class
    public void printStatement() {
        System.out.println(super.toString() + "\n" + type + "\nMonthly Fee: $" + this.fee);
        double newBal = balance - fee;
        System.out.println("New Balance: $" + newBal);

    }

    //Taken from the abstract method in Account Class
    public void checkBalance() {
        System.out.println(super.toString() + "\n" + type + "\n");
    }

    public void makeDeposit() {
        System.out.println("Enter the amount to deposit:");
        deposit = input.nextDouble();
        System.out.println(super.toString() + "\nDeposit amount: $" + deposit + "\n" + type + "\n");
    }

    public void makeWithdraw() {
        System.out.println("Enter the amount to withdraw:");
        withDraw = input.nextDouble();
        balance -= withDraw;
        if (super.balance >= 20) {
            System.out.println(super.toString() + "\nWithdraw amount: $" + withDraw + "\n" + type + "\n");
        } else {
            System.out.println("NOT ENOUGH FUNDS TO WITHDRAW");
        }
    }
}
