/**
 *Employee System Application
 * By Zachary Tarell
 * Driver Class (main)
 * 9/14/2017
 */
import java.util.*;
import javax.swing.*;

public class FA2017LAB3_EmployeeSystem_Tarell {
    //Driver Class (main)
    public static void main(String[] args) {
        FA2017LAB3_Employee_Tarell employee = null;
        FA2017LAB3_UnsortedOptimizedArray_Tarell myUOA = new FA2017LAB3_UnsortedOptimizedArray_Tarell();//Creates object of UnsortedOptimizedArray
        int task, choice;

        //Do-While loop to run until the user selects 'exit'
        do {
            //Displays main menu - reads from input Scanner object
            Scanner input = new Scanner(System.in);
            System.out.println("\nCOMPANY XYZ - EMPLOYEES");
            System.out.println("1.  Insert");
            System.out.println("2.  Fetch");
            System.out.println("3.  Verify Encapsulation");
            System.out.println("4.  Delete");
            System.out.println("5.  Update");
            System.out.println("6.  Show All Employees");
            System.out.println("0.  Exit");
            task = input.nextInt();
            //Switch statement with task chosen from Scanner - Asks user for variables to insert into array
            switch (task) {
                case 1:
                    System.out.println("Enter employee name:");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.println("Enter employee ID:");
                    String id = input.nextLine();
                    System.out.println("Enter employee address:");
                    String address = input.nextLine();
                    System.out.println("Enter employee salary:");
                    double salary = input.nextDouble();
                    System.out.println("Does the employee have a title\n1. Yes\n2. No:");
                    choice = input.nextInt();
                    if (choice == 1) {//whichever user chooses to have a title or not
                        System.out.println("Enter the employee title:");
                        input.nextLine();
                        String eTitle = input.nextLine();
                        employee = new FA2017LAB3_EmployeeWithTitle_Tarell(name, id, address, salary, eTitle);//employee object set to inherit EmployeeWithTitle class
                        myUOA.insert(employee);
                    } else if (choice == 2) {
                        employee = new FA2017LAB3_Employee_Tarell(name, id, address, salary);//employee object set to inherit Employee w/out a title class
                        myUOA.insert(employee);
                    }
                    System.out.println(employee.toString());//Display with toString method
                    break;
                case 2:
                    if (myUOA.getNumOfEmployees() == 0) {//if else statement to ask for user to input ID first
                        JOptionPane.showMessageDialog(null, "Enter an employee ID");
                    } else {
                        String ID = JOptionPane.showInputDialog("Enter an employee ID:");
                        employee = myUOA.fetch(ID);
                        if (employee == null) {//if employee ID is null, that means the node cannot be found
                            JOptionPane.showMessageDialog(null, "Emplyee with " + ID + " cannot be found");
                        } else {
                            System.out.println(employee.toString());
                        }
                    }
                    break;
                case 3:
                    String key = JOptionPane.showInputDialog("Enter an employee ID");//'Key' is variable used to compare and verify encapsulation (ID)
                    FA2017LAB3_Employee_Tarell temp1 = myUOA.fetch(key);
                    String verifyAddress = JOptionPane.showInputDialog("Enter an employee address");//Ask for address to verify and set to 'temp1'
                    temp1.setAddress(verifyAddress);

                    FA2017LAB3_Employee_Tarell temp2 = myUOA.fetch(key);//Fetch temp2

                    if (temp1.getAddress().compareTo(temp2.getAddress()) == 0) {//if else to display if the compareTo is the same or not
                        JOptionPane.showMessageDialog(null, "Unsorted Optimized Array Structure is Encapsulated");
                    } else {
                        JOptionPane.showMessageDialog(null, "Unsorted Optimized Array Structure is Unencapsulated");
                    }
                    break;
                case 4://Case 4 asks for employee id the user wants to delete then calls delete method and displays message
                    String ID = JOptionPane.showInputDialog("Enter the employee ID you want to delete:");
                    if (myUOA.delete(ID) == false) {
                        JOptionPane.showMessageDialog(null, "Employee with " + ID + " cannot be found");
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee with " + ID + " is removed");
                    }
                    break;
                case 5://Update method which calls for delete then insert
                    if (myUOA.getNumOfEmployees() == 0) {
                        JOptionPane.showMessageDialog(null, "Enter an employee ID");//If nothing in array, can't update
                    } else {
                        String updateID = JOptionPane.showInputDialog("Enter the employee ID you want to update:");//asks for employee ID to update
                        employee = myUOA.fetch(updateID);
                        if (employee == null) {//if ID equals null, employee ID is not in array
                            JOptionPane.showMessageDialog(null, "Emplyee with " + updateID + " cannot be found");
                        } else {
                            String updateChoice = JOptionPane.showInputDialog("1. Update Address?\n2. Update Salary");//Asks user for Address or Salary to update
                            if (updateChoice.equals("1")) {
                                String address2 = JOptionPane.showInputDialog("Employee's new address");
                                employee.setAddress(address2);
                            } else {
                                String updateSalary = JOptionPane.showInputDialog("Employee's new salary");
                                double salary2 = Double.parseDouble(updateSalary);
                                employee.setSalary(salary2);
                            }
                            myUOA.update(updateID, employee);//calls update method and passes ID and employee info that user updated
                            employee = myUOA.fetch(updateID);
                            System.out.println(employee.toString());//displays updated employee information
                        }
                    }
                    break;
                case 6:
                    myUOA.showAll();//shows entire array of employees and their information
                    break;
                case 0:
                    System.exit(0);
                    break;
            }//end of switch
        } while (task != 0);
    }//end of main
}//end of class
