package lab10.b;

import lab10.a.Parent;

public class ChildB extends Parent {
	@Override
	public void method1(){
		System.out.println("Child: Method 1");
	}
	
	@Override
	public void method2(){
		System.out.println("Child: Method 2");
	}
	
//	@Override
	void method3(){
		System.out.println("Child: Method 3");
	}
	
//	@Override
	public void method4(){
		System.out.println("Child: Method 4");
	}
	
//	@Override
	public static void method5(){
		System.out.println("Child: Method 5");
	}
	
//	@Override
//	public  void method6(){
//		System.out.println("Child: Method 6");
//	}
	
//	@Override
	public void method1(int a){
		System.out.println("Child: Method 1 with "+a);
	}
}