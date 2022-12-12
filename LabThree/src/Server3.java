import java.io.*;
import java.net.*;

public class Server3 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2079);

            while (true) {
                try {
                    Socket s2 = new Socket("localhost", 2080);
                    Socket s = ss.accept();

                    int rand = (int) (Math.floor(Math.random() * 1001));

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s2.getOutputStream());

                    dos.writeInt(dis.readInt() + rand);

                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {

        }

    }
}
