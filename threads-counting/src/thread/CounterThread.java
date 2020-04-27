package thread;

import model.Counter;

public class CounterThread extends Thread{
	private Counter counter;
	private long sleepMillis;
	public CounterThread(Counter co, long sm) {
		counter = co;
		sleepMillis = sm;
	}
	
	@Override
	public void run() {
		try {
			while(counter.getCurrentNumber()<counter.getEndNumber()) {
				counter.count();
				System.out.println(counter.getCurrentNumber());
				Thread.sleep(sleepMillis);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
