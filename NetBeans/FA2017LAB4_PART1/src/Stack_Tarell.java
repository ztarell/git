/**
 * Lab 4 - Part 1 
 * Stack Class
 * By Zachary Tarell
 * 09/28/2017
 */


public class Stack_Tarell {
    //Data memebers
    private Book_Tarell[] data;
    private int top;
    private int size;
    //constructor - initialize
    public Stack_Tarell() {
        top = -1;
        size = 100;
        data = new Book_Tarell[100];
    }
    //Constructor passes size
    public Stack_Tarell(int n) {
        top = -1;
        size = n;
        data = new Book_Tarell[n];
    }
    //Insert for the stack
    public boolean push(Book_Tarell newNode) {
        if (top == size-1)
            return false;  //overflow error
        else {
            top += 1;
            data[top] = newNode.deepCopy();
            return true; 
        }
    }
    //Fetch/Delete for the stack
    public Book_Tarell pop() {
        int topLocation;
        if (top == -1)
            return null; //underflow error
        else {
            topLocation = top;
            top -= 1;
            return data[topLocation];
        }
    }
    //Show All of the stack to String
    public void showAll() {
        for (int i = top; i >= 0; i--)
            System.out.println(data[i].toString());
    }
    //display the book at the top of the stack
    public Book_Tarell peek() {
        return data[top].deepCopy();
    }
}
