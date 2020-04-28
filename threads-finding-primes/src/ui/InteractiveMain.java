package ui;

import java.util.Scanner;

import model.PrimeNumberVerifier;
import thread.PrimeVerifierThread;

public class InteractiveMain {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Until what number should I search for?: ");
		int maxNum = Integer.parseInt(sc.nextLine());
		System.out.print("Print all numbers -prime and no primes-? (0 only primes, 1 all numbers): ");
		boolean printAll = Integer.parseInt(sc.nextLine())==1;
		System.out.print("What prime verification method should I use? (0 all numbers complete, 1 all numbers parcial, 2 until square root): ");
		int methodUsed = Integer.parseInt(sc.nextLine());
		System.out.print("How many threads do you want to use to search?: ");
		int amountThreads = Integer.parseInt(sc.nextLine());
		
		sc.close();
		
		PrimeVerifierThread[] threads = new PrimeVerifierThread[amountThreads];
		PrimeNumberVerifier[] verifiers = new PrimeNumberVerifier[amountThreads];
		int intervals = maxNum/amountThreads;
		
		for (int i = 0; i < amountThreads; i++) {
			System.out.println(i*intervals+" "+(i+1)*intervals);
			PrimeNumberVerifier pnv = new PrimeNumberVerifier(i*intervals, (i+1)*intervals, methodUsed);
			threads[i] = new PrimeVerifierThread(pnv, printAll);
			verifiers[i] = pnv;
		}
		
		long init = System.currentTimeMillis();
		for (int i = 0; i < amountThreads; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < amountThreads; i++) {
			threads[i].join();
		}
		
		long end = System.currentTimeMillis();
		
		int totalPrimesAmount = 0;
		for (int i = 0; i < amountThreads; i++) {
			totalPrimesAmount += verifiers[i].getPrimesAmount();
		}
				
		System.out.println("Duration with "+amountThreads+" threads: "+(end-init));
		System.out.println("Total primes amount: "+totalPrimesAmount);
	}

}
