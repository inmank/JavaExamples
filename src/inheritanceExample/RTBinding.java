package inheritanceExample;

class A {
	public int i = 9;
	public void method1() {
		System.out.println("Class A");
	}
}

class B extends A {
	public int i = 99;
	
	public void method1() {
		System.out.println("Class B");
	}
}

class C extends B {
	public int i = 999;
	
	public void method1() {
		System.out.println("Class C");
	}
}
public class RTBinding {
	public static void main(String[] args) {
		A a = new C();
		B b = (B) a;
		
		System.out.println(a.i);
		System.out.println(b.i);
		a.method1();b.method1();
	}
}
