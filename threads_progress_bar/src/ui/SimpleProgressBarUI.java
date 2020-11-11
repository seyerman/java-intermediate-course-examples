package ui;

import model.SimpleProgressBar;
import thread.SimpleProgressBarThread;

public class SimpleProgressBarUI {
	private SimpleProgressBar spb;
	private SimpleProgressBarThread spbt;

	public SimpleProgressBarUI() {
		spb = new SimpleProgressBar();
		spbt = new SimpleProgressBarThread(spb, this, 10000);
	}
	
	public void startProgressBar() {
		spbt.start();
	}

	public void printProgressBar() {
		System.out.print("\r["+spb.getState()+"]");
	}
}
