package ui;

import java.math.BigInteger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.IntensiveProcessing;
import thread.IntensiveProcessingThread;

public class IntensiveProcessingGUIWithSeparateThread {
	private IntensiveProcessing ip;
	
    @FXML
    private Button butHeavyAlgorithm;
    
    @FXML
    private TextField txtNumber;
    
    @FXML
    private Label labSum;
    
	public IntensiveProcessingGUIWithSeparateThread() {
	}
	
	@FXML
    public void doHeavyAlgorithm(ActionEvent event) {
		try {
			long number = Long.parseLong(txtNumber.getText());
			
			disableControls();
			
			ip = new IntensiveProcessing(number);
			
			IntensiveProcessingThread ipt = new IntensiveProcessingThread(ip, this);
			ipt.start();
		}catch (NumberFormatException nfe) {
		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setContentText("You have to enter a number in the field");
		
		    alert.showAndWait();			
		}
    }
	
	public void updateGUI(BigInteger s) {
		enableControls();
		
		labSum.setText(s.toString());
		
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Algorithm finalized");
	    alert.setHeaderText("Sum of numbers");
	    alert.setContentText("The final result is: "+s);
	
	    alert.showAndWait();
	}
	
	public void disableControls() {
		butHeavyAlgorithm.setDisable(true);
		txtNumber.setEditable(false);
	}
	
	public void enableControls() {
		butHeavyAlgorithm.setDisable(false);
		txtNumber.setEditable(true);
	}
}
