package ui;

import model.PairsIntegers;

public class MainMonoTask {

	public static void main(String[] args) {
		PairsIntegers pi = new PairsIntegers();
		
		long before = System.currentTimeMillis();
		
		System.out.println(pi.howManyPairsInRange(0, 1000000000));
		
		long after = System.currentTimeMillis();
		System.out.println(after-before);
	}
}
