package ui;

import model.ProgressGadget;
import model.SimpleProgressBar;
import model.SimpleProgressSymbol;
import thread.ProgressGadgetThread;

public class ProgressUI {
	private ProgressGadgetThread[] threads;
	private ProgressGadget[] progressG;
	public static final int NUM_THREADS = 3;

	public ProgressUI() {
		progressG = new ProgressGadget[NUM_THREADS];
		progressG[0] = new SimpleProgressSymbol(100);
		progressG[1] = new SimpleProgressBar(100,'#');
		progressG[2] = new SimpleProgressBar(100,'=','-');
		
		threads = new ProgressGadgetThread[NUM_THREADS];
		for(int i=0;i<NUM_THREADS;i++) {
			threads[i] = new ProgressGadgetThread(progressG[i],this,50+(int)(Math.random()*400));
		}
	}
	
	public void startProgress() {
		for(ProgressGadgetThread pgt: threads) {
			pgt.start();
		}
		System.out.println("[S][ SIMPLE PROG BAR ]    [ LINES PROGR BAR ]    [ ROTATE PROGRESS BAR ]    [ SPACESHIP BAR ][  ARROW BAR  ]");
	}

	public void refresh() {
		String progressState = "\r";
		for(ProgressGadget pg: progressG) {
			progressState += pg.getState();
		}
		System.out.print(progressState);
	}
}
