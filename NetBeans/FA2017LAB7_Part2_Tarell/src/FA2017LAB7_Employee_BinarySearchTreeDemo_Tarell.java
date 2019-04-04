/*
    Zach Tarell
    Driver Class - LAB7 BinarySearchTreeDemo
    Main()
    11/21/2017
 */
import java.util.*;//import for Scanner and Hashtable


public class FA2017LAB7_Employee_BinarySearchTreeDemo_Tarell {

    public static void main(String[] args) {
        FA2017LAB7_Employee_Tarell Employee = null;
        BinarySearchTree_Tarell t = new BinarySearchTree_Tarell();

        Scanner input = new Scanner(System.in);//import scanner object to read from keyboard
        int choice;
        do {//do/while loop of main menu 
            choice = mainMenu(input);

            switch (choice) {
                case 1://Insert
                    Employee = readEmployee(input);
                    t.insert(Employee);
                    break;
                case 2://Fetch
                    System.out.println("Enter employee's id to fetch:");
                    String keyID = input.nextLine();
                    Employee = t.fetch(keyID);
                    if (Employee == null) {
                        System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                    } else {
                        System.out.println(Employee);
                    }
                    break;
                case 3://Encapsulation
                    System.out.println("Enter employee's id to fetch:");
                    keyID = input.nextLine();
                    FA2017LAB7_Employee_Tarell temp = t.fetch(keyID);
                    if (temp == null) {
                        System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                    } else {
                        System.out.println("What do you want to change employee's salary to?");
                        double salary2 = input.nextDouble();
                        temp.setSalary(salary2);
                        FA2017LAB7_Employee_Tarell temp2 = t.fetch(keyID);
                        if (temp.getSalary() != temp2.getSalary()) {
                            System.out.println("\nEncapsulated!\n");
                        } else {
                            System.out.println("\nIt is NOT Encapsulated!\n");
                        }
                    }
                    break;
                case 4://Update
                    System.out.println("Enter employee's id to fetch:");
                    keyID = input.nextLine();
                    Employee = t.fetch(keyID);
                    if (Employee == null) {
                        System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                    } else {
                        System.out.println("What do you want to change employee's salary to?");
                        double newSalary = input.nextDouble();
                        Employee.setSalary(newSalary);
                        t.update(keyID, Employee);
                        System.out.println(Employee);
                    }
                    break;
                case 5://Delete
                    System.out.println("Enter employee's id to delete:");
                    keyID = input.nextLine();
                    Employee = t.fetch(keyID);
                    if (Employee == null) {
                        System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                    } else {
                        if (t.delete(keyID) == true) {                          
                            System.out.println("\nSuccessful Delete\n");
                        } else {
                            System.out.println("\nDelete was unsuccessful\n");
                        }
                    }
                    break;
                case 6://Show All                    
                    t.showAll();
                    break;
                case 0://Exit mainMenu
                    break;
            }
        } while (choice != 0);

    }//end of main

    static int mainMenu(Scanner input) {
        System.out.println("----Choose An Option----"
                + "\n1. Insert"
                + "\n2. Fetch"
                + "\n3. Encapsulation"
                + "\n4. Update"
                + "\n5. Delete"
                + "\n6. Show All"
                + "\n0. Exit");
        int task = input.nextInt();
        input.nextLine();
        return task;
    }//End of mainMenu

    //readEmployee method for inserting an Employee
    static FA2017LAB7_Employee_Tarell readEmployee(Scanner input) {
        FA2017LAB7_Employee_Tarell Employee = null;
        System.out.println("Enter Employee's first name: ");
        //keyboard.nextLine();
        String firstname = input.nextLine();

        System.out.println("Enter Employee's last name: ");
        //keyboard.nextLine();
        String lastname = input.nextLine();

        System.out.println("Enter Employee ID: ");
        String id = input.nextLine();

        System.out.println("Enter Employee's Department: ");
        String department = input.nextLine();

        System.out.println("Enter Employee Salary: ");
        double salary = input.nextDouble();

        System.out.println("Does Employee have a Title?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        int userChoice = input.nextInt();

        //If user chooses 1 we will create an employee with a title 
        if (userChoice == 1) {
            System.out.println("What is the Employee Title: ");
            input.nextLine();
            String title = input.nextLine();

            Employee = new FA2017LAB7_TitleEmployee_Tarell(firstname, lastname, id, department, salary, title);

        }//If user chooses 2 we will create a regular employee
        else if (userChoice == 2) {
            Employee = new FA2017LAB7_Employee_Tarell(firstname, lastname, id, department, salary);
        }
        return Employee;
    }//End of readEmployee

}//end of driver class
