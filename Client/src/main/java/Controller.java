import javafx.event.ActionEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Controller {
    public void handlePlay(ActionEvent actionEvent) throws IOException {
        Socket socketClient= new Socket("127.0.0.1",1222);
        System.out.println("Client: "+"Connection Established");

        System.out.println("This is the remote address client is connected to: " +socketClient.getRemoteSocketAddress());
        System.out.println("And the remote port: " + socketClient.getPort());

        Scanner scanner = new Scanner(System.in);
        ObjectOutputStream out = new ObjectOutputStream(socketClient.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socketClient.getInputStream());
        socketClient.setTcpNoDelay(true);
    }

    public void newLook(ActionEvent actionEvent) {

    }

    public void restartGame(ActionEvent actionEvent) {
    }

    public void handleExit(ActionEvent actionEvent) {
    }

    public void exitGame(ActionEvent actionEvent) {
    }

    public void backToGame(ActionEvent actionEvent) {

    }

    public void showSettings(ActionEvent actionEvent) {
    }

    public void handleBetOne(ActionEvent actionEvent) {
    }

    public void handleBetTwo(ActionEvent actionEvent) {
    }

    public void playerFold(ActionEvent actionEvent) {
    }

    public void playerPlay(ActionEvent actionEvent) {
    }
}
