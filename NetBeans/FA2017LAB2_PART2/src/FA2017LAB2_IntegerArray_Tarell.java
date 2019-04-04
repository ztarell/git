/**
 *Sorting Integer Array Application
 * Integer Array Class
 * By Zachary Tarell
 * 9/11/2017
 */
public class FA2017LAB2_IntegerArray_Tarell {
    //Create data types protected variables
    protected int type;
    protected int[] array;
    protected String originalArray;
    
    //Use constructor to initialize
    public FA2017LAB2_IntegerArray_Tarell(int type, String data) {
        this.type = type;
        originalArray = data;
        //Initialize array
        String[] stringArray = data.split(" ");
        array = new int[stringArray.length];
        //For loop to parse array into Integer
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        //Call sortType method to sort the list of numbers the user entered
        sortType();
    }
    //Switch statement for the SortName method, then return the string
    public String sortName() {
        String sortName = "INVALID SORT METHOD";
        switch (type) {
            case 1:
                sortName = "BUBBLE SORTING METHOD";
                break;
            case 2:
                sortName = "SELECTION SORTING METHOD";
                break;
            case 3:
                sortName = "INSERTION SORTING METHOD";
                break;
        }
        return sortName;

    }
    //Switch statement for SortType method, call the sort type and pass array
    public void sortType() {
        switch (type) {
            case 1:
                SortingMethods.bubbleSort(array);
                break;
            case 2:
                SortingMethods.selectionSort(array);
                break;
            case 3:
                SortingMethods.insertionSort(array);
                break;
        }
    }
    //Put array into a string for display
    public String putArray() {
        String newArray = "";
        for (int i = 0; i < array.length; i++) {
            newArray = newArray + array[i] + " ";
        }
        return newArray;
    }
    //toString to display in proper format
    public String toString() {

        String s = "--------------------------------------------------\n"
                + "Selected sorting method: " + sortName()
                + "\nOriginal list of numbers: " + originalArray
                + "\nSorted list of numbers: " + putArray()
                + "\n--------------------------------------------------\n";
        return s;
    }

}
