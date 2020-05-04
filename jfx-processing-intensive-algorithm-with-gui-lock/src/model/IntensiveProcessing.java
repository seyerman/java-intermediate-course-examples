package model;

import java.math.BigInteger;

public class IntensiveProcessing {
	private long number;
	public IntensiveProcessing(long num) {
		number = num;
	}
	public BigInteger heavyAlgorithm() {
		BigInteger sum = BigInteger.ZERO;
		for (long i = 0; i < number; i++) {
			sum = sum.add(new BigInteger(i+""));
		}
		return sum;
	}
}
