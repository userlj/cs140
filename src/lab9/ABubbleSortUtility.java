package lab9;

import java.util.ArrayList;
import java.util.Collections;

public class ABubbleSortUtility<E extends Comparable<E>> {

    public void aBubbleSort(ArrayList<E> list) {
        boolean changeOccurred = true;
        while (changeOccurred) {

// YOUR CODE HERE        
// set changeOccurred to false
        	changeOccurred = false;
// In a for loop with index i for the whole of list
// if the i-th element of list should go before the
// element at index (i-1) [for this you use 
// ],list.get(i-1).compareTo(list.get(i)) > 0
// then set changeOccurred to true and
// swap the two list elements, i.e. introduce a 
// new element E temp  and assign it to the i-th 
// element. Set the i-th element of list to be the 
// (i-1)st  [look up the operations of ArrayList]
// and set the (i-1)st element to temp
            for (int i = 1; i < list.size(); i++) {
            	if (list.get(i-1).compareTo(list.get(i)) > 0 ) {
            		changeOccurred = true;
            		E temp = list.get(i-1);
            		list.set(i-1, list.get(i));
            		list.set(i, temp);
            	}
            }
// THEN RUN the main method below to test the sorting works
// Once the sort appears to be working, un-comment the call
// to test.runTimingTest()
        
        }
    }
    public static void main(String[] args) {
        ABubbleSortUtility<String> test = 
            new ABubbleSortUtility<String>();
        RandomNameGenerator helper = new RandomNameGenerator();
        ArrayList<String> names = new ArrayList<String>();
        
        for (int i = 0; i < 50; i++) {
            String str = helper.getRandomName();
            names.add(str);
            System.out.println(str);
        }

        System.out.println("---------\nNOW SORT THEM\n");
        
        test.aBubbleSort(names);
        for(String str : names) 
            System.out.println(str);

        // ONLY RUN THE NEXT LINE AFTER YOUR CODE
        // IS SORTING CORRECTLY
        runTimingTest(test);
    }
    
    public static void runTimingTest(ABubbleSortUtility<String> test) {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> namesCopy = new ArrayList<String>();
        ArrayList<String> namesCopy2 = new ArrayList<String>();
        RandomNameGenerator helper = new RandomNameGenerator();
        
        for (int i = 0; i < 10000; i++) {
            String str = helper.getRandomName();
            names.add(str);
            namesCopy.add(str);
            namesCopy2.add(str);
        }

        System.out.println("\n------------\nTime Testing"); 
        long start = System.currentTimeMillis();
        test.aBubbleSort(names);
        long end = System.currentTimeMillis();
        System.out.println("Bubble Sort took " + (end-start) + " milliseconds");
        
        start = System.currentTimeMillis();
        Collections.sort(namesCopy);
        end = System.currentTimeMillis();
        System.out.println("Merge Sort took " + (end-start) + " milliseconds");
         // this is Tim sort if you are using Java 7.

// namesCopy2 is for later use.

    }
}