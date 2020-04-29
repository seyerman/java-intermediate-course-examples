package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainWindowWithoutThread extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Close Window Test");		
		primaryStage.show();
	}
	
	
}
