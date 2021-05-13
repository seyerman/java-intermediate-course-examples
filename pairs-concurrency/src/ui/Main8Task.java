package ui;

import model.PairsIntegers;
import thread.PairsIntegersThread;

public class Main8Task {

	public static void main(String[] args) throws InterruptedException {
		PairsIntegers pi = new PairsIntegers();
		
		PairsIntegersThread thread1 = new PairsIntegersThread(pi, 0, 125000000);
		PairsIntegersThread thread2 = new PairsIntegersThread(pi, 125000001,250000000);
		PairsIntegersThread thread3 = new PairsIntegersThread(pi, 250000001,375000000);
		PairsIntegersThread thread4 = new PairsIntegersThread(pi, 375000001,500000000);
		PairsIntegersThread thread5 = new PairsIntegersThread(pi, 500000001,625000000);
		PairsIntegersThread thread6 = new PairsIntegersThread(pi, 625000001,750000000);
		PairsIntegersThread thread7 = new PairsIntegersThread(pi, 750000001,875000000);
		PairsIntegersThread thread8 = new PairsIntegersThread(pi, 875000001,1000000000);
		
		long before = System.currentTimeMillis();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();
		thread6.join();
		thread7.join();
		thread8.join();
		
		System.out.println("Total Pairs: "+pi.getCount());
		
		long after = System.currentTimeMillis();
		System.out.println(after-before);
	}
}
