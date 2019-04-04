/*
    Zach Tarell
    LAB7 StaticFunctionWithRecursion
    Data Type Class
    11/21/2017
 */

public class FA2017LAB7_StaticFunctionWithRecursion_Tarell {

    private int n;
    private int result;

    public static int factorial(int facNum) {
        if (facNum == 0) {
            return 1;
        } else {
            return (facNum * factorial(facNum - 1));
        }

    }

    public static int power(int base, int powerValue) {
        if (powerValue == 0) {
            return 1;
        } else {
            return base * power(base, powerValue - 1);
        }

    }

    public static int Sum(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + Sum(n - 1);
        }
    }

    public static int Sum(int m, int n) {
        int sum = 0;
        if (n == 0) {
            return 0;
        } else {
            return sum + Sum(n - 1);
        }
    }

    public static int Fibonacci(int n) {
        //if(n==1 || n==2)
        if (n == 1) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    public static int GCD(int m, int n) {
        if (n == 0) {
            return m;
        } else if (n > m) {
            return GCD(n, m);
        } else {
            return GCD(n, m % n);
        }
    }
}//end of class
