package assignment08;

import java.util.Arrays;

/**
 * This class sorts an array, using the merge sort algorithm.
 * Copied but modified from Horstmann
 */
public class TextbookMergeSorter implements Sorter
{

    @Override
    public double timedSort(double[] array) {
        long start = System.currentTimeMillis();
        mergeSort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * Sorts the array using merge sort.
     * @param array array to be sorted
     * @return the time taken to sort the array
     */
    public void mergeSort(double[] array) { 
        if (array.length > 1) {
            double[] first = new double[array.length / 2];
            double[] second = new double[array.length - first.length];
            System.arraycopy(array, 0, first, 0, first.length);
            System.arraycopy(array, first.length, second, 0, second.length);
            mergeSort(first);
            mergeSort(second);
            //merge back into array;
            int iFirst = 0;
            int iSecond = 0;
            int j = 0;
            while (iFirst < first.length && iSecond < second.length) { 
                if (first[iFirst] < second[iSecond]) { 
                    array[j] = first[iFirst];
                    iFirst++;
                } else { 
                    array[j] = second[iSecond];
                    iSecond++;
                }
                j++;
            }
            System.arraycopy(first, iFirst, array, j, first.length - iFirst);
            System.arraycopy(second, iSecond, array, j, second.length - iSecond);           
        }
    }
    public static void main(String[] args) {
        double[] a = {4,7,2,7,9,3,87,2,-2,6,-1,0,21,5,-30};
        new TextbookMergeSorter().timedSort(a);
        System.out.println(Arrays.toString(a));
    }
}