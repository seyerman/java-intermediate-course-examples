package thread;

import javafx.application.Platform;
import model.Clock;
import model.Hand;
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
			
			boolean hourMoved = clock.rotateHands();
			double minuteAngle = Hand.ANGLE_ROTATE;
			double hourAngle = hourMoved?Hand.ANGLE_ROTATE:0;
			
			Platform.runLater(new Thread() {
				public void run() {
					clockGUI.updateClock(hourAngle,minuteAngle);
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
