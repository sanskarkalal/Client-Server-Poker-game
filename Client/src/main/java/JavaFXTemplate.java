import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Three Card Poker");
		Parent welcome = FXMLLoader.load(getClass()
				.getResource("/FXML/welcome.fxml"));


		Scene s1 = new Scene(welcome, 1000,800);

		s1.getStylesheets().add("styles/welcome.css");
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(s1);
		primaryStage.show();

		
				
		
	}

}
