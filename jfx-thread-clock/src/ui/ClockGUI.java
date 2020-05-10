package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import model.Clock;
import thread.ClockThread;

public class ClockGUI {

    @FXML
    private Button butStart;

    @FXML
    private Button butStop;

    @FXML
    private Line lineMinuteHand;

    @FXML
    private Line lineHourHand;
    
    private Clock clock;

    public void initialize() {
    	clock = new Clock(lineHourHand.getRotate(), lineMinuteHand.getRotate());
    	
    	butStop.setDisable(true);
    }
    
    @FXML
    public void start(ActionEvent event) {
    	clock.setSpin(true);
    	new ClockThread(clock, this).start();
    	butStop.setDisable(false);
    	butStart.setDisable(true);
    }

    @FXML
    public void stop(ActionEvent event) {
    	clock.setSpin(false);
    	butStop.setDisable(true);
    	butStart.setDisable(false);
    }
    
    public void updateClock() {
    	lineHourHand.setRotate(clock.getRotationHourHand());
    	lineMinuteHand.setRotate(clock.getRotationMinuteHand());
    }
}
