package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class MovingShapesGUI {

    @FXML
    private Circle shCircle;
    
    public final static double STEP = 80; 

    @FXML
    public void moveLeft(ActionEvent event) {
    	double x = shCircle.getLayoutX();
    	x = x - STEP;
    	shCircle.setLayoutX(x);
    }

    @FXML
    public void moveRight(ActionEvent event) {
    	double x = shCircle.getLayoutX();
    	x = x + STEP;
    	shCircle.setLayoutX(x);
    }

}
