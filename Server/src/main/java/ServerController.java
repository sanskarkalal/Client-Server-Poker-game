

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
    ArrayList<ClientThread> clientThreads = new ArrayList<>();
    int count = 0;

    public void setStageAndScenes(Stage stage, Scene introScene, Scene gameInfoScene) {
        this.stage = stage;
        this.introScene = introScene;
        this.gameInfoScene = gameInfoScene;
    }

    @FXML
    public void startServer() throws IOException {

        while (true){
            ServerSocket mysocket = new ServerSocket(Integer.parseInt(portField.getText()));
            System.out.println("Server is waiting for a client!");
            stage.setScene(gameInfoScene);
            Socket connection = mysocket.accept();
            ClientThread c = new ClientThread(mysocket.accept(), count);
//
            clientThreads.add(c);
            c.start();

            count ++;
        }


    }

    @FXML
    public void stopServer() {

    }

    public void log(String message) {

    }

    public void updateClientList(ArrayList<String> clients) {
        for(ClientThread c : clientThreads){
            System.out.println(c.count);
            System.out.println(c.isAlive());
        }
    }


    public class ClientThread extends Thread {
        Socket connection;
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;
        int count;

        ClientThread(Socket connection,int count){
            this.connection = connection;
            this.count = count;
        }

        @Override
        public void run() {
            try{
                inputStream = new ObjectInputStream(connection.getInputStream());
                outputStream = new ObjectOutputStream(connection.getOutputStream());
                connection.setTcpNoDelay(true);
                System.out.println("Server has a client!!!");
                System.out.println("This is the remote port the client is using: " + connection.getPort());
            }catch (Exception e){
                e.printStackTrace();
            }




        }
    }
}
