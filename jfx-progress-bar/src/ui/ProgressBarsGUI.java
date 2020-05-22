package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import model.Bar;
import threads.BarThread;

public class ProgressBarsGUI {

    @FXML
    private TextField txtTime;

    @FXML
    private Button butStart;

    @FXML
    private Button butStop;

    @FXML
    private Rectangle recBar;
    
    private Bar bar;
    
    public ProgressBarsGUI() {
    	bar = new Bar();    	
    }
    
    public void initialize() {
    	butStop.setDisable(true);
    }

    @FXML
    public void start(ActionEvent event) {
    	try {
    		int time = Integer.parseInt(txtTime.getText());
    		bar.setActive(true);
	    	butStart.setDisable(true);
	    	butStop.setDisable(false);
	    	new BarThread(bar, this, time).start();
    	}catch(NumberFormatException nfe) {
    		new Alert(Alert.AlertType.ERROR,"You should enter a integer number in the time field").showAndWait();
    	}
    }

    @FXML
    public void stop(ActionEvent event) {
    	bar.setActive(false);
    	butStart.setDisable(false);
    	butStop.setDisable(true);    	
    }
    
    public void updateBar() {
    	recBar.setWidth(bar.getProgressLevel());
    }

}
