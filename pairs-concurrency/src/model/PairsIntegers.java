package model;

public class PairsIntegers {
	private long count;
	
	public PairsIntegers() {
		count = 0;
	}
	
	public int howManyDigitsPairs(int number) {
		int pairs = 0;
		
		while(number>0) {
			int digit = number%10;
			if(digit%2==0) {
				pairs++;
			}
			number = number / 10;
		}
		
		return pairs;
	}
	
	public long howManyPairsInRange(int min, int max) {
		long pairs = 0;
		
		for(int i=min;i<=max;i++) {
			pairs += howManyDigitsPairs(i);
			if(i%10000000==0) {
				System.out.println("i="+i);
			}
		}
		
		return pairs;
	}
	
	public void increaseCount(long pairs) {
		count += pairs;
	}
	
	public long getCount() {
		return count;
	}
}
