package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.TemperatureConverter;

public class TemperatureConverterGUI {

    @FXML
    private TextField txtCelsius;

    @FXML
    private Label labMsg;

    @FXML
    public void convertCelsiusToFahrenheit(ActionEvent event) {
    	try {
    		double celsius = Double.parseDouble(txtCelsius.getText());
    		
    		double fah = TemperatureConverter.celsiusToFahrenheit(celsius);
    		
    		labMsg.setText(celsius+"°C is equal to "+fah+"°F");
    		
    	}catch (NumberFormatException nfe) {
    		labMsg.setText("Digite un número");
		}
    }

}
