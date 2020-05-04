package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWithAnonymousThread extends Application{
	private IntensiveProcessingGUIWithAnonymousThread ipgui;
	
	public MainWithAnonymousThread() {
		ipgui = new IntensiveProcessingGUIWithAnonymousThread();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("ButtonPanel.fxml"));
		fxmll.setController(ipgui);
		Parent root = fxmll.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Intensive Algorithm Program :: Anonymous Thread");
		primaryStage.show();
	}

}
