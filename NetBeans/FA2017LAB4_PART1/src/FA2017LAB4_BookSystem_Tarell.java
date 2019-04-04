/**
 * Lab 4 - Part 1 Driver Class (main)
 * Book System Class
 * By Zachary Tarell
 * 09/28/2017
 */
import java.util.*;
import javax.swing.*;

public class FA2017LAB4_BookSystem_Tarell {

    public static void main(String[] args) {
        Book_Tarell book = null;//Initialize a book object set to null

        //create a scanner object to display and read all user data
        Scanner input = new Scanner(System.in);
        int topMenu, s_choice, q_choice;
        //top menu
        do {
            //display top menu first
            System.out.println("\n1. Stack"
                    + "\n2. Queue"
                    + "\n0. Exit");
            topMenu = input.nextInt();
            //if (topMenu == 1) {
            switch (topMenu) {
                case 1:
                    Stack_Tarell stack = new Stack_Tarell();//create the stack object to call the stack class
                    do {//do while second menu
                        System.out.println("\n1. Add a book"
                                + "\n2. Remove a book"
                                + "\n3. Display the book at top of Stack"
                                + "\n4. Show all books in the structure"
                                + "\n0. Exit");
                        s_choice = input.nextInt();
                        switch (s_choice) {
                            case 1://ask user for inputs and read the inputs
                                System.out.println("Enter the book id");
                                input.nextLine();
                                String bookID = input.nextLine();
                                System.out.println("Enter the ISBN");
                                String ISBN = input.nextLine();
                                System.out.println("Enter the title");
                                String title = input.nextLine();
                                System.out.println("Enter the writer");
                                String writer = input.nextLine();
                                System.out.println("Enter the publisher");
                                String publisher = input.nextLine();
                                System.out.println("Are you checking book out?\n1. Yes\n2. No");
                                int takeHome = input.nextInt();
                                if (takeHome == 2) {
                                    book = new Book_Tarell(bookID, ISBN, title, writer, publisher);//create object to call Book class
                                } else if (takeHome == 1) {
                                    System.out.println("Enter the check out date");
                                    input.nextLine();
                                    String checkoutDate = input.nextLine();
                                    System.out.println("Enter the due date");
                                    String dueDate = input.nextLine();
                                    book = new BorrowedBook_Tarell(bookID, ISBN, title, writer, publisher, checkoutDate, dueDate);//create object to call Borrowed Book class
                                }
                                stack.push(book);//push the book to the stack
                                System.out.println(book.toString());//display the book
                                break;
                            case 2:
                                book = stack.pop();//case 2 is pop the book from the stack
                                if (book == null) {
                                    JOptionPane.showMessageDialog(null, "The stack is empty");
                                } else {
                                    System.out.println(book.toString());//display popped book if stack isn't empty
                                }
                                break;
                            case 3:
                                if (book == null) {
                                    JOptionPane.showMessageDialog(null, "The stack is empty");
                                } else {
                                    System.out.println(stack.peek());//display the book at the top of stack without deleting it                                
                                }
                                break;
                            case 4:
                                stack.showAll();//display all from stack 
                                break;
                            case 0:
                                break;
                        }//end of stack switch

                    } while (s_choice != 0);//end of stack menu
                    break;
                case 2:
                    Queue_Tarell queue = new Queue_Tarell();//create the queue object to call the queue class
                    do {//do while second menu
                        System.out.println("\n1. Add a book"
                                + "\n2. Remove a book"
                                + "\n3. Display the book at front of Queue"
                                + "\n4. Show all books in the structure"
                                + "\n0. Exit");
                        q_choice = input.nextInt();
                        switch (q_choice) {
                            case 1://ask user for inputs and read the inputs
                                System.out.println("Enter the book id");
                                input.nextLine();
                                String bookID = input.nextLine();
                                System.out.println("Enter the ISBN");
                                String ISBN = input.nextLine();
                                System.out.println("Enter the title");
                                String title = input.nextLine();
                                System.out.println("Enter the writer");
                                String writer = input.nextLine();
                                System.out.println("Enter the publisher");
                                String publisher = input.nextLine();
                                System.out.println("Are you checking book out?\n1. Yes\n2. No");
                                int takeHome = input.nextInt();
                                if (takeHome == 2) {
                                    book = new Book_Tarell(bookID, ISBN, title, writer, publisher);//create object to call Book class
                                } else if (takeHome == 1) {
                                    System.out.println("Enter the check out date");
                                    input.nextLine();
                                    String checkoutDate = input.nextLine();
                                    System.out.println("Enter the due date");
                                    String dueDate = input.nextLine();
                                    book = new BorrowedBook_Tarell(bookID, ISBN, title, writer, publisher, checkoutDate, dueDate);//create object to call Borrowed Book class
                                }
                                queue.enque(book);//enque the book to the queue
                                System.out.println(book.toString());//display the book
                                break;
                            case 2:
                                book = queue.deque();//case 2 is deque the book from the queue
                                if (book == null) {
                                    JOptionPane.showMessageDialog(null, "The queue is empty");
                                } else {
                                    System.out.println(book.toString());//display dequed book if queue isn't empty
                                }
                                break;
                            case 3:
                                if (book == null) {
                                    JOptionPane.showMessageDialog(null, "The queue is empty");
                                } else {
                                    queue.getFront();//display the book at the front of queue without deleting it
                                }
                                break;
                            case 4:
                                queue.showAll();//display all from queue
                                break;
                            case 0:
                                break;
                        }//end of queue switch
                    } while (q_choice != 0);//end of queue menu
                break;
            }
        } while (topMenu != 0); //end of switch for top menu
        System.exit(0);//ends program
    }//end of main
}//end of class
