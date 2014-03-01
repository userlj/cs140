package assignment08;

public class NaiveQuickListSorter implements Sorter {

    private static double[] less(double[] array) {
// make an array temp the same length as array
    	double[] temp = new double[array.length];
        int index = 0;
// for all elements in array, if the element is smaller than array[0], 
// assign it to temp[index] and add 1 to index
        for (int i = 0; i < array.length; i++) {
        	if (array[i] < array[0]) {
        		array[i] = temp[index];
        		index++;
        	}
        }
// after the loop, make an array retVal of length index
// use System.arraycopy to copy the first index values of temp into retVal
        double[] retVal = new double[index];
        System.arraycopy(temp, 0, retVal, 0, index);
        return retVal;
    }

    private static double[] gtreq(double[] array) {
// make an array temp the same length as array
    	double[] temp = new double[array.length];
        int index = 0;
// for all elements in array starting at 1 (so, exclude array[0]), if the element is >= than array[0], 
// assign it to temp[index] and add 1 to index
        for (int i = 1; i < array.length; i++) {
        	if (array[i] >= array[0]) {
        		array[i] = temp[index];
        		index++;
        	}
        }
// after the loop, make an array retVal of length index
// use System.arraycopy to copy the first index values of temp into retVal
        double[] retVal = new double[index];
        System.arraycopy(temp, 0, retVal, 0, index);
        return retVal;
    }

    private static boolean inOrder(double[] array) {
//*********if the array is in increasing order, return true, otherwise false
		boolean retVal = true;
		for (int i = 0; i < array.length - 1 && retVal; i++) {
			if (array[i] > array[i+1]) {
				retVal = false;
			}
		}
		return retVal;
    }

    public static double[] sort(double[] array) {
        double[] retVal = null;
// if the array is not null then do all the following
// if the array is empty or in order, assing retVal to array
// else set retVal to a new array of the same length as array
// let temp1 equal sort(less(array)) and temp2 equal sort(gtreq(array))
// Use System.arraycopy to copy temp1 to the beginning of retVal
// retVal[temp1.length] = array[0];
// Use System.arraycopy to copy temp2 to the rest of retVal (starting at temp1.length + 1)
        if (array != null) {
        	if (array.length == 0 || inOrder(array)) {
        		retVal = array;
        	}
        	else {
        		retVal = new double[array.length];
            	double[] temp1 = sort(less(array));
            	double[] temp2 = sort(gtreq(array));
            	System.arraycopy(temp1, 0, retVal, 0, temp1.length);
            	retVal[temp1.length] = array[0];
            	System.arraycopy(temp2, 0, retVal, temp1.length + 1, temp2.length);
        	}
        }
        return retVal;
    }

    @Override
    public double timedSort(double[] array) {
        long start = System.currentTimeMillis();
        array = sort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }

}