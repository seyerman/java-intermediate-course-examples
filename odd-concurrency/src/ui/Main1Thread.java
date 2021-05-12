package ui;

import model.OddIntegers;

public class Main1Thread {

	public static void main(String[] args) {
		OddIntegers oi = new OddIntegers();

		long before = System.currentTimeMillis();
		
		System.out.println(oi.howManyOddsInRange(0, 1000000000));
		
		long after = System.currentTimeMillis();
		
		System.out.println(after-before);
	}

}
