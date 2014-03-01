package lab10.a;
import lab10.b.ChildB;
/**
 * QUESTION 1: method4(), method5() and method1(int a) are able to compile after commenting out their @Override annotation
 * QUESTION 2: private, static and final methods can we not override
 * QUESTION 3: method6() cannot appear at all in the subclass
 * QUESTION 4: final methods cannot be inherited
 * QUESTION 5: method4() in Parent Class is private
 * QUESTION 6: overload
 * QUESTION 7: method6()
 * QUESTION 8: none does
 * QUESTION 9: private and static methods do NOT dispatch
 * QUESTION 10: method3()
 * QUESTION 11: false
 * QUESTION 12: The method ChildB.method3() does not override the inherited method from Parent since it is private to a different package
 * QUESTION 13: method3()
 * QUESTION 14: method4()
 * QUESTION 15: part5
 * QUESTION 16: Casting temporarily (for that statement) changes the static type of an object.
 * QUESTION 17: The compiler uses the static type to determine what methods can be called on an object.
 * QUESTION 18: visible
 * QUESTION 19: The dynamic type controls which instance methods is executed during run time (while the programming is running).
 * QUESTION 20: The static type controls which static method is executed during run time.
 * 
 * @author lmeng4
 */


public class DriverA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Parent();
		System.out.println("Parent static type, Parent dynamic type");
		p.method1();
		p.method2();
		p.method3();
//		p.method4();
		Parent.method5();
		p.method6();
		ChildA c = new ChildA();
		System.out.println("Parent static type, Parent dynamic type");
		c.method1();
		c.method2();
		c.method3();
		c.method4();
		ChildA.method5();
		c.method6();
		ChildB cb = new ChildB();
		System.out.println("ChildB static type, ChildB dynamic type");
		cb.method1();
		cb.method2();
//		cb.method3();
		cb.method4();
		ChildB.method5();
		cb.method6();
		Parent p2 = new ChildA(); 
		System.out.println("Parent static type, ChildA dynamic type"); 
		p2.method1();
		p2.method2();
		p2.method3();
//		p2.method4();
		Parent.method5();
		p2.method6();
		Parent p3 = new ChildB();
		System.out.println("Parent static type, ChildB dynamic type"); 
		p3.method1();
		p3.method2();
		p3.method3();
//		p3.method4();
		Parent.method5();
		p3.method6();
		Parent p4 = new ChildA();
		System.out.println("Parent static type, ChildA dynamic type"); 
		((ChildA)p4).method1();
		((ChildA)p4).method2();
		((ChildA)p4).method3();
		((ChildA)p4).method4();
		ChildA.method5();
		((ChildA)p4).method6();
	}

}
