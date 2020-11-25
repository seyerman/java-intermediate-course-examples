package ui;

import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import model.Ball;
import thread.BallNoSynchronizedThreadX;
import thread.BallNoSynchronizedThreadY;
import thread.BallSynchronizedThreadX;
import thread.BallSynchronizedThreadY;

public class MovingBallGUI {

    @FXML
    private Circle ball;
    
    private Ball theBall;
    
    public void initialize() {
    	theBall = new Ball(ball.getLayoutX(),ball.getLayoutY(),ball.getRadius());
    }

    @FXML
    public void mouseClicked(MouseEvent event) {
    	if(event.getButton()==MouseButton.PRIMARY) {
	    	new BallNoSynchronizedThreadX(event.getSceneX(), theBall, this).start();
	    	new BallNoSynchronizedThreadY(event.getSceneY(), theBall, this).start();    		
    	}else {
	    	new BallSynchronizedThreadX(event.getSceneX(), theBall, this).start();
	    	new BallSynchronizedThreadY(event.getSceneY(), theBall, this).start();
    	}
    }
    
    public void updateGUI() {
    	ball.setLayoutX(theBall.getX());
    	ball.setLayoutY(theBall.getY());
    }
}
