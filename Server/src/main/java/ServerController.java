

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerController {
    @FXML
    private TextField portField; // Must match fx:id in FXML
    @FXML
    private TextArea logArea;   // Must match fx:id in FXML
    @FXML
    private ListView<String> clientList; // Must match fx:id in FXML
    @FXML
    private Label clientCountLabel; // Must match fx:id in FXML
    @FXML
    private Button stopButton; // Must match fx:id in FXML

    private Stage stage;
    private Scene introScene;
    private Scene gameInfoScene;


    public void setStageAndScenes(Stage stage, Scene introScene, Scene gameInfoScene) {
        this.stage = stage;
        this.introScene = introScene;
        this.gameInfoScene = gameInfoScene;
    }

    @FXML
    public void startServer() throws IOException {

        ServerSocket mysocket = new ServerSocket(Integer.parseInt(portField.getText()));
        System.out.println("Server is waiting for a client!");
        stage.setScene(gameInfoScene);
        Socket connection = mysocket.accept();

        System.out.println("Server has a client!!!");
        System.out.println("This is the remote port the client is using: " + connection.getPort());

        ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
        connection.setTcpNoDelay(true);

    }

    @FXML
    public void stopServer() {

    }

    public void log(String message) {

    }

    public void updateClientList(ArrayList<String> clients) {

    }


    public class ClientThread extends Thread {
        Socket connection;
        ObjectInputStream inputStream;
        ObjectInputStream objectInputStream;
        int count;

        ClientThread(Socket connection,int count){
            this.connection = connection;
            this.count = count;
        }
        


    }
}
