package ui;

import model.PairsIntegers;
import thread.PairsIntegersThread;

public class Main2Task {

	public static void main(String[] args) throws InterruptedException {
		PairsIntegers pi = new PairsIntegers();
		
		PairsIntegersThread thread1 = new PairsIntegersThread(pi, 0, 500000000);
		PairsIntegersThread thread2 = new PairsIntegersThread(pi, 500000001,1000000000);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		System.out.println("Total Pairs: "+pi.getCount());
	}
}
