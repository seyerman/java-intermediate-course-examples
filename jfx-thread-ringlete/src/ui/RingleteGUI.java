package ui;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import model.Ringlete;
import model.Square;
import thread.RingleteThread;

public class RingleteGUI {
    @FXML
    private Rectangle shSquare0;

    @FXML
    private Rectangle shSquare1;

    @FXML
    private Rectangle shSquare2;

    @FXML
    private Rectangle shSquare3;
    
    @FXML
    private Button butWind;

    @FXML
    private Button butStop;
    
    private Ringlete ringlete;
    
    public void initialize() {
    	ringlete = new Ringlete();
    	ringlete.addSquare(shSquare0.getRotate());
    	ringlete.addSquare(shSquare1.getRotate());
    	ringlete.addSquare(shSquare2.getRotate());
    	ringlete.addSquare(shSquare3.getRotate());
    	
    	butStop.setDisable(true);
    }
    
    @FXML
    public void wind(ActionEvent event) {
    	ringlete.setSpin(true);
    	new RingleteThread(ringlete, this).start();
    	butStop.setDisable(false);
    	butWind.setDisable(true);
    }

    @FXML
    public void stop(ActionEvent event) {
    	ringlete.setSpin(false);
    	butStop.setDisable(true);
    	butWind.setDisable(false);    	
    }
    
    public void updateRinglete() {
    	List<Square> ss = ringlete.getSquares();
    	shSquare0.setRotate(ss.get(0).getRotation());
    	shSquare1.setRotate(ss.get(1).getRotation());
    	shSquare2.setRotate(ss.get(2).getRotation());
    	shSquare3.setRotate(ss.get(3).getRotation());
    }
}
