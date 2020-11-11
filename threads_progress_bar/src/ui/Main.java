package ui;

import model.SimpleProgressBar;
import thread.SimpleProgressBarThread;

public class Main {
	private SimpleProgressBar spb;
	private SimpleProgressBarThread spbt;
	
	public Main() {
		spb = new SimpleProgressBar();
		spbt = new SimpleProgressBarThread(spb, this, 10000);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.startProgressBar();
	}
	
	public void startProgressBar() {
		spbt.start();
	}

	public void printProgressBar() {
		System.out.print("\r["+spb.getState()+"]");
	}
}
