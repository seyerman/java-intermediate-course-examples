package ui;

import model.OddIntegers;
import thread.OddIntegerThread;

public class Main4Threads {

	public static void main(String[] args) throws InterruptedException {
		OddIntegers oi = new OddIntegers();

		OddIntegerThread thread1 = new OddIntegerThread(oi, 0, 250000000);
		OddIntegerThread thread2 = new OddIntegerThread(oi, 250000001, 500000000);
		OddIntegerThread thread3 = new OddIntegerThread(oi, 500000001, 750000000);
		OddIntegerThread thread4 = new OddIntegerThread(oi, 750000001, 1000000000);

		long before = System.currentTimeMillis();
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		
		long after = System.currentTimeMillis();
		
		System.out.println("Odds = "+oi.getCount());
		System.out.println(after-before);
	}

}
