package ui;

import model.OddIntegers;
import thread.OddIntegerThread;

public class Main2Threads {

	public static void main(String[] args) throws InterruptedException {
		OddIntegers oi = new OddIntegers();

		OddIntegerThread thread1 = new OddIntegerThread(oi, 0, 500000000);
		OddIntegerThread thread2 = new OddIntegerThread(oi, 500000001, 1000000000);

		long before = System.currentTimeMillis();
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		long after = System.currentTimeMillis();
		
		System.out.println("Odds = "+oi.getCount());
		System.out.println(after-before);
	}

}
