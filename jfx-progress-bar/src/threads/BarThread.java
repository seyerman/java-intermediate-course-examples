package threads;

import javafx.application.Platform;
import model.Bar;
import ui.ProgressBarsGUI;

public class BarThread extends Thread{
	private Bar b;
	private ProgressBarsGUI pBarGUI;
	private int time;
	
	public BarThread(Bar bar, ProgressBarsGUI pBar, int t) {
		b = bar;
		pBarGUI = pBar;
		time = t;
	}
	
	public void run() {
		while (b.isActive()) {
			b.advance();
			Platform.runLater(new Thread() {
				public void run() {
					pBarGUI.updateBar();
				}
			});
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Platform.runLater(new Thread() {
			public void run() {
				pBarGUI.stop(null);
			}
		});		
	}
}
