package model;

public class Counter {
	private long startNumber;
	private long endNumber;
	
	private long currentNumber;
	
	public Counter(long sn, long en) {
		startNumber = sn;
		endNumber = en;
		
		currentNumber = startNumber;
	}
	
	public void count(){
		currentNumber++;
	}

	public long getStartNumber() {
		return startNumber;
	}

	public long getEndNumber() {
		return endNumber;
	}

	public long getCurrentNumber() {
		return currentNumber;
	}
}
