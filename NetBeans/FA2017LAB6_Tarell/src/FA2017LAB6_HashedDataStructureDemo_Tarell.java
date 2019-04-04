/*
 *  Hashtable Driver Class
    Main()
    By Zachary Tarell
    11/6/2017
 */
import java.util.*;//import for Scanner and Hashtable
import java.io.*;

public class FA2017LAB6_HashedDataStructureDemo_Tarell {//Driver Class

    public static void main(String[] args) {//Main()
        FA2017LAB6_Employee_Tarell Employee = null;//make Employee object

        Scanner input = new Scanner(System.in);//import scanner object to read from keyboard
        int choice, task;
        do {//do/while loop of main menu 
            System.out.println("--------------------------------\nMAIN MENU:"
                    + "\n1.  LQHashed Data Structure"
                    + "\n2.  Java Hashtable Data Structure"
                    + "\n0.  Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1://If user selects LQHashed Data Structure
                    FA2017LAB6_LQHashed_Tarell myLQH = new FA2017LAB6_LQHashed_Tarell(100);//Initializing Array
                    File file = new File("dataEmployee.txt");

                    try {
                        Scanner scanner = new Scanner(file); 
                        while (scanner.hasNext()) {
                            String line = scanner.nextLine().trim();//read one line
                            Employee = readOneLine(line);
                            myLQH.insert(Employee);//inserts employee into LQHashed
                        }

                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                        System.exit(0);
                    }

                    do {

                        task = subMenu(input);//call subMenu() method for the LQHashed array

                        switch (task) {
                            case 1://insert into LQHashed 
                                Employee = readEmployee(input);
                                myLQH.insert(Employee);
                                break;
                            case 2://fetch emloyee with id as target key
                                System.out.println("Enter employee's id to fetch:");
                                String keyID = input.nextLine();
                                myLQH.fetch(keyID);
                                if (myLQH.fetch(keyID) == null) {
                                    System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                                } else {
                                    System.out.println(myLQH.fetch(keyID));
                                }
                                break;
                            case 3://Encapsulation for LQ Hashed
                                System.out.println("Enter employee's id to fetch:");
                                keyID = input.nextLine();

                                FA2017LAB6_Employee_Tarell temp = myLQH.fetch(keyID);
                                if (temp == null) {
                                    System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                                } else {
                                    System.out.println("What do you want to change employee's salary too?");
                                    double salary2 = input.nextDouble();
                                    temp.setSalary(salary2);
                                    FA2017LAB6_Employee_Tarell temp2 = myLQH.fetch(keyID);
                                    if (temp.getSalary() != temp2.getSalary()) {
                                        System.out.println("\nEncapsulated!\n");
                                    } else {
                                        System.out.println("\nIt is NOT Encapsulated!\n");
                                    }
                                }
                                break;
                            case 4://Update salary for LQ Hashed
                                System.out.println("Enter employee's id to fetch:");
                                keyID = input.nextLine();
                                Employee = myLQH.fetch(keyID);
                                if (Employee == null) {
                                    System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                                } else {
                                    System.out.println("What do you want to change employee's salary to?");
                                    double newSalary = input.nextDouble();
                                    Employee.setSalary(newSalary);
                                    myLQH.update(keyID, Employee);
                                    System.out.println(Employee);
                                }
                                break;
                            case 5:// Delete for LQ Hashed
                                System.out.println("Enter employee's id to delete:");
                                keyID = input.nextLine();
                                Employee = myLQH.fetch(keyID);
                                if (Employee == null) {
                                    System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                                } else {
                                    if (myLQH.delete(keyID) == true) {
                                        System.out.println("\nSuccessful Delete\n");
                                    } else {
                                        System.out.println("\nDelete was unsuccessful\n");
                                    }
                                }
                                break;
                            case 6://Show All in LQ Hashed
                                myLQH.showAll();
                                break;
                            case 0://end submenu and write to file
                                try {
                                    String filename = "dataEmployee.txt";
                                    FileWriter fwriter = new FileWriter(filename); //add true will append the new data
                                    myLQH.showInFile(fwriter);//write the string to the file
                                    fwriter.close();
                                } catch (IOException ioe) {
                                    System.err.println(" IOException: " + ioe.getMessage());
                                }
                                break;
                        }
                    } while (task != 0);
                    break;

                case 2://If user selects JAVA Hashtable Data Structure
                    Hashtable<String, FA2017LAB6_Employee_Tarell> dataBase = new Hashtable<String, FA2017LAB6_Employee_Tarell>();//Initialize Hashtable

                    file = new File("dataEmployee.txt");

                    try {
                        Scanner scanner = new Scanner(file);

                        while (scanner.hasNext()) {
                            String line = scanner.nextLine().trim();//read one line
                            Employee = readOneLine(line);
                            dataBase.put(Employee.getKey(), Employee);//inserts employee into hashtable
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                        System.exit(0);
                    }
                    do {

                        task = subMenu(input);//call subMenu() method for Hashtable

                        switch (task) {
                            case 1://insert employee into Java Hashtable 
                                Employee = readEmployee(input);
                                dataBase.put(Employee.getKey(), Employee);
                                break;
                            case 2://fetch from Java Hashtable
                                System.out.println("Enter employee's id to fetch:");
                                String keyID = input.nextLine();
                                Employee = dataBase.get(keyID);
                                if (Employee == null) {
                                    System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                                } else {
                                    System.out.println(Employee);
                                }
                                break;
                            case 3://Encapsulation in Java Hashtable
                                System.out.println("Enter employee's id to fetch:");
                                keyID = input.nextLine();
                                FA2017LAB6_Employee_Tarell temp = dataBase.get(keyID);
                                if (temp == null) {
                                    System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                                } else {
                                    System.out.println("What do you want to change employee's salary to?");
                                    double salary2 = input.nextDouble();
                                    temp.setSalary(salary2);
                                    FA2017LAB6_Employee_Tarell temp2 = dataBase.get(keyID);
                                    if (temp.getSalary() != temp2.getSalary()) {
                                        System.out.println("\nEncapsulated!\n");
                                    } else {
                                        System.out.println("\nIt is NOT Encapsulated!\n");
                                    }
                                }
                                break;
                            case 4://Update in Java Hashtable                            
                                System.out.println("Enter employee's id to fetch:");
                                keyID = input.nextLine();
                                Employee = dataBase.get(keyID);
                                if (Employee == null) {
                                    System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                                } else {
                                    System.out.println("What do you want to change employee's salary to?");
                                    double newSalary = input.nextDouble();
                                    Employee.setSalary(newSalary);
                                    dataBase.put(keyID, Employee);
                                    System.out.println(Employee);
                                }
                                break;
                            case 5://Delete in Java Hashtable
                                System.out.println("Enter employee's id to delete:");
                                keyID = input.nextLine();
                                Employee = dataBase.get(keyID);
                                if (Employee == null) {
                                    System.out.println("\nEmployee with ID: " + keyID + " cannot be found.\n");
                                } else {
                                    if (dataBase.remove(keyID) != null) {
                                        System.out.println("\nSuccessful Delete\n");
                                    } else {
                                        System.out.println("\nDelete was unsuccessful\n");
                                    }
                                }
                                break;
                            case 6://Show All in Java Hashtable Data Structure
                                Enumeration keySet = dataBase.keys();
                                while (keySet.hasMoreElements()) {
                                    String k = (String) keySet.nextElement();
                                    Employee = dataBase.get(k);
                                    System.out.println(Employee.toString());
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
    //subMenu method for 2nd menu

    static int subMenu(Scanner input) {
        System.out.println("----Choose An Option----"
                + "\n1. Insert"
                + "\n2. Fetch"
                + "\n3. Encapsulation"
                + "\n4. Update"
                + "\n5. Delete"
                + "\n6. Show All"
                + "\n0. Exit to Menu");
        int task = input.nextInt();
        input.nextLine();
        return task;
    }//End of SubMenu

    //readEmployee method for inserting an Employee
    static FA2017LAB6_Employee_Tarell readEmployee(Scanner input) {
        FA2017LAB6_Employee_Tarell Employee = null;
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

            Employee = new FA2017LAB6_TitleEmployee_Tarell(firstname, lastname, id, department, salary, title);

        }//If user chooses 2 we will create a regular employee
        else if (userChoice == 2) {
            Employee = new FA2017LAB6_Employee_Tarell(firstname, lastname, id, department, salary);
        }
        return Employee;
    }//End of readEmployee

    //readOneLine method for reading one line of the .txt file
    static FA2017LAB6_Employee_Tarell readOneLine(String line) {
        FA2017LAB6_Employee_Tarell Employee = null;

        String s[] = line.split("-");

        String firstname = s[0].trim();
        String lastname = s[1].trim();
        String id = s[2].trim();
        String department = s[3].trim();
        double salary = Double.parseDouble(s[4].trim());

        if (s.length == 6) {//checks if employee has a title or not
            String title = s[5].trim();
            Employee = new FA2017LAB6_TitleEmployee_Tarell(firstname, lastname, id, department, salary, title);
        } else {
            Employee = new FA2017LAB6_Employee_Tarell(firstname, lastname, id, department, salary);
        }
        return Employee;
    }//End of readOneLine method

}//End of Demo Class

