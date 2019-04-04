/*
Lazy Deletion Binary Search Tree Main Class by Zachary Tarell - 3/3/2019
This class reads an input file and uses error checking to insert into BST.
It throws IllegalArgumentExceptions if 'input.txt' is not exactly matching. 
It outputs the deleted items with an asterick next to the node.
It also outputs the tree nodes with PreOrder (NLR) Traversal.
 */
import java.util.*;
import java.io.*;

//Driver Class
public class LazyBST_Main {

    //Main class
    public static void main(String[] args) {
        //Creates Integer object using generics
        LazyBinarySearchTree<Integer> t = new LazyBinarySearchTree<>();   
        
        String line, num;
        int number = 0;
        File file = new File("input.txt");//takes in input from "input.txt" file
        File outFile = new File("output.txt");//writes output to "output.txt" file
        PrintWriter pwriter = null;//output file object created
        try {
            Scanner sc = new Scanner(file);//scanner object to read input
            pwriter = new PrintWriter(outFile);//pwriter to write to output file

            while (sc.hasNext()) {//While loop for reading input
                line = sc.nextLine();
                //Check for Insert into LBSTree
                if (line.length() > 7 && line.substring(0, 7).equals("Insert:")) {
                    num = line.substring(7);
                    try {
                        if (checkNum(num)) {//uses a checkNum method to check for integer at end of string
                            number = Integer.valueOf(num);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        if (t.insert(number)) {
                            pwriter.println("True");//write the string to the file
                        } else {
                            pwriter.println("False");
                        }
                    } catch (IllegalArgumentException e) {//throws exception if something wrong
                        pwriter.println("Error in insert: IllegalArgumentException raised");
                    }
                    //Check for Delete from LBSTree
                } else if (line.length() > 7 && line.substring(0, 7).equals("Delete:")) {
                    num = line.substring(7);
                    try {
                        if (checkNum(num)) {
                            number = Integer.valueOf(num);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        if (t.delete(number)) {
                            pwriter.println("True");//write the string to the file
                        } else {
                            pwriter.println("False");
                        }
                    } catch (IllegalArgumentException e) {//throws exception if something wrong
                        pwriter.println("Error in delete: IllegalArgumentException raised");
                    }
                    //Check for findMin from LBSTree
                } else if (line.length() >= 7 && line.substring(0, 7).equals("FindMin")) {
                    pwriter.println(t.findMin());
                    //Check for findMax from LBSTree
                } else if (line.length() >= 7 && line.substring(0, 7).equals("FindMax")) {
                    pwriter.println(t.findMax());
                    //Check for Contains from LBSTree
                } else if (line.length() > 9 && line.substring(0, 9).equals("Contains:")) {
                    num = line.substring(9);
                    try {
                        if (checkNum(num)) {
                            number = Integer.valueOf(num);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        if (t.contains(number)) {
                            pwriter.println("True");
                        } else {
                            pwriter.println("False");
                        }
                    } catch (IllegalArgumentException e) {
                        pwriter.println("Error in contains: IllegalArgumentException raised");
                    }
                    //Check for PrintTree from LBSTree
                } else if (line.length() >= 9 && line.substring(0, 9).equals("PrintTree")) {
                    pwriter.println(t.toString());
                    //Check for Height from LBSTree
                } else if (line.length() >= 6 && line.substring(0, 6).equals("Height")) {
                    pwriter.println(t.height());
                    //Check for Size from LBSTree
                } else if (line.length() >= 4 && line.substring(0, 4).equals("Size")) {
                    pwriter.println(t.size());
                    //If string not in the input file, calls for err in line
                } else {
                    pwriter.println("Error in Line: " + line);
                }
            }//End of while
            sc.close();//Close the scanner input file

        } catch (FileNotFoundException e) {//Catches if no input file found
            System.out.println("File not found");
            System.exit(0);
        }
        pwriter.close();//Close output file
    }//End of main function

    //uses a checkNum method to check for proper integer at end of string
    public static boolean checkNum(String n) {
        if (n.length() > 2) {
            return false;
        }
        for (int i = 0; i < n.length(); i++) {
            if (!Character.isDigit(n.charAt(i))) {// Tests if character at position 'i' is not a digit
                return false;
            }
        }
        return true;
    }//End of checkNum function

}//End of Driver Class
