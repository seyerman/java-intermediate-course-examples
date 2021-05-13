package ui;

import model.PairsIntegers;
import thread.PairsIntegersThread;

public class Main4Task {

	public static void main(String[] args) throws InterruptedException {
		PairsIntegers pi = new PairsIntegers();
		
		PairsIntegersThread thread1 = new PairsIntegersThread(pi, 0, 250000000);
		PairsIntegersThread thread2 = new PairsIntegersThread(pi, 250000001,500000000);
		PairsIntegersThread thread3 = new PairsIntegersThread(pi, 500000001, 750000000);
		PairsIntegersThread thread4 = new PairsIntegersThread(pi, 750000001,1000000000);
		
		long before = System.currentTimeMillis();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		
		System.out.println("Total Pairs: "+pi.getCount());
		
		long after = System.currentTimeMillis();
		System.out.println(after-before);
	}
}
