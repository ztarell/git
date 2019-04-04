
import java.util.*;

/**
 * Bank Service Application Savings Account Class By Zachary Tarell 9/11/2017
 */
public class FA2017LAB2_SavingAccount_Tarell extends FA2017LAB2_Account_Tarell {

    //data type
    protected double interest, deposit, withDraw;
    String type = "Type: Savings Account";
    Scanner input = new Scanner(System.in);

    //constructor for super and interest
    public FA2017LAB2_SavingAccount_Tarell(String name, int acctNumber, double balance, double interest) {
        super(name, acctNumber, balance);
        this.interest = interest;
    }

    public void openNewAccount() {
        System.out.println(super.toString() + type + "\nInterest Rate: " + interest*100 + "%\n");
    }

    //Taken from the abstract method in Account Class
    public void printStatement() {
        System.out.println(super.toString() + "\n" + type);
        double intRate = interest * 100;
        System.out.println("Interest Rate: " + intRate + "%");
        double interestAmt = balance * interest;
        System.out.println("Interest Amount: $" + interestAmt);
        double newBal = balance + interestAmt;
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
        if (super.balance >= 50) {
            System.out.println(super.toString() + "\nWithdraw amount: $" + withDraw + "\n" + type + "\n");
        } else {
            System.out.println("NOT ENOUGH FUNDS TO WITHDRAW");
        }
    }

}
