package assignment04;

import java.util.Arrays;
public class RaggedArraySorter {
    public static int[][] sortedByRowLength(int[][] array) {
    	ComparableIntArrayWrapper[] temp = new ComparableIntArrayWrapper[array.length];
    	for(int i = 0; i < array.length; i++) {
    		temp[i] = new ComparableIntArrayWrapper(array[i]);
        	Arrays.sort(temp);	//??????????????????????????why??????????why????????????????????????
        	array[i] = temp[i].getContent();
    	}
    	return array;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,5,3},
                {2,3},
                {4,2,5,6,3},
                {0}};
        int[][] arr1 = sortedByRowLength(arr);
        for(int[] a : arr1) {
            System.out.println(Arrays.toString(a));
        }
    }
}