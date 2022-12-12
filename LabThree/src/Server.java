import java.io.*;
import java.net.*;

public class Server {
    public static int counter = 0;
    
    public static int meaner(int num, int nodes) {
        return num/nodes;
    }

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2077);

            while (true) {
                try {
                    Socket s2 = new Socket("localhost", 2078);
                    Socket s = ss.accept();

                    int rand = (int) (Math.floor(Math.random() * 1001));

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s2.getOutputStream());

                    dos.writeInt(rand);

                    System.out.println("mean: " + meaner(dis.readInt(), 5));

                } catch (Exception e) {
                    continue;
                }
                counter++;
                // repeat 5 times
                if (counter == 5) {
                    break;
                }
            }
        } catch (Exception e) {

        }

    }

}