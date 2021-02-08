package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class MenuExampleGUI {

    @FXML
    private Pane mainPane;

    @FXML
    public void showForm1(ActionEvent event) throws IOException {
    	Parent form1 = FXMLLoader.load(getClass().getResource("Form-1.fxml"));    	
    	mainPane.getChildren().setAll(form1);
    }

    @FXML
    public void showForm2(ActionEvent event) throws IOException {
    	Parent form2 = FXMLLoader.load(getClass().getResource("Form-2.fxml"));    	
    	mainPane.getChildren().setAll(form2);
    }
    
}
