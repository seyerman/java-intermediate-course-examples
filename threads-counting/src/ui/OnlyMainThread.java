package ui;

import model.Counting;
import thread.CountingThread;

public class OnlyMainThread {

	public static void main(String[] args) throws InterruptedException {

		
		Counting counting = new Counting(0, 100);
				
		long init = System.currentTimeMillis();
		
		while(counting.getCurrentNumber()<counting.getEndNumber()) {
			counting.count();
			System.out.println(counting.getCurrentNumber());
			Thread.sleep(100);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration with only main thread: "+(end-init));
	}

}
