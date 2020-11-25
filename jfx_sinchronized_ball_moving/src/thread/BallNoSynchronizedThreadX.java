package thread;

import javafx.application.Platform;
import model.Ball;
import ui.MovingBallGUI;

public class BallNoSynchronizedThreadX extends Thread{
	private double xDest;
	private Ball ball;
	private MovingBallGUI movingBallGUI;
	
	public BallNoSynchronizedThreadX(double xDest, Ball ball, MovingBallGUI movingBallGUI) {
		setDaemon(true);
		this.xDest = xDest;
		this.ball = ball;
		this.movingBallGUI = movingBallGUI;
	}
	
	public void run() {
		while (xDest!=ball.getX()) {
			ball.moveX(xDest);
			
			Platform.runLater(new Thread() {
				public void run() {
					movingBallGUI.updateGUI();
				}
			});
			
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
