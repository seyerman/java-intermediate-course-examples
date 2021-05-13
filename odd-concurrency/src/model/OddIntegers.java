package model;

public class OddIntegers {
	private long count;
	
	public OddIntegers() {
		count = 0;
	}
	
	public synchronized void increaseCount(long c) {
		count += c;
	}
	
	public long getCount() {
		return count;
	}
	
	public int howManyOddDigits(int number) {
		int odds = 0;
		
		while(number>0) {
			int digit = number % 10;
			if(digit%2!=0) {
				odds++;
			}
			number = number / 10;
		}		
		
		return odds;
	}
	
	public long howManyOddsInRange(int min, int max) {
		long odds = 0;
		
		for(int i=min;i<=max;i++) {
			odds += howManyOddDigits(i);
		}
		
		return odds;
	}
}
