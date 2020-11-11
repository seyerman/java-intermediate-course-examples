package ui;

import model.ProgressGadget;
import model.SimpleProgressBar;
import model.SimpleProgressSymbol;
import thread.ProgressGadgetThread;

public class ProgressUI {
	private ProgressGadgetThread[] threads;
	private ProgressGadget[] progressG;
	public static final int NUM_THREADS = 2;

	public ProgressUI() {
		progressG = new ProgressGadget[NUM_THREADS];
		progressG[0] = new SimpleProgressSymbol(10000);		
		progressG[1] = new SimpleProgressBar(100);
		
		threads = new ProgressGadgetThread[NUM_THREADS];
		for(int i=0;i<NUM_THREADS;i++) {
			threads[i] = new ProgressGadgetThread(progressG[i],this);
		}
	}
	
	public void startProgress() {
		for(ProgressGadgetThread pgt: threads) {
			pgt.start();
		}
	}

	public void refresh() {
		String progressState = "\r";
		for(ProgressGadget pg: progressG) {
			progressState += pg.getState();
		}
		System.out.print(progressState);
	}
}
