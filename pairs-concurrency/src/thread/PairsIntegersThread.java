package thread;

import model.PairsIntegers;

public class PairsIntegersThread extends Thread{
	private PairsIntegers pi;
	private int min;
	private int max;
	
	public PairsIntegersThread(PairsIntegers pairsInt, int minim, int maxim) {
		pi = pairsInt;
		min = minim;
		max = maxim;
	}
	
	public void run() {
		long pairs = pi.howManyPairsInRange(min, max);
		pi.increaseCount(pairs);
	}
}
