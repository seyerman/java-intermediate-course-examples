package ui;

import model.Counter;

public class OnlyMainThread {

	public static void main(String[] args) throws InterruptedException {

		
		Counter counter = new Counter(0, 100);
				
		long init = System.currentTimeMillis();
		
		while(counter.getCurrentNumber()<counter.getEndNumber()) {
			counter.count();
			System.out.println(counter.getCurrentNumber());
			Thread.sleep(100);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration with only main thread: "+(end-init));
	}

}
