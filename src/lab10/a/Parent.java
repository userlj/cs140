package lab10.a;

public class Parent {
		
	public void method1(){
		System.out.println("Parent: Method 1");
	}
	
	protected void method2(){
		System.out.println("Parent: Method 2");
	}
	
	void method3(){
		System.out.println("Parent: Method 3");
	}
	
	private void method4(){
		System.out.println("Parent: Method 4");
	}
	
	public static void method5(){
		System.out.println("Parent: Method 5");
	}
	
	public final void method6(){
		System.out.println("Parent: Method 6");
		System.out.print("Inside method6, calling method1()\n\t");
		method1();
		System.out.print("Inside method6, calling method2()\n\t");
		method2();
		System.out.print("Inside method6, calling method3()\n\t");
		method3();
		System.out.print("Inside method6, calling method4()\n\t");
		method4();
		System.out.print("Inside method6, calling method5()\n\t");
		method5();
	}
}