package thread;

import model.SimpleProgressSymbol;
import ui.SimpleProgressSymbolUI;

public class SimpleProgressSymbolThread extends Thread{
	private SimpleProgressSymbol sps;
	private SimpleProgressSymbolUI spsui;
	private int repetitions;
	
	public SimpleProgressSymbolThread(SimpleProgressSymbol s, SimpleProgressSymbolUI ui, int rep) {
		sps = s;
		spsui = ui;
		repetitions = rep;
	}
	
	public void run() {
		while(repetitions>0) {
			sps.advance();
			spsui.refresh();
			repetitions--;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
