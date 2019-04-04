import java.util.*;
import javax.swing.*;

/**
 * Java ArrayList Demo
 * Driver Class (main)
 * By Zachary Tarell
 * 09/25/2017
 */
public class FA2017LAB3_JavaArrayListDemo_Tarell {
        
    public static void main(String[] args) {
        //Creates array data type and variable - defaults to 10
        ArrayList list = new ArrayList();
        FA2017LAB3_Employee_Tarell employee = null;
        
        //imports scanner object
        Scanner input = new Scanner(System.in);
        
        //inserts number 1 through 50 into array list
        for (int i = 1; i < 51; i++) {
            list.add(i);
        }
        //Asks user to insert 3 employees then adds to array list
        System.out.println("Enter 3 employees");
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter employee name:");
                    String name = input.nextLine();
                    input.nextLine();                       
                    System.out.println("Enter employee ID:");
                    input.nextLine();
                    System.out.println("Enter employee address:");
                    input.nextLine();
                    System.out.println("Enter employee salary:");
                    input.nextDouble();
                    
                    list.add(employee);
        }
        //inserts numbers 54 through 100 into array list
        for (int i = 54; i < 101; i++) {
            list.add(i);
        }
        //Displays size of array
        System.out.println("Size of Array List is " + list.size());
        
        //removes object at index 50 then displays size of array
        list.remove(50);
        System.out.println("Size of Array List is " + list.size());
        
        //Fetches and prints node at index 21 and 50 and displays them
        int temp = (Integer) list.get(21);
        System.out.println("Node at index 21 is " + temp);
        FA2017LAB3_Employee_Tarell temp1 = (FA2017LAB3_Employee_Tarell) list.get(50);  
        System.out.println("Node at index 50 is " + temp1);
       
        
        //verifies encapsulation
        String key = JOptionPane.showInputDialog("Change the address to a different one");
        temp1.setAddress(key);
        FA2017LAB3_Employee_Tarell temp2 = (FA2017LAB3_Employee_Tarell) list.get(50);
        
        //compareTo and Display whether array list is encapsulated or not
        if (temp1.getAddress().compareTo(temp2.getAddress()) == 0) {//if else to display if the compareTo is the same or not
                        JOptionPane.showMessageDialog(null, "Unsorted Optimized Array Structure is Encapsulated");
                    } else {
                        JOptionPane.showMessageDialog(null, "Unsorted Optimized Array Structure is Unencapsulated");
                    }
        
        
    }
    
}
