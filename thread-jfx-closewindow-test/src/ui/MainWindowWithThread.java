package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainWindowWithThread extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Close Window Test");		
		Thread t = new Thread() {
			public void run() {
				while(true);
			}
		};
		t.start();
		primaryStage.show();
	}
	
	
}
