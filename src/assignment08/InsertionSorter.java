package assignment08;

public class InsertionSorter implements Sorter {

    /**
     * Method that sorts the parameter array into increasing order
     * using the insertion sort algorithm and returns the time
     * taken in milliseconds.
     * This is a favored algorithm for short arrays since
     * it has linear complexity for arrays that are already sorted.
     * @param array array to be sorted
     * @return the time taken to sort the array
     */
    @Override
    public double timedSort(double[] array) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            double next = array[i];
            // Move all larger elements to the right
            int j = i;
            while (j > 0 && array[j - 1] > next) {
                array[j] = array[j - 1];
                j--;
            }
            // Insert the element in its correct position
            array[j] = next;
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

}