package thread;

import model.OddIntegers;

public class OddIntegerThread extends Thread{
	private OddIntegers oi;
	private int min;
	private int max;
	
	public OddIntegerThread(OddIntegers oddint, int minim, int maxim) {
		oi = oddint;
		min = minim;
		max = maxim;
	}

	@Override
	public void run() {
		long odds = oi.howManyOddsInRange(min, max);
		oi.increaseCount(odds);
	}
}
