import java.io.*;
import java.net.*;

public class Server5 {

    public Server5() {

        try {
            ServerSocket ss = new ServerSocket(5000);

            while (1 == 1) {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Socket s1 = ss.accept();
                Socket s = new Socket("localhost", 1000);

                DataInputStream in = new DataInputStream(s1.getInputStream()); // input from terminal
                DataOutputStream out = new DataOutputStream(s.getOutputStream()); // output to socket

                out.writeUTF(in.readUTF());
                System.out.println("Server says: " + in.readUTF());
            }

        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        Server5 s = new Server5();
    }
}
