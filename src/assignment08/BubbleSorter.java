package assignment08;

public class BubbleSorter implements Sorter {

	public double timedSort(double[] array) {
        long start = System.currentTimeMillis();
		boolean changeOccured = true;
		while (changeOccured) {
			changeOccured = false;
			for (int i = 1; i < array.length; i++) {
				if (array[i-1] > array[i]) {
					double temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
					changeOccured = true;
				}
			}
		}
        long end = System.currentTimeMillis();
        return end - start;
	}
	
}