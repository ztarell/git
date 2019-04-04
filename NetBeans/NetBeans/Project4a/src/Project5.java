
import util.IO;
// import java.util.Scanner;          All of these are only needed defined through the util package with the IO class which you are importing into Project5
// import javax.swing.JOptionPane;
// import java.awt.Font;
// import javax.swing.JTextArea;

public class Project5 {

    // Beginning of Project5 with a numIn function that returns an Integer
    public static int numIn() {
        int width;
        do {
            width = IO.getInput("Enter an ODD, POSITIVE number LESS than 20").nextInt(); // The IO part is optional if in the same public class
        } while (width % 2 == 0 || width < 0 || width > 20);
        return width;
    }
    //String s = "Enter an ODD, POSITIVE number LESS than 20";           This is another way to get a numIn from GUI
    //x = Integer.parseInt(JOptionPane.showInputDialog(s));       

    public static String drawBox(int width) {
        String result = "";
        for (int line = 1; line <= width; line++) {
            for (int column = 1; column <= width; column++) {
                if (line == 1 || column == 1 || line == width || column == width) {
                    result += " * ";
                } else {
                    result += "   ";
                }
            }
            result += "\n";
        }
        return result;
    }

    public static String drawDiamond(int width) {
        String result = "";
        int stars = 1;
        int spaces = width/2;
        while (stars < width) {
            for (int i = 0; i < spaces; i++) {
                result += " ";
            }
            for (int j = 0; j < stars; j++) {
                result += "*";
            }
            stars += 2;
            spaces--;
            result += "\n";
        }
        while (stars > 0) {
            for (int i = 0; i < spaces; i++) {
                result += " ";
            }
            for (int j = 0; j < stars; j++) {
                result += "*";
            }
            stars -= 2;
            spaces++;
            result += "\n";
        }
        return result;
    }

    public static String drawLine(int height) {
        // int height;       I do not have to define the int parameter inside the method because I'm returning a string
        String result = "";
        for (int i = 0; i < height; i++) {
            result += "*\n";
        }
        return result;
    }

    public static void main(String[] args) {

        int width = numIn();             // 'symbol' is my new name for the Integer that numIn() returned.... it was originally 'x'

        switch (width) {
            case 3:
            case 9:
            case 17:
                IO.showMessage(drawBox(width), "Box");        // I used 'width' as the parameter from drawBox() but returned a string
                break;
            case 5:
            case 11:
            case 15:
                IO.showMessage(drawDiamond(width), "Diamond");         // I used 'width' as the parameter from drawDiamond() but returned a string
                break;
            default:
                IO.showMessage(drawLine(width), "Line");       // I used 'height' as the parameter from drawLine() but returned a string
        }
        System.exit(0);      // Always have System.exit(0); at end of public static void main(String[] args)
    }
}
