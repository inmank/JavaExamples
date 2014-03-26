package threadExamples;

import java.util.Calendar;

/**
 * A thread object can have access to the following thread methods join, sleep & yield
 * also the following object methods wait, notify. notifyAll 
 * @author karthik
 *
 */

class myThread11 implements Runnable {

	int threadNum = 0;
	
	public myThread11(int numberIn) {
		threadNum = numberIn;
	}
	
	public void run() {
		int counter = 0;
		while(counter++ < 5) {
			try {
				System.out.println("Running in " + Thread.currentThread().getName()+ " " + counter + " " + Calendar.getInstance().getTime());
				/*
				 * put the first thread with instance 1 of this runnable class 
				 * to sleep 1 second.
				 * instance 2 will sleep .5 seconds. 
				 */
				if (threadNum == 1)
					Thread.sleep(1000);
				else if (threadNum == 2)
					Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class myThread22 implements Runnable {

	public void run() {
		int counter = 0;
		while(counter++ < 5) {
			System.out.println("Running in " + Thread.currentThread().getName()+ " " + counter + " " + Calendar.getInstance().getTime());
		}
	}
}

public class ThreadMethods {

	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * join method - waits to execution of the thread to complete. 
		 * Then it moves to the next thread
		 * 
		 * sleep method - block the execution of the thread for specified time.
		 */
		Runnable r1 = new myThread11(1);
		Thread t1 = new Thread(r1, "Thread1");
		t1.setPriority(10);
		Thread t2 = new Thread(r1, "Thread2");
		t2.setPriority(5);
		Thread t3 = new Thread(r1, "Thread3");
		t3.setPriority(10);
		/*
		 * In the case below t1 & t2 starts execution in parallel.
		 * other threads t3 & t4 waits for the t2 to complete.
		 * Threads t3 & t4 will start the execution in parallel.
		 * Thread t5 will wait for thread t4 to complete. 
		 */
		t1.start();
		t2.start();
		t2.join();
		t3.start();
		
		Thread t4 = new Thread(new myThread11(2), "Thread4");
		t4.setPriority(1);
		Thread t5 = new Thread(new myThread22(), "Thread5");
		t4.start();
		t4.join();
		/* In the line below the the main method will be put to sleep for 5 seconds
		 * Hence the exection of t5 will delayed by 3 seconds after the 
		 * execution t4 is complete.
		 */
		Thread.sleep(3000);
		t5.start();
	}
}
