/**
 * Lab 4 - Part 1 
 * Queue Class
 * By Zachary Tarell
 * 09/28/2017
 */


public class Queue_Tarell {
    //data members
    private Book_Tarell[] data;
    private int size;
    private int numOfNodes;
    private int front;
    private int rear;
    //no-argument constructor
    public Queue_Tarell () {
        size = 100;
        numOfNodes = 0;
        front = 0;
        rear = 0;
        data = new Book_Tarell[100];
    }
    //parameter constructor
    public Queue_Tarell(int n) {
        size = n;
        numOfNodes = 0;
        front = 0;
        rear = 0;
        data = new Book_Tarell[n];
    }
    //insert for the queue
    public boolean enque(Book_Tarell newNode) {
        if (numOfNodes == size)
            return false; //overflow error
        else {
            numOfNodes += 1;
            data[rear] = newNode.deepCopy();
            rear = (rear + 1) % size;
            return true;
        }
    }
    //Fetch and Delete for the queue
    public Book_Tarell deque() {
        int frontLocation;
        if (numOfNodes == 0)
            return null; //underflow error
        else {
            frontLocation = front;
            front = (front + 1) % size;
            numOfNodes -= 1;
            return data[frontLocation];
        }
    }
    //Show All to String
    public void showAll() {
        int i = front;
        for (int c = 1; c <= numOfNodes; c++) {
            System.out.println(data[i].toString());
            i = (i + 1) % size;
        }
    }
    //display the book at the front of the queue
    public void getFront() {
        int i = front;
        System.out.println(data[i].toString());
    }
}
