package thread;

import model.PrimeNumberVerifier;

public class PrimeVerifierThread extends Thread{
	private PrimeNumberVerifier primeVerifier;
	private boolean printAll;
	public PrimeVerifierThread(PrimeNumberVerifier co, boolean pa) {
		primeVerifier = co;
		printAll = pa;
	}
	
	@Override
	public void run() {
		while(primeVerifier.getCurrentNumber()<primeVerifier.getEndNumber()) {
			primeVerifier.advance();
			if(primeVerifier.isCurrentPrime()) {
				System.out.println(primeVerifier.getCurrentNumber()+" IS PRIME NUMER");
			}else if(printAll) {
				System.out.println(primeVerifier.getCurrentNumber()+" IS NOT PRIME NUMER");				
			}
			
		}
	}
}
