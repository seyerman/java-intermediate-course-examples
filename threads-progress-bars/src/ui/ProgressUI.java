package ui;

import java.util.Scanner;

import model.ProgressGadget;
import model.RotateProgressBar;
import model.SimpleProgressBar;
import model.SimpleProgressSymbol;
import thread.ProgressGadgetThread;

public class ProgressUI {
	private ProgressGadgetThread[] threads;
	private ProgressGadget[] progressG;
	public static final int NUM_THREADS = 4;

	public ProgressUI() {
	}
	
	private void createProgressGadgets(int[] maximums) {
		progressG = new ProgressGadget[NUM_THREADS];
		progressG[0] = new SimpleProgressSymbol(maximums[0]);
		progressG[1] = new SimpleProgressBar(maximums[1],'#');
		progressG[2] = new SimpleProgressBar(maximums[2],'=','-');
		progressG[3] = new RotateProgressBar(maximums[3],'o',new char[] {'|','/','-','\\'});
		
		threads = new ProgressGadgetThread[NUM_THREADS];
		for(int i=0;i<NUM_THREADS;i++) {
			threads[i] = new ProgressGadgetThread(progressG[i],this,50+(int)(Math.random()*400));
		}		
	}
	
	private int[] readInputs() {
		System.out.print("Please, enter the maximum values for each progress gadget: ");
		Scanner sc = new Scanner(System.in);
		String[] parts = sc.nextLine().split(" ");
		sc.close();
		int[] maxs = new int[parts.length];
		for(int i=0;i<parts.length;i++) {
			maxs[i] = Integer.parseInt(parts[i]);
		}
		return maxs;
	}
	
	public void startProgress() {
		createProgressGadgets(readInputs());
		
		for(ProgressGadgetThread pgt: threads) {
			pgt.start();
		}

		System.out.println("[S][ SIMPLE PROG BAR ]    [ LINES PROGR BAR ]    [ ROTATE PROG BAR ]    [ SPACESHIP BAR ][  ARROW BAR  ]");
		System.out.flush();
	}

	public void refresh() {
		String progressState = "\r";
		for(ProgressGadget pg: progressG) {
			progressState += pg.getState();
		}
		System.out.print(progressState);
		System.out.flush();
	}
}
