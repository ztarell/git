/* Zach Tarell - Assignment 4
 */
// import java.awt.Font; 
import java.util.Scanner;
// import javax.swing.*;
import util.IO; // File than New File then Next then IO then util then Finish

public class project4a {

    //  IO.showMessage(String.format("Sum:%7.2f", x+y)); ---- Works just like printf but instead of console it prints a string
    
    public static void main(String[] args) {
        
        
       Scanner scan = IO.getInput("Enter 2 Integers");
       int x = scan.nextInt();
       int y = scan.nextInt();
       
       if (x > 0 && y > 0)
           IO.showMessage(String.format("Sum: %d", (x+y)));  // Shows message without title and formatted font
       
       
       Scanner input = IO.getConsoleInput("Enter 2 real nums");
       float a = input.nextFloat();
       float b = input.nextFloat();
     
       if (a<0 || b<0)
            IO.showMessage(String.format("Product: %1.2f", a*b), "Results:");  // Shows message with a title and formatted font
       else if (a<0 && b<0)
            IO.showMessage(String.format("Quotient: %1.2f", a/b), "Results:");
       
        System.exit(0);         // Always have System.exit(0); at the end of public ststic void main(String[] args)
    }

}
