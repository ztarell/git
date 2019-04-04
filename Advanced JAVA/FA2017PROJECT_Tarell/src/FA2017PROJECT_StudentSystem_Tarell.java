
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
 * FA2017 PROJECT
   Zachary Tarell
   11/26/2017
 */
public class FA2017PROJECT_StudentSystem_Tarell {

    public static void main(String[] args) {

        FA2017PROJECT_Student_Tarell Student;
        //FA2017PROJECT_AClass_Tarell oneClass = null;

        FA2017PROJECT_SinglyLinkedList_Tarell sLL = new FA2017PROJECT_SinglyLinkedList_Tarell();
        String line, id;

        ArrayList classList;//new ArrayList();

        File file = new File("studentInformation.csv");
        File gFile = new File("studentGrade.csv");
        try {
            Scanner scanner = new Scanner(file);
            Scanner classRead = new Scanner(gFile);

            while (scanner.hasNext() && classRead.hasNext()) {
                line = scanner.nextLine();//read one line

                String s[] = line.split(",");

                id = s[0];
                String lastname = s[1];
                String firstname = s[2];
                String ssn = s[3];
                String dob = s[4];
                String phone = s[5];
                String address = s[6];
                Student = new FA2017PROJECT_Student_Tarell(id, lastname, firstname, ssn, dob, phone, address);

                line = classRead.nextLine();

                String c[] = line.split(",");
                classList = new ArrayList();
                id = c[0];
                for (int i = 1; i < c.length; i = i + 2) {
                    String className = c[i];
                    String grade = c[i + 1];
                    if (grade.equalsIgnoreCase("X")) {
                        grade = "Not Complete";
                    }
                    FA2017PROJECT_AClass_Tarell oneClass = new FA2017PROJECT_AClass_Tarell(className, grade);
                    classList.add(oneClass);
                }

                Student.setClassList(classList);
                sLL.insert(Student);

            }// end of while
            scanner.close();
            classRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        Scanner input = new Scanner(System.in);
        int task;
        do {
            System.out.print("\n--------------- SCHOOL ABC ----------------"
                    + "\n1. Add a New Student from the Keyboard"
                    + "\n2. Remove a Student"
                    + "\n3. Find a Student by ID"
                    + "\n4. Add a class for a Student"
                    + "\n5. Drop a class for a Student"
                    + "\n6. Print the list of Student Names in one class"
                    + "\n7. Print out the Transcript of a Student"
                    + "\n8. Show All Students in the data structure"
                    + "\n0. Exit"
                    + "\n  Your Choice: ");
            task = input.nextInt();
            input.nextLine();

            switch (task) {
                case 1: //readEmployee method for inserting an Employee
                    Student = readEmployee(input);
                    sLL.insert(Student);
                    break;
                case 2://Remove a Student
                    System.out.println("Enter student's id to remove:");
                    String keyID = input.nextLine();
                    Student = sLL.fetch(keyID);
                    if (Student == null) {
                        System.out.println("\nStudent with id " + keyID + " cannot be found.\n");
                    } else {
                        if (sLL.delete(keyID) != false) {
                            System.out.println("\nStudent with id " + keyID + " is removed\n");
                        } else {
                            System.out.println("\nDelete was unsuccessful\n");
                        }
                    }
                    break;
                case 3://Find a Student by ID
                    System.out.println("Enter student's id you want to locate:");
                    keyID = input.nextLine();
                    Student = sLL.fetch(keyID);
                    if (Student == null) {
                        System.out.println("\nStudent with id " + keyID + " cannot be found.\n");
                    } else {
                        System.out.println(Student.toString());
                    }
                    break;
                case 4://Add a class for a Student
                    System.out.println("Enter student's id you want to add a class for:");
                    keyID = input.nextLine();
                    Student = sLL.fetch(keyID);
                    if (Student == null) {
                        System.out.println("\nStudent with id " + keyID + "cannot be found.\n");
                    } else {
                        System.out.println("Enter the class you want to add:");
                        String className = input.nextLine();
                        FA2017PROJECT_AClass_Tarell oneClass = new FA2017PROJECT_AClass_Tarell(className, "X");
                        classList = Student.getClassList();
                        classList.add(oneClass);
                        Student.setClassList(classList);
                        System.out.println(Student.toString());
                        sLL.update(keyID, Student);
                    }
                    break;
                case 5://Drop a class for a Student
                    System.out.println("Enter student's id you want to drop a class for:");
                    keyID = input.nextLine();
                    Student = sLL.fetch(keyID);
                    if (Student == null) {
                        System.out.println("\nStudent with id " + keyID + " cannot be found.\n");
                    } else {
                        System.out.println("Enter the class you want to drop:");
                        String className = input.nextLine();
                        Student.dropClass(className);
                        sLL.update(keyID, Student);
                        System.out.println(Student.toString());
                    }
                    break;
                case 6://Print the list of Student Names in one class
                    System.out.println("Enter the class name to show all students:");
                    String className = input.nextLine();
                    System.out.println("\nLIST OF STUDENTS IN CLASS " + className);
                    sLL.printOneClass(className);
                    break;
                case 7://Print out the Transcript of a Student
                    System.out.println("Enter student's id to print out their transcript:");
                    keyID = input.nextLine();
                    Student = sLL.fetch(keyID);
                    if (Student == null) {
                        System.out.println("\nStudent with id: " + keyID + " cannot be found.\n");
                    } else {
                        System.out.println(Student.printTranscript());
                    }
                    break;
                case 8://Show All Students in the data structure
                    sLL.showAll();
                    break;
                case 0://Exit and Write to file
                    try {
                        String filename = "studentInformation.csv";
                        String gradefile = "studentGrade.csv";
                        FileWriter fwriter = new FileWriter(filename); //add true will append the new data
                        FileWriter gfile = new FileWriter(gradefile);
                        sLL.writeToFile(fwriter, gfile);//write the string to the file
                        fwriter.close();
                        gfile.close();
                    } catch (IOException ioe) {
                        System.err.println(" IOException: " + ioe.getMessage());
                    }
                    break;
            }//end of switch

        } while (task != 0);//end of do/while
        System.exit(0);
    }//end of main class

    static FA2017PROJECT_Student_Tarell readEmployee(Scanner input) {
        FA2017PROJECT_Student_Tarell Student;
        System.out.println("Enter student's first name: ");
        //keyboard.nextLine();
        String firstname = input.nextLine();

        System.out.println("Enter student's last name: ");
        //keyboard.nextLine();
        String lastname = input.nextLine();

        System.out.println("Enter student's ID: ");
        String id = input.nextLine();

        System.out.println("Enter student's SSN: ");
        String ssn = input.nextLine();

        System.out.println("Enter student's DOB: ");
        String dob = input.nextLine();

        System.out.println("Enter student's PHONE: ");
        String phone = input.nextLine();

        System.out.println("Enter student's ADDRESS: ");
        String address = input.nextLine();

        Student = new FA2017PROJECT_Student_Tarell(id, lastname, firstname, ssn, dob, phone, address);

        return Student;
    }//End of readEmployee

}//end of driver class
