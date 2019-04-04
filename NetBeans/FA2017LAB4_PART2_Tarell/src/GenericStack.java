
/**
 * Generic Stack Class
 * By Zachary Tarell
 * 10/4/2017
 *
 * DO NOT NEED A GenericNode() AND DeepCopy() FOR THIS LAB
 */

public class GenericStack<T> {

    private T[] data;
    private int top;
    private int size;
    
    public GenericStack() {
        top = -1;
        size = 100;
        data = (T[]) new Object[100];
    }

    public GenericStack(int n) {
        top = -1;
        size = n;
        data = (T[]) new Object[n];
    }

    public boolean push(T newNode) {
        //GenericNode node = (GenericNode) newNode;
        if (top == size - 1) {
            return false;   //overflow error
        } else {
            top += 1;
            data[top] = newNode;
            return true;
        }
    }

    public T pop() {
        int topLocation;
        if (top == -1) {
            return null;
        } else {
            topLocation = top;
            top -= 1;
            return data[topLocation];
        }
    }

    public T peek() {
        int topLocation;
        if (top == -1) {
            return null;
        } else {
            topLocation = top;
            return data[topLocation];
        }
    }

    public void showAll() {
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }
}
