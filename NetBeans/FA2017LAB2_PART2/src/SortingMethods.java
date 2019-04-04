/**
 *Sorting Integer Array Application
 * Sorting Methods Class
 * By Zachary Tarell
 * 9/11/2017
 */
public class SortingMethods {
//BUBBLE SORTING

    public static void bubbleSort(int[] array) {

        int n = array.length;
        for (int pass = 1; pass < n; pass++) {  // count how many times
            // This next loop becomes shorter and shorter
            for (int i = 0; i < n - pass; i++) {
                if (array[i] > (array[i + 1])) {
                    // exchange elements
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    } //where array is an array with size = n

    //INSERTION SORTING
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int temp = array[i];
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }//where array is an array with size = n
    }

    //SELECTION SORTING
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    //... Exchange elements
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    } //where array is an array with size = n

}
