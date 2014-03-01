package assignment08;

import java.util.Arrays;

public class QuickSorter implements Sorter{
	@Override
	public double timedSort(double[] array) {
		long start = System.currentTimeMillis();
		Arrays.sort(array);
		long end = System.currentTimeMillis();
		return end - start;
	}


}
