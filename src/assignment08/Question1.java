package assignment08;
public class Question1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A[] array = {new A(), new K(), new L(), new M(), new X(), new Y()};
		for(A a : array) {
			a.call();
		}
		
		array[0].a();
		
		if(array[1] instanceof K) {
			   ((K)array[1]).k();
			}
		if(array[2] instanceof L) {
			   ((L)array[2]).l();
			}
		if(array[3] instanceof M) {
			   ((M)array[3]).m();
			}
		if(array[4] instanceof X) {
			   ((X)array[4]).x();
			}
		if(array[5] instanceof Y) {
			   ((Y)array[5]).y();
			}
//		((K)array[1]).k();
//		((L)array[2]).l();
//		((M)array[3]).m();
//		((X)array[4]).x();
//		((Y)array[5]).y();

		array = new A[]{new K(), new L(), new M(), new X(), new Y(), new A()};
		array[0].a();
		
		if(array[1] instanceof K) {
			   ((K)array[1]).k();
			}
		if(array[2] instanceof L) {
			   ((L)array[2]).l();
			}
		if(array[3] instanceof M) {
			   ((M)array[3]).m();
			}
		if(array[4] instanceof X) {
			   ((X)array[4]).x();
			}
		if(array[5] instanceof Y) {
			   ((Y)array[5]).y();
			}
//		((K)array[1]).k();
//		((L)array[2]).l();
//		((M)array[3]).m();
//		((X)array[4]).x();
//		((Y)array[5]).y();
	}
	
	//uses instanceof to count how many of the elements of arr instances of class L.
	public static int countL(A[ ] arr) {
		int numL = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] instanceof L) {
				numL++;
			}
		}
		return numL;
	}
	
	//that uses instanceof to count how many of the elements of arr instances of class X.
	public static int countX(A[ ] arr) {
		int numX = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] instanceof X) {
				numX++;
			}
		}
		return numX;
	}
	
	//that uses instanceof to count how many of the elements of arr instances of class K
	//this one is a bit tricky because whenever arr[i] is an instance of X will return true on the test instanceof K, 
	//so you must subtract the number of instances of X from the total number of instances of K.
	public static int countK(A[ ] arr) {
		int numK = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] instanceof K) {
				numK++;
			}
		}
		return numK - countX(arr);
	}
	
	//counts all the elements of arr such that arr[i].getClass( ) == cls. 
	//This method can be tested with a call such as count(K.class, array).
	public static <T extends A>  int count(Class<T> cls, A[ ] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getClass( ) == cls) {
				count++;
			}
		}
		return count;
	}
}
