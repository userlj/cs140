package assignment08;

import java.util.Arrays;

/**
 * This class sorts an array, using the merge sort algorithm.
 * Copied but modified from Horstmann
 */
public class MergeSorter implements Sorter
{

    @Override
    public double timedSort(double[] array) {
    	Double[] array1 = new Double[array.length];
    	for(int i = 0; i < array.length; i++) {
    		array1[i] = array[i];
    	}
        long start = System.currentTimeMillis();
        Arrays.sort(array1);
        long end = System.currentTimeMillis();
        return end - start;
    }

}