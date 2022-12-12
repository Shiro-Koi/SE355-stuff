import java.io.*;
import java.net.*;

public class Serverrr {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(1001);
        Socket socket = serverSocket.accept();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Message message = (Message) in.readObject();
        System.out.println(message.getText());
    }
}
