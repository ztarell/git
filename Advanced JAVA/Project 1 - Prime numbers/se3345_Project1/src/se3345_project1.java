/* Name of the Student: Zachary Tarell
 * Class: SE 3345
 * Section: 003
 * Semester: Spring 2019
 */

/**
 * Project 1
 * Write a java program to compute all prime numbers less than or equal to a given integer 'n' using the algorithm “Sieve of Eratosthenes”.
 *
 * The Sieve of Eratosthenes is a method used to compute all primes less than or equal to 'n'. We begin by making a table of integers 2 to 'n'.
 * We find the smallest integer, i that is not crossed out, print i, and cross out 2i, 3i, … ..( actually better to start at i2 and use increments i2 + i, i2 + 2i, i2 + 3i,… etc until 'n').
 * When index is less than sqrt(n) the program terminates.
 * 
 * Prompt the user to give an positive integer value 'n' and print all primes up till 'n' using the above algorithm on screen.
 */
import java.util.*;//For the Scanner

public class se3345_project1 {

    public static void main(String[] args) {
        //Create scanner object to ask and take in an integer
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int n = input.nextInt();
        //Prints out explanation of algorithm
        System.out.println("Here's a list of all the prime numbers smaller than or equal to " + n);
        //Creates sieveOfEratosthenes object class
        se3345_project1 z = new se3345_project1();
        z.sieveOfEratosthenes(n);
    }//End of main class

    public void sieveOfEratosthenes(int n) {
        //Create a boolean array and initialize everything as true 
        //Starting with 2 and going to 'n' 
        //A value in prime[i] will be false if 'i' is NOT prime 
        boolean prime[] = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }
        //Check if 'p' is less than sqaure root of 'n'
        for (int p = 2; p * p <= n; p++) {
            //If prime[p] is not changed, then it is a prime 
            if (prime[p] == true) {
                //Update all multiples of p 
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        //Print all prime numbers 'i' in a list 
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                System.out.println(i);
            }
        }

    }//End of sieveOfEratosthenes class
}//End of driver class
