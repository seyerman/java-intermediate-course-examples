package ui;

import model.Counter;
import thread.CounterThread;

public class MainPlusFiveThreads {

	public static void main(String[] args) throws InterruptedException {

		
		Counter c1 = new Counter(0, 20);
		Counter c2 = new Counter(20, 40);
		Counter c3 = new Counter(40, 60);
		Counter c4 = new Counter(60, 80);
		Counter c5 = new Counter(80, 100);
		
		CounterThread ct1 = new CounterThread(c1, 100);		
		CounterThread ct2 = new CounterThread(c2, 100);
		CounterThread ct3 = new CounterThread(c3, 100);
		CounterThread ct4 = new CounterThread(c4, 100);
		CounterThread ct5 = new CounterThread(c5, 100);
		
		long init = System.currentTimeMillis();
		
		ct1.start();
		ct2.start();
		ct3.start();
		ct4.start();
		ct5.start();
		
		ct1.join();
		ct2.join();
		ct3.join();
		ct4.join();
		ct5.join();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration with 5 threads: "+(end-init));
	}

}
