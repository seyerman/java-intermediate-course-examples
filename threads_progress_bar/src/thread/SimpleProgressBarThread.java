package thread;

import model.SimpleProgressBar;
import ui.Main;

public class SimpleProgressBarThread extends Thread{
	private SimpleProgressBar spb;
	private Main main;
	private int repetitions;
	
	public SimpleProgressBarThread(SimpleProgressBar s, Main m, int rep) {
		spb = s;
		main = m;
		repetitions = rep;
	}
	
	public void run() {
		while(repetitions>0) {
			spb.advance();
			main.printProgressBar();
			repetitions--;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
