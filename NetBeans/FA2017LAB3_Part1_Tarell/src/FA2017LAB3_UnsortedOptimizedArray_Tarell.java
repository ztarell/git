
/**
 *Unsorted Optimized Array
 * By Zachary Tarell
 * 9/14/2017
 */
public class FA2017LAB3_UnsortedOptimizedArray_Tarell {
    //data types for array
    private int next;
    private int size;
    private FA2017LAB3_Employee_Tarell[] array;
    //Constructor for array
    public FA2017LAB3_UnsortedOptimizedArray_Tarell() {
        next = 0;
        size = 10;
        array = new FA2017LAB3_Employee_Tarell[size];
    }
    public int getNumOfEmployees () {
        return next;
    }
    //Insert method into array - returns a boolean
    public boolean insert(FA2017LAB3_Employee_Tarell newNode) {
        if (next >= size) {
            return false;
        }
        array[next] = newNode.deepCopy();
        if (array[next] == null) {
            return false;
        }
        next++;
        return true;

    }
    //Fetch method for array - returns a node
    public FA2017LAB3_Employee_Tarell fetch(String targetKey) {
        FA2017LAB3_Employee_Tarell node;
        FA2017LAB3_Employee_Tarell temp;
        int i = 0;
        while (i < next && (array[i].compareTo(targetKey) != 0)) {
            i++;
        }
        if (i == next)
            return null;
        node = array[i].deepCopy();
        if (i != 0) {
            temp = array[i - 1];
            array[i - 1] = array[i];
            array[i] = temp;
        }
        return node;
    }
    //Delete method for array - returns a boolean
    public boolean delete(String targetKey) {
        int i = 0;
        while (i < next && (array[i].compareTo(targetKey) != 0)) {
            i++;
        }
        if (i == next)
            return false;
        array[i] = array[next - 1];
        array[next - 1] = null;
        next--;
        return true;
    }
    //Update method into array - calls delete then insert - returns a boolean
    public boolean update(String targetKey, FA2017LAB3_Employee_Tarell newNode) {
        if (delete(targetKey) == false)
            return false;
        else if (insert(newNode) == false)
            return false;
        else 
            return true;
    }
    //showAll method for array - displays all inputs from array
    public void showAll() {
        for(int i = 0; i < next; i++)
            System.out.println(array[i].toString());
    }

}
