
/**
 * Evaluate Expression
 * Driver Class (main)
 * By Zachary Tarell
 * 010/4/2017
 */
import java.util.*;//import java.util.StringTokenizer;
import java.io.*;//import java.io.FileNotFoundException;

public class FA2017LAB4_evaluateExpression_Tarell {

    //Process One Operation method
    public static void processOneOperation(GenericStack<Integer> operandStack, GenericStack<Character> operatorStack) {
        //Pop operator and operands
        char op = operatorStack.pop();
        int num2 = operandStack.pop();//num2 has to be popped first
        int num1 = operandStack.pop();
        //switch statement for calculations
        switch (op) {
            case '+':
                operandStack.push(num1 + num2);
                break;
            case '-':
                operandStack.push(num1 - num2);
                break;
            case '*':
                operandStack.push(num1 * num2);
                break;
            case '/':
                operandStack.push(num1 / num2);
                break;
        }

    }//end of one operation method

    //Process One Expression method
    public static void processOneExpression(String expression) {

        //Create Generic Stack arrays
        GenericStack<Integer> operandStack = new GenericStack<Integer>();
        GenericStack<Character> operatorStack = new GenericStack<Character>();

        //StringTokenizer splitting and parsing the String
        StringTokenizer tokens = new StringTokenizer(expression, "+-*/()", true);

        while (tokens.hasMoreTokens()) {//while there is more of the expression string to read
            String token = tokens.nextToken().trim();//trim to take away any white spaces

            if (token.matches("[0-9]+")) {//check to see if it's a number
                operandStack.push(Integer.parseInt(token));//parse the int and push it to the stack for operands
            } else {
                char op = token.charAt(0);//else it's an operator - and use 'charAt(0) to make it a character
                //evaluate if char is a plus or minus sign
                if (op == '+' || op == '-') {
                    if (operatorStack.peek() == null) {
                        operatorStack.push(op);
                    } else {
                        if (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/') {
                            do {
                                processOneOperation(operandStack, operatorStack);
                            } while (operatorStack.peek() != null);

                        }
                        operatorStack.push(op);

                    }
                }
                //evaluate if char is a multiplication or division sign
                if (op == '*' || op == '/') {
                    if (operatorStack.peek() == null) {
                        operatorStack.push(op);
                    } else {
                        if (operatorStack.peek() == '*' || operatorStack.peek() == '/') {
                            do {
                                processOneOperation(operandStack, operatorStack);
                            } while (operatorStack.peek() != null);

                        }
                        operatorStack.push(op);

                    }

                }
                //evaluate if char is a paranthesis - use a while loop until the paranthesis is closed
                if (op == '(') {
                    operatorStack.push(op);
                }
                if (op == ')') {
                    do {
                        processOneOperation(operandStack, operatorStack);
                    } while (operandStack.peek() == '(');
                    operatorStack.pop();
                }
            }

        }
        //Clearing the stack
        while (operatorStack.peek() != null) {
            processOneOperation(operandStack, operatorStack);
        }
        //Displaying the result with proper format
        System.out.println(expression + " = " + operandStack.pop() + "\n");

    }

    //main
    public static void main(String[] args) {

        //main menu
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Enter an expression\n2. Read expression from file\n0. Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //read expression ==> string
                    System.out.println("Enter an expression:");
                    input.nextLine();
                    String exp = input.nextLine();
                    //call expression method
                    processOneExpression(exp);
                    break;
                case 2:
                    // Location of file to read
                    File file = new File("data.txt");
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();//read one line                  
                            System.out.println(line);
                            //call expression method
                            processOneExpression(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                        System.exit(0);
                    }
                case 0:
                    break;
            }
        } while (choice != 0);//end main menu loop
        System.exit(0);//exits program        

    }//end of main

}//end of evaluate class
