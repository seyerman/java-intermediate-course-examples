package thread;

import java.math.BigInteger;

import javafx.application.Platform;
import model.IntensiveProcessing;
import ui.IntensiveProcessingGUIWithSeparateThread;

public class IntensiveProcessingThread extends Thread{
	private IntensiveProcessing ip;
	private IntensiveProcessingGUIWithSeparateThread ipgui;
	public IntensiveProcessingThread(IntensiveProcessing intproc, 
			IntensiveProcessingGUIWithSeparateThread intprocGUI) {
		ip = intproc;
		ipgui = intprocGUI;
	}
	public void run() {
		BigInteger s = ip.heavyAlgorithm();
		
		Platform.runLater(new Thread() {
			
			@Override
			public void run() {
				ipgui.updateGUI(s);				
			}
		});
		
	}
}
