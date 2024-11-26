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
		FXMLLoader introLoader = new FXMLLoader(getClass().getResource("fxml/start.fxml"));
		FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("fxml/info.fxml"));

		Scene introScene = new Scene(introLoader.load());
		Scene gameInfoScene = new Scene(gameLoader.load());

		ServerController controller = introLoader.getController();
		controller.setStageAndScenes(primaryStage, introScene, gameInfoScene);

		primaryStage.setTitle("Server - Start");
		primaryStage.setScene(introScene);
		primaryStage.show();

	}

}
