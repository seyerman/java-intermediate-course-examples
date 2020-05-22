package ui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import model.Bar;
import threads.BarThread;

public class ProgressBarsGUI {

    @FXML
    private Pane pane;
    
    @FXML
    private TextField txtTime;

    @FXML
    private Button butStart;

    @FXML
    private Button butStop;

    private ArrayList<Rectangle> recBars;
    
    private ArrayList<Bar> bars;
    
    public ProgressBarsGUI() {
    	bars = new ArrayList<>();    	
    }
    
    public void initialize() {
    	butStop.setDisable(true);
    	recBars = new ArrayList<>();
    }

    @FXML
    public void newBar(ActionEvent event) {
    	try {
    		int time = Integer.parseInt(txtTime.getText());
    		
    		//the model
	    	Bar b = new Bar(bars.size(), time);
	    	bars.add(b);
	    	
	    	//the gui
	    	double x = 25;
	    	double height = 25;
	    	double head = txtTime.getLayoutY()+55;
	    	double space = 35;
	    	Rectangle r1 = new Rectangle(Bar.MAX_LEVEL,height);
	    	Rectangle r2 = new Rectangle(0,height);
	    	r1.setStroke(new Color(0,0,0,1));
	    	r2.setStroke(new Color(0,0,0,1));
	    	r1.setFill(new Color(1,1,1,1));
	    	r2.setFill(new Color(Math.random(),Math.random(),Math.random(),Math.random()));
	    	r1.setLayoutX(x);
	    	r2.setLayoutX(x);
	    	double y = head+space*recBars.size();
	    	r1.setLayoutY(y);
	    	r2.setLayoutY(y);
	    	pane.getChildren().add(r1);
	    	pane.getChildren().add(r2);
	    	recBars.add(r2);
	    	
	    	Label l = new Label(time+"");
	    	l.setLayoutX(x);
	    	l.setLayoutY(y);
	    	l.setFont(new Font(16));
	    	pane.getChildren().add(l);
    	}catch(NumberFormatException nfe) {
    		new Alert(Alert.AlertType.ERROR,"You should enter a integer number in the time field").showAndWait();
    	}    	
    }
    
    @FXML
    public void start(ActionEvent event) {
    	butStart.setDisable(true);
    	butStop.setDisable(false);
    	for (Bar b : bars) {
    		b.setActive(true);
        	new BarThread(b, this).start();			
		}
    }

    @FXML
    public void stop(ActionEvent event) {
    	butStart.setDisable(false);
    	butStop.setDisable(true);
    	for (Bar b : bars) {
    		b.setActive(false);
    	}
    }
    
    public void updateButtonStopStart() {
    	boolean active = false;
    	for (int i=0;i<bars.size() && !active;i++) {
    		active = bars.get(i).isActive();
    	}
    	if(!active) {
        	butStart.setDisable(false);
        	butStop.setDisable(true);    		
    	}
    }
    
    public void updateBar(int i) {
    	recBars.get(i).setWidth(bars.get(i).getProgressLevel());
    }

}
