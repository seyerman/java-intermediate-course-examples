package thread;

import javafx.application.Platform;
import model.Ringlete;
import ui.RingleteGUI;

public class RingleteThread extends Thread{
	private Ringlete ringlete;
	private RingleteGUI ringleteGUI;
	
	public RingleteThread(Ringlete ring, RingleteGUI rgui) {
		ringlete = ring;
		ringleteGUI = rgui;
	}
	
	public void run() {
		while(ringlete.getSpin()) {
			
			ringlete.rotateSquares();
			
			Platform.runLater(new Thread() {
				public void run() {
					ringleteGUI.updateRinglete();
				}
			});
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
