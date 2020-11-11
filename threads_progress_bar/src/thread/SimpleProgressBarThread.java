package thread;

import model.SimpleProgressBar;
import ui.SimpleProgressBarUI;

public class SimpleProgressBarThread extends Thread{
	private SimpleProgressBar spb;
	private SimpleProgressBarUI spbui;
	private int repetitions;
	
	public SimpleProgressBarThread(SimpleProgressBar s, SimpleProgressBarUI ui, int rep) {
		spb = s;
		spbui = ui;
		repetitions = rep;
	}
	
	public void run() {
		while(repetitions>0) {
			spb.advance();
			spbui.printProgressBar();
			repetitions--;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
