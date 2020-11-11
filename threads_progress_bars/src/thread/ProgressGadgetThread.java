package thread;

import model.ProgressGadget;
import ui.ProgressUI;

public class ProgressGadgetThread extends Thread{
	private ProgressGadget pg;
	private ProgressUI psui;
	
	public ProgressGadgetThread(ProgressGadget p, ProgressUI ui) {
		pg = p;
		psui = ui;
	}
	
	public void run() {
		while(!pg.finished()) {
			pg.advance();
			psui.refresh();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
