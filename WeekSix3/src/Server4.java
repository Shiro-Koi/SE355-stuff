import java.io.*;
import java.net.*;

public class Server4 {
    String[] msg = new String[200];
    int i = 0;

    public Server4() {
        try {
            ServerSocket ss = new ServerSocket(4000);

            while (1 == 1) {
                Socket s1 = ss.accept();
                DataInputStream in = new DataInputStream(s1.getInputStream()); // input from terminal
                // System.out.println("Server says: " + in.readUTF());
                msg[i++] = in.readUTF();
                for (int j = 0; j < msg.length; j++) {
                    System.out.println(msg[j]);
                }
            }

        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        Server4 s = new Server4();
    }
}
