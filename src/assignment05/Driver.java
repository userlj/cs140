package assignment05;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

	public static double executeList(Operator[ ] array, double input) {
		if((array != null) && (array.length != 0)) {
			for(int i = 0; i < array.length; i++) {
				input = array[i].modify(input);
			}
			return input;
		}
		else return input;
	}
    public static void main(String[] args) {
        ArrayList<Operator> list = new ArrayList<Operator>();
        list.add(new Plus(4));
        list.add(new Plus(2));
        list.add(new Minus(3));
        list.add(new Divide(4));
        list.add(new Times(4));
        list.add(new Divide(4));
        
        Operator[] array = {};
        
        array = list.toArray(array);
        System.out.println(executeList(array,7));
        Collections.shuffle(list);
        array = list.toArray(array);
        System.out.println(executeList(array,7));
        Collections.shuffle(list);
        array = list.toArray(array);
        System.out.println(executeList(array,7));
        Collections.shuffle(list);
        array = list.toArray(array);
        System.out.println(executeList(array,7));   
    }

}
