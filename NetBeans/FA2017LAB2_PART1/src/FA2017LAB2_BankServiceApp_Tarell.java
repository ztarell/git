
import java.util.*;

/**
 * Bank Service Application Driver Class (Main) By Zachary Tarell 9/11/2017
 */
public class FA2017LAB2_BankServiceApp_Tarell {

    public static void main(String[] args) {
        //Make super class 'Account' = null so it will repeat until user opens a new account
        FA2017LAB2_Account_Tarell Account = null;
        String name;
        int task, acctNumber;
        int choice;
        double balance;

        do {
            //Display options 1-5 for user, and exit
            Scanner input = new Scanner(System.in);
            System.out.println("1. Open A New Account");
            System.out.println("2. Check Current Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Print Monthly Statement");
            System.out.println("0. Exit");
            task = input.nextInt();

            //Switch statement for task choosen
            switch (task) {
                case 1://User enters Name, Account Number, and Balance because these are all common variables
                    System.out.println("Enter your last name, first name:");
                    input.nextLine();
                    name = input.nextLine();
                    System.out.println("Enter your account number:");
                    acctNumber = input.nextInt();
                    System.out.println("Enter your balance:");
                    balance = input.nextDouble();
                    System.out.println("1. Checking\n2. Savings");//ask user which account to open
                    choice = input.nextInt();
                    //if/else for Checking/Savings then enter fee or interest rate  
                    if (choice == 1) {
                        System.out.println("Enter monthly fee:");
                        double fee = input.nextDouble();
                        //Object 'Account' for Checking passes fee
                        Account = new FA2017LAB2_CheckingAccout_Tarell(name, acctNumber, balance, fee);
                        Account.openNewAccount();   //display in proper format for Checking Account
                        
                    } else if (choice == 2) {
                        System.out.println("Enter interest rate as a decimal:");
                        double interest = input.nextDouble();
                        //Object 'Account' for Savings passes interest
                        Account = new FA2017LAB2_SavingAccount_Tarell(name, acctNumber, balance, interest);
                        Account.openNewAccount();   //display in proper format for Checking Account
                    }
                    break;
                case 2:
                    if (Account == null) {
                        System.out.println("Open an Account First!");
                    } else {
                        Account.checkBalance(); //call checkBalance method from Abstract class
                    }
                    break;
                case 3:
                    if (Account == null) {
                        System.out.println("Open an Account First!");
                    } else {
                        Account.makeDeposit();  //call makeDeposit method from Abstract class
                    }
                    break;
                case 4:
                    if (Account == null) {
                        System.out.println("Open an Account First!");
                    } else {
                        Account.makeWithdraw(); //call makeWithdraw method from Abstract class
                    }
                    break;
                case 5:
                    if (Account == null) {
                        System.out.println("Open an Account First!");
                    } else {
                        Account.printStatement();   //call printStatement method from Abstract class
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (task != 0);
    }//end of main driver class
}//end of class
