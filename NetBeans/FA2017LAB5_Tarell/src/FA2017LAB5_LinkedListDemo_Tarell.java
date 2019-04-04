/*
 * Lab 5 Driver Class
    Linked List Demo Application
    By Zachary Tarell
    10/24/2017
 */
import java.util.*;
import javax.swing.*;//import for JOptionPane

public class FA2017LAB5_LinkedListDemo_Tarell {

    public static void main(String[] args) {

        Employee_Tarell Employee = null;//make Employee object

        Scanner input = new Scanner(System.in);//import scanner object to read from keyboard
        int choice, task;
        do {//do/while loop of main menu 
            System.out.println("--------------------------------\nMAIN MENU:"
                    + "\n1.  Singly Linked List"
                    + "\n2.  Singly Linked List with Iterator"
                    + "\n3.  Java Linked List with Iterator"
                    + "\n0.  Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1://If user selects Singly Linked List
                    SinglyLinkedList_Tarell sLL = new SinglyLinkedList_Tarell();
                    do {

                        task = subMenu(input);//call subMenu() method for the Singly Linked List array

                        switch (task) {
                            case 1://insert into singly linked list
                                Employee = readEmployee(input);//call readEmployee() method to read input of employee information from keyboard
                                sLL.insert(Employee);
                                System.out.println("\nSINGLY LINKED LIST EMPLOYEE(S):");//Display with toString method
                                sLL.showAll();
                                break;
                            case 2://fetch emloyee with id as target key
                                System.out.println("Enter employee ID to fetch:");
                                String targetKey = input.nextLine();
                                Employee = sLL.fetch(targetKey);
                                if (sLL.getEmployees() == null) {
                                    JOptionPane.showMessageDialog(null, "There is no node in the Singly Linked List");
                                } else {
                                    if (Employee == null) {
                                        JOptionPane.showMessageDialog(null, "ID " + targetKey + " cannot be found");
                                    } else {
                                        System.out.println(Employee.toString());
                                    }
                                }
                                break;
                            case 3://update singly linked list with choice of address or salary
                                System.out.println("Enter employee ID to update:");
                                targetKey = input.nextLine();
                                Employee = sLL.fetch(targetKey);
                                if (sLL.getEmployees() == null) {
                                    JOptionPane.showMessageDialog(null, "There is no node in the Singly Linked List");
                                } else {
                                    if (Employee == null) {
                                        JOptionPane.showMessageDialog(null, "ID " + targetKey + " cannot be found");
                                    } else {
                                        System.out.println("What part of employee id number " + targetKey + " do you want to update?"
                                                + "\n1. Address"
                                                + "\n2. Salary");
                                        int updateNode = input.nextInt();
                                        if (updateNode == 1) {
                                            System.out.println("Enter the new address:");
                                            input.nextLine();
                                            String newAddress = input.nextLine();
                                            Employee.setAddress(newAddress);
                                        }
                                        if (updateNode == 2) {
                                            System.out.println("Enter the new salary:");
                                            double newSalary = input.nextDouble();
                                            Employee.setSalary(newSalary);
                                        }
                                        sLL.update(targetKey, Employee);
                                        Employee = sLL.fetch(targetKey);
                                        System.out.println("\nUPDATED EMPLOYEE: " + Employee.toString());
                                    }
                                }
                                break;
                            case 4://delete employee from singly linked list using the id as target key
                                System.out.println("Enter employee ID to delete:");
                                targetKey = input.nextLine();
                                Employee = sLL.fetch(targetKey);
                                if (sLL.getEmployees() == null) {
                                    JOptionPane.showMessageDialog(null, "There is no node in the Singly Linked List");
                                } else {
                                    if (Employee == null) {
                                        JOptionPane.showMessageDialog(null, "ID " + targetKey + " cannot be found");
                                    } else {
                                        sLL.delete(targetKey);
                                    }
                                    System.out.println("Employee with id " + targetKey + " has been deleted");
                                }
                                break;
                            case 5://show all in singly linked list
                                if (sLL.getEmployees() != null) {
                                    sLL.showAll();
                                } else {
                                    JOptionPane.showMessageDialog(null, "There is no node in the Singly Linked List");
                                }
                                break;
                            case 0://exit sub menu
                                break;
                        }

                    } while (task != 0);
                    break;
                case 2://If user selects Singly Linked List with Iterator

                    SinglyLinkedListIterator_Tarell sLLwI = new SinglyLinkedListIterator_Tarell();
                    do {

                        task = subMenu(input);//call subMenu() method for Singly Linked List with Iterator array

                        switch (task) {
                            case 1://insert employee into Singly Linked List with Iterator 
                                Employee = readEmployee(input);//call readEmployee() method to read input of employee info from keyboard
                                sLLwI.insert(Employee);
                                System.out.println("\nSINGLY LINKED LIST WITH ITERATOR EMPLOYEE(S):");//Display with toString method
                                sLLwI.showAll();
                                break;
                            case 2://fetch the first 2 nodes of Singly Linked List with Iterator
                                sLLwI.i.reset();
                                System.out.println(sLLwI.i.next());
                                System.out.println(sLLwI.i.next());
                                break;
                            case 3://Update and add an 'A' to all employees before id number
                                sLLwI.i.reset();
                                while (sLLwI.i.hasNext()) {
                                    Employee = sLLwI.i.next();
                                    String id = Employee.getID();
                                    id = "A" + id;
                                    Employee.setID(id);
                                    sLLwI.i.set(Employee);
                                }
                                //output the updated Employee ID's
                                System.out.println("UPDATED EMPLOYEE ID'S:");
                                sLLwI.i.reset();
                                while (sLLwI.i.hasNext()) {
                                    System.out.println(sLLwI.i.next());
                                }
                                break;
                            case 4://delete third Node of Singly Linked List with Iterator                            
                                sLLwI.i.reset();
                                for (int i = 0; i <= 2; i++) {
                                    Employee = sLLwI.i.next();
                                }
                                String id = Employee.getID();
                                sLLwI.delete(id);
                                System.out.println("SINGLY LINKED LIST WITH ITERATOR - THIRD NODE DELETED:");
                                sLLwI.showAll();
                                break;
                            case 5://show all of Singly Linked List with Iterator array
                                sLLwI.showAll();
                                break;
                            case 0://exit
                                break;
                        }
                    } while (task != 0);
                    break;

                case 3://If user selects Java Linked List with Iterator
                    LinkedList dataBase = new LinkedList();
                    ListIterator i = dataBase.listIterator();
                    do {

                        task = subMenu(input);//call subMenu() method for Java Linked List with Iterator array

                        switch (task) {
                            case 1://insert employee into Java Linked List with Iterator then display entire array
                                Employee = readEmployee(input);//call readEmployee() method to read input of employee information from keyboard
                                i.add(Employee);
                                Employee_Tarell e;
                                System.out.println("\nJAVA LINKED LIST EMPLOYEE(S):");//Display with toString method
                                while (i.hasPrevious()) {
                                    i.previous();
                                }
                                while (i.hasNext()) {
                                    e = (Employee_Tarell) i.next();
                                    System.out.println(e);
                                }
                                break;
                            case 2://Fetch and display the first 2 employee nodes from Java Linked List with Iterator array
                                while (i.hasPrevious()) {
                                    i.previous();
                                }
                                System.out.println(i.next());
                                System.out.println(i.next());
                                break;
                            case 3://update Java Linked List with Iterator array to show a new address "Philadelphia Eagles" at 3rd node
                                while (i.hasPrevious()) {
                                    i.previous();
                                }
                                for (int j = 0; j < 2; j++) {
                                    i.next();
                                }
                                Employee = (Employee_Tarell) i.next();
                                String address = Employee.getAddress();
                                address = "Philadelphia Eagles!!";
                                Employee.setAddress(address);
                                i.set(Employee);

                                System.out.println("\nJAVA LINKED LIST ADDRESS CHANGE:");//Display with toString method
                                while (i.hasPrevious()) {
                                    i.previous();
                                }
                                while (i.hasNext()) {
                                    e = (Employee_Tarell) i.next();
                                    System.out.println(e);
                                }
                                break;
                            case 4://Reset Iterator to front then move Iterator one location and remove node at current location                             
                                while (i.hasPrevious()) {
                                    i.previous();
                                }
                                i.next();
                                i.remove();
                                while (i.hasNext()) {
                                    System.out.println(i.next());
                                }
                                break;
                            case 5://show all employee nodes of Java Linked List with Iterator 
                                while (i.hasPrevious()) {
                                    i.previous();
                                }
                                while (i.hasNext()) {
                                    System.out.println(i.next());
                                }
                                break;

                            case 0://exit
                                break;
                        }
                    } while (task != 0);
                    break;
                case 0://If user selects exit from main menu
                    break;
            }

        } while (choice != 0);//end of the main menu
        System.exit(0);
    }//end of main method 
    //Create a readEmployee() method that passes Scanner input as parameter and returns an Employee Node from Employee_Tarell Class 
    //This is so you only have to type the information for the employee one time in the driver class
    public static Employee_Tarell readEmployee(Scanner input) {

        Employee_Tarell Employee = null;
        int task_title;

        System.out.println("Enter employee name:");
        String name = input.nextLine();
        System.out.println("Enter employee ID:");
        String id = input.nextLine();
        System.out.println("Enter employee address:");
        String address = input.nextLine();
        System.out.println("Enter employee salary:");
        double salary = input.nextDouble();
        System.out.println("Does the employee have a title?\n1. Yes\n2. No");
        task_title = input.nextInt();
        if (task_title == 1) {//whichever user chooses to have a title or not
            System.out.println("Enter the employee title:");
            input.nextLine();
            String eTitle = input.nextLine();
            Employee = new TitleEmployee_Tarell(name, id, address, salary, eTitle);//employee object set to inherit TitleEmployee class  
        } else if (task_title == 2) {
            Employee = new Employee_Tarell(name, id, address, salary);//employee object set to inherit Employee w/out a title class
        }

        return Employee;
    }
    //Create a subMenu() method that passes Scanner input as parameter and and returns an integer 
    //This is so you only have to type the second menu one time in the driver class
    public static int subMenu(Scanner input) {

        System.out.println("\nLIST MENU:"
                + "\n1. INSERT"
                + "\n2. FETCH"
                + "\n3. UPDATE"
                + "\n4. DELETE"
                + "\n5. SHOW ALL"
                + "\n0. EXIT");
        int task = input.nextInt();
        input.nextLine();
        return task;

    }
}//end of driver class
