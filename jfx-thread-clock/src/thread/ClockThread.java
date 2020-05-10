package thread;

import javafx.application.Platform;
import model.Clock;
import ui.ClockGUI;

public class ClockThread extends Thread{
	private Clock clock;
	private ClockGUI clockGUI;
	
	public ClockThread(Clock ring, ClockGUI rgui) {
		clock = ring;
		clockGUI = rgui;
		setDaemon(true);
	}
	
	public void run() {
		
		while(clock.getSpin()) {
			
			clock.rotateHands();
			
			Platform.runLater(new Thread() {
				public void run() {
					clockGUI.updateClock();
				}
			});
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
