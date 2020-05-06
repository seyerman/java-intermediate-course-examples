package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private BallBouncingGUI bbgui;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		bbgui = new BallBouncingGUI(primaryStage);
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("Table.fxml"));
		fxmll.setController(bbgui);
		Parent root = fxmll.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ball Bouncing");
		primaryStage.show();
	}
	
}
