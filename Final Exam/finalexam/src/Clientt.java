import java.io.*;
import java.net.*;

public class Clientt {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 1001);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new Message("Hello World!"));
    }
}
