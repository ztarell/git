/*
Red Black Tree Main Class by Zachary Tarell - 3/24/2019
This class reads an input/output file passed as arguments into the RBT.
It throws IllegalArgumentExceptions if input file not found to "error.txt". 
It outputs the RED items with an asterick next to the node.
 */

import java.io.*;
import java.util.*;

public class RBT_Main_Tarell {

    public static void main(String[] args) {
        
        if (args.length != 2) {
            //Output an error message in a new error document
            try {
                PrintWriter error = new PrintWriter("error.txt");

                error.println("Did not receive two arguments(input and output file names)");
                error.close();
                return;
            } catch (Exception e) {
                System.out.println("Did not receive two arguments (input and output file names)");
                return;
            }
        }
        //Set filenames to arguments
        String fileName = args[0];
        String outputFileName = args[1];
        try {//try catch for input and output file
            File inputFile = new File(fileName);
            Scanner input = new Scanner(inputFile);
            PrintWriter output = new PrintWriter(outputFileName);
            //Start here
//            System.out.println("Enter the input filename: ");
//            args[0] = input.nextLine();
//            System.out.println("Enter the output filename: ");
//            args[1] = input.nextLine();
            //End here
            String objType;
            if (input.hasNextLine()) {
                objType = input.nextLine();
            } else {
                output.println("Input file is empty");
                output.close();
                input.close();
                return;
            }
            //Check for String and Integer ONLY
            if (!(objType.equals("String") || objType.equals("Integer"))) {
                output.println("Only works for objects Integers and Strings");
                output.close();
                input.close();
                return;
            } else if (objType.equals("String")) {//If String 
                RedBlackTree<String> rbt = new RedBlackTree<>();
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] arg = line.split(":");
                    if (arg.length == 2) {
                        String element;
                        try {
                            element = arg[1];
                        } catch (Exception e) {
                            output.close();
                            input.close();
                            return;
                        }
                        if (arg[0].equals("Insert")) {
                            try {
                                if (rbt.insert(element)) {
                                    output.println("True");
                                } else {
                                    output.println("False");
                                }
                            } catch (Exception e) {
                                output.println("Error on insert: NullPointerException raised");
                            }
                        } else if (arg[0].equals("Contains")) {
                            try {
                                if (rbt.contains(element)) {
                                    output.println("True");
                                } else {
                                    output.println("False");
                                }
                            } catch (Exception e) {
                                output.println("Error on contains: NullPointerException raised");
                            }
                        } else {
                            output.println("Error in Line: " + arg[0]);
                        }
                    } else if (arg.length == 1) {
                        if (arg[0].equals("PrintTree")) {
                            output.println(rbt);
                        } else {
                            output.println("Error in Line: " + arg[0]);
                        }
                    }
                }
                input.close();
                output.close();
                } else {
                RedBlackTree<Integer> rbt = new RedBlackTree<>(); //If Integer
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] arg = line.split(":");
                    if (arg.length == 2) {
                        Integer element;
                        try {
                            element = Integer.parseInt(arg[1]);
                        } catch (Exception e) {
                            output.close();
                            input.close();
                            return;
                        }
                        if (arg[0].equals("Insert")) {
                            try {
                                if (rbt.insert(element)) {
                                    output.println("True");
                                } else {
                                    output.println("False");
                                }
                            } catch (Exception e) {
                                output.println("Error on insert: NullPointerException raised");
                            }
                        } else if (arg[0].equals("Contains")) {
                            try {
                                if (rbt.contains(element)) {
                                    output.println("True");
                                } else {
                                    output.println("False");
                                }
                            } catch (Exception e) {
                                output.println("Error on contains: NullPointerException raised");
                            }
                        } else {
                            output.println("Error in Line: " + arg[0]);
                        }
                    } else if (arg.length == 1) {
                        if (arg[0].equals("PrintTree")) {
                            output.println(rbt);
                        } else {
                            output.println("Error in Line: " + arg[0]);
                        }
                    }
                }
                input.close();
                output.close();
            }
        } catch (FileNotFoundException e) {
            try {
                PrintWriter error = new PrintWriter("error.txt");
                error.println("Could not find file!");
                error.close();
                return;
            } catch (Exception exc) {
                System.out.println("Could not find file!");
                e.printStackTrace();
                return;
            }
        }
    }//End of Main
}//End of Driver Class