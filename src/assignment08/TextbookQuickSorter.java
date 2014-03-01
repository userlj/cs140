package assignment08;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TextbookQuickSorter implements Sorter {

		private static int partition(double[] array, int from, int to) {
			double pivot = array[from];
			int i = from-1;
			int j = to+1;
			while(i < j) {
				i++;
				while(array[i] < pivot) i++;
				j--;
				while(array[j] > pivot) j--;
				if(i < j) {
					double temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			return j;
		}

	    private static boolean inOrder(double[] array, int from, int to) {
	    			boolean retVal = true;
	    			for (int i = from; i < to - from - 1 && retVal; i++) {
	    				if (array[i] > array[i+1]) {
	    					retVal = false;
	    				}
	    			}
	    			return retVal;
	    	    }
	    
		public static void sort(double[] array, int from, int to) {
			if(!inOrder(array, from, to) && from < to) {
				int p = partition(array, from, to);
				sort(array, from, p);
				sort(array, p+1, to);
			}
		}

		@Override
		public double timedSort(double[] array) {
			long start = System.currentTimeMillis();
			sort(array, 0, array.length-1);
			long end = System.currentTimeMillis();
			return end - start;
		}
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			Random r = new Random();
			final int LENGTH = 1000;
			double[] array = new double[LENGTH];

			for(int i = 0; i < LENGTH; i++)
				array[i] = r.nextInt(LENGTH);
			System.out.println(Arrays.toString(array));
			sort(array,0,LENGTH-1);
			System.out.println(Arrays.toString(array));
		}
}
