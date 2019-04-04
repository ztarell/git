
import java.util.*;

/*
    Zach Tarell
    LAB7 AccessStaticMemberDemo
    Driver Class Main()
    11/21/2017
 */
public class FA2017LAB7_AccessStaticMemberDemo {

    public static void main(String[] args) {
        FA2017LAB7_StaticFunctionWithRecursion_Tarell funREC = null;
        Scanner input = new Scanner(System.in);
        int task, result;
        do {
            System.out.println("\n--------------- MAIN MENU ----------------"
                    + "\n1. n!(Factorial of an integer n)"
                    + "\n2. a^n(a power n)"
                    + "\n3. Sum(n) = 1 + 2 + 3 +... + n"
                    + "\n4. Sum(m,n) = m + (m+1), (m+2) +... + n"
                    + "\n5. Fibonacci sequence Fn"
                    + "\n6. GCD (The greatest common divisor of m and n)"
                    + "\n0. Exit");
            task = input.nextInt();
            input.nextLine();
            switch (task) {
                case 1://Factorial of integer n where n provided from the keyboard
                    System.out.println("Enter a number to Calculate the facorial:");
                    int facNum = input.nextInt();
                    result = funREC.factorial(facNum);
                    System.out.println("The factorial of " + facNum + " is " + result);
                    break;
                case 2://a power n, where a and n are int numbers provided from the keyboard
                    System.out.println("Enter a base: ");
                    int base = input.nextInt();
                    System.out.println("Enter a power: ");
                    int power = input.nextInt();
                    result = funREC.power(base, power);
                    System.out.println("Base " + base + " power of " + power + " is: " + result);
                    break;
                case 3://Sum(n) = 1+2+3+ .. +n where n is an int provided from the keyboard
                    System.out.println("Enter number n :");
                    int num = input.nextInt();
                    result = funREC.Sum(num);
                    System.out.println("The sum of " + num + " terms is " + result);
                    break;
                case 4://Sum(m,n) = m + (m+1), (m+2) +... + n where m and n are int numbers provided from the keyboard
                    System.out.println("Enter two numbers n and m :");
                    int m = input.nextInt();
                    int n = input.nextInt();
                    result = funREC.Sum(m, n);
                    System.out.println("The sum of " + n + " terms is " + result);
                    break;
                case 5://Fibonacci sequence Fn = Fn-1 + Fn-2; F0 = 0 and Fn1 = 1
                    System.out.println("Enter number to find fibonacci :");
                    int fibonacci = input.nextInt();
                    result = funREC.Fibonacci(fibonacci);
                    System.out.println("The fibonacci of " + fibonacci + " terms is " + result);
                    break;
                case 6://Greatest Common Divisor of two integers m and n; m>n where m and n are provided from the keyboard
                    System.out.println("Enter two numbers m and n to find the GCD:");
                    m = input.nextInt();
                    n = input.nextInt();
                    result = funREC.GCD(m, n);
                    System.out.println("The GCD of " + m + " and " + n + " is " + result);
                    break;
                case 0://Exit Application
                    break;
            }//end of switch

        } while (task != 0);//end of do while
        System.exit(0);
    }//end of main

}//end of driver class
