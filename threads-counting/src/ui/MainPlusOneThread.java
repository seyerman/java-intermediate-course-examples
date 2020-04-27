package ui;

import model.Counter;
import thread.CounterThread;

public class MainPlusOneThread {

	public static void main(String[] args) throws InterruptedException {

		
		Counter c = new Counter(0, 100);
		
		CounterThread ct = new CounterThread(c, 100);		
		
		long init = System.currentTimeMillis();
		
		ct.start();
		
		ct.join();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration with 1 thread: "+(end-init));
	}

}
