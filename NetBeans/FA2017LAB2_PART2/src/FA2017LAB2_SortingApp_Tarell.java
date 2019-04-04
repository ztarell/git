/**
 *Sorting Integer Array Application
 * Driver Class (Main)
 * By Zachary Tarell
 * 9/11/2017
 */
import java.util.*;

public class FA2017LAB2_SortingApp_Tarell {

    public static void main(String[] args) {
        String strArray;
        int sortMethod;
        
        //Display Sorting Types and Exit option
        do {
            String str = "SORTING TOOL - BY ZACHARY TARELL\n"
                    + "1. BUBBLE SORT\n"
                    + "2. SELECTION SORT\n"
                    + "3. INSERTION SORT\n"
                    + "0. EXIT\n";

            Scanner input = new Scanner(System.in);
            System.out.print(str);
            //Ask user which sort option they want
            System.out.println("Enter a number to select a Sorting method");
            sortMethod = input.nextInt();
            //If statement for exiting program
            if (sortMethod == 0) {
                System.out.println("Program is terminating...");
                System.exit(0);
            }
            input.nextLine();
            //Ask user for list of numbers they want sorted
            System.out.println("Enter a list of numbers you want to sort");
            strArray = input.nextLine();
            
            //Create data class object to pass sortMethod and strArray
            FA2017LAB2_IntegerArray_Tarell sorter = new FA2017LAB2_IntegerArray_Tarell(sortMethod, strArray);
            
            //Call toString to display in proper format
            System.out.println(sorter.toString());
        } while (sortMethod != 0);
    }

}
