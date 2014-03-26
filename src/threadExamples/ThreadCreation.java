package threadExamples;


/**
 * Different types of Thread creation and execution.
 * @author karthik
 *
 */

//Method 1, by extending Thread class and overriding run method.
class MyThread1 extends Thread {
	MyThread1() {
		
	}
	public MyThread1(String nameIn) {
		super(nameIn);
	}
	
	public void run() {
		System.out.println(this.getName());
		System.out.println(Thread.currentThread().getName());
	}
}

//Method 2, by implementing runnable interface.
class MyThread2 implements Runnable {
	Thread ownThread;
	
	public MyThread2() {
	}

	public MyThread2(String nameIn) {
		ownThread = new Thread(this, nameIn);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

public class ThreadCreation {
	public static void main(String[] args) {
		//Execution type1, as direct thread object
		MyThread1 	t1 = new MyThread1();
		Thread 		t2 = new MyThread1();
		Thread 		t5 = new MyThread1("Thread5");
		
		// bad practice to create Thread like below.
		Thread 		t3 = new Thread(new MyThread1());
		Thread 		t4 = new Thread(new MyThread1(), "Thread4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		//Execution type2, pass the runnable object to thread constructor
		Thread 		t11 = new Thread(new MyThread2());
		Thread 		t22 = new Thread(new MyThread2(), "Thread22");
		MyThread2 	t33 = new MyThread2("Thread33");
		
		t11.start();
		t22.start();
		t33.ownThread.start();
	}
}
