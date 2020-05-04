package ui;

import java.math.BigInteger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import model.IntensiveProcessing;

public class IntensiveProcessingGUI {
	private IntensiveProcessing ip;
	
    @FXML
    private TextField txtNumber;
    
    @FXML
    private Label labSum;
    
	public IntensiveProcessingGUI() {
	}
	
	@FXML
    public void doHeavyAlgorithm(ActionEvent event) {
		long number = Long.parseLong(txtNumber.getText());
		
		ip = new IntensiveProcessing(number);
		
		BigInteger s = ip.heavyAlgorithm();
				
		labSum.setText(s.toString());
		
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Algorithm finalized");
	    alert.setHeaderText("Sum of numbers");
	    alert.setContentText("The final result is: "+s);
	
	    alert.showAndWait();
    }	
}
