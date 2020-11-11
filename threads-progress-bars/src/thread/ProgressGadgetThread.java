package thread;

import model.ProgressGadget;
import ui.ProgressUI;

public class ProgressGadgetThread extends Thread{
	private ProgressGadget pg;
	private ProgressUI psui;
	private long sleepTime;
	
	public ProgressGadgetThread(ProgressGadget p, ProgressUI ui, long st) {
		pg = p;
		psui = ui;
		sleepTime = st;
	}
	
	public void run() {
		while(!pg.finished()) {
			pg.advance();
			psui.refresh();
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
