package model;

public class PrimeNumberVerifier {
	private long startNumber;
	private long endNumber;
	
	private long currentNumber;
	
	private int primeMethod; //0 from 2 to n-1 total traversal, 1 from 2 to n-1 parcial traversal, 2 from 2 to root(n) parcial traversal
	
	private int primesAmount;
	
	public PrimeNumberVerifier(long sn, long en, int pm) {
		startNumber = sn;
		endNumber = en;
		primeMethod = pm;
		
		currentNumber = startNumber;
		primesAmount = 0;
	}
	
	public void advance(){
		currentNumber++;
	}
	
	public boolean isCurrentPrime() {
		if(currentNumber<2) {
			return false;
		}else if(currentNumber==2) {
			return true;
		}
		
		boolean isPrime = true;
		
		long limitNumber;
		if(primeMethod==2) {
			limitNumber = (long)Math.ceil(Math.sqrt(currentNumber));
		}else {
			limitNumber = currentNumber-1;
		}
		
		//System.out.println("limitNumber: "+limitNumber);
		for (long i = 2; i <= limitNumber && (primeMethod==0 || isPrime); i++) {
			//System.out.println(currentNumber+"%"+i+":"+currentNumber%i);
			if(currentNumber%i == 0) {
				isPrime = false;
			}
		}
		
		if(isPrime) {
			primesAmount++;
		}
		
		return isPrime;
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

	public int getPrimesAmount() {
		return primesAmount;
	}
}
