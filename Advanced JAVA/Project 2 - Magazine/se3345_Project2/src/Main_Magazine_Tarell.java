/*
 * Main Class
 * By Zachary Tarell
 * Class: SE-3345
 * Section: 003
 * Semester: Spring 2019
 * 2/14/19
 *
 * This program keeps a SinglyLinkedList array hold Magazine ID, Name, and Publisher
 *
 */
import java.util.*;

public class Main_Magazine_Tarell {

    public static void main(String[] args) {
        //Magazine object set to null
        Magazine Mag = null;
        //SinglyLinkedList object class
        SinglyLinkedList<IDedObject> sLL = new SinglyLinkedList<>();

        //Scanner object
        Scanner input = new Scanner(System.in);
        int task, id;

        do {
            System.out.print("\n------- Magazine Operations ---------"
                    + "\n1. Make Empty"
                    + "\n2. Find ID"
                    + "\n3. Insert At Front"
                    + "\n4. Delete From Front"
                    + "\n5. Delete ID"
                    + "\n6. Print All Records"
                    + "\n7. Exit");
            //error check for positive integers and non-numbers
            do {
                System.out.print("\n  Your Choice: ");
                while (!input.hasNextInt()) {
                    String s = input.next();
                    System.out.printf("\"%s\" is not a valid number.\n  Enter a valid choice: ", s);
                }
                task = input.nextInt();
            } while (task < 0);
            //Switch to run user task input
            switch (task) {
                case 1: //makeEmpty empties the linked list
                    sLL.makeEmpty();
                    break;
                case 2://Print all details of magID if in list, if not then message
                    System.out.println("Enter ID: ");
                    id = input.nextInt();
                    if (sLL.findID(id) == null) {
                        System.out.println("\nMagazine with id " + id + " cannot be found.\n");
                    } else {
                        Mag.setID(id);
                        Mag.printID();
                    }
                    break;
                case 3://Get the mag details from user and add to front of list
                    Mag = readNewMag(input);
                    sLL.insertAtFront(Mag);
                    System.out.println("\nMagazine Added!");
                    break;
                case 4://Print the first item on the list and then delete it
                    Mag.printID();
                    System.out.println("First item deleted");
                    sLL.deleteFromFront();
                    break;
                case 5://Print particular IDed item then delete
                    System.out.println("Enter ID: ");
                    id = input.nextInt();
                    sLL.findID(id);
                    if (sLL.findID(id) != null) {
                        sLL.delete(id);
                        System.out.println("Item with id " + id + " deleted");
                    } else {
                        System.out.println("\nMagazine with id " + id + " cannot be found.\n");
                    }
                    break;
                case 6://Print all the records in the list
                    sLL.printAllRecords();
                    break;
                case 7://Exit. For every other option after task completion display menu again
                    break;
                default://Error check
                    System.out.print("Must be number between 1-7");
            }//end of switch

        } while (task != 7);//end of do/while
        System.exit(0);

    }//End of Main Class

    //When user selects insert this scanner message takes in new magazine
    static Magazine readNewMag(Scanner input) {
        Magazine Mag;
        System.out.println("Enter Magazine ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter Magazine Name: ");
        String n = input.nextLine();
        System.out.println("Enter Publisher Name: ");
        String p = input.nextLine();

        Mag = new Magazine(id, n, p);

        return Mag;
    }//End of readNewMag Class

}//End of Driver Class
