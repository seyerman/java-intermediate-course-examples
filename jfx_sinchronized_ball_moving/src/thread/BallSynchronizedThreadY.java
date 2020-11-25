package thread;

import javafx.application.Platform;
import model.Ball;
import ui.MovingBallGUI;

public class BallSynchronizedThreadY extends Thread{
	private double yDest;
	private Ball ball;
	private MovingBallGUI movingBallGUI;
	
	public BallSynchronizedThreadY(double yDest, Ball ball, MovingBallGUI movingBallGUI) {
		setDaemon(true);
		this.yDest = yDest;
		this.ball = ball;
		this.movingBallGUI = movingBallGUI;
	}
	
	public void run() {
		synchronized (ball) {
			while (yDest!=ball.getY()) {
				ball.moveY(yDest);
				
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
}
