import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server5 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2005);
            System.out.println("first check point");

            while (true) {
                try {
                    System.out.println("second check point");

                    Socket s2 = new Socket("localhost", 2001);
                    Socket s = ss.accept();

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s2.getOutputStream());

                    // Scanner sc = new Scanner(System.in);
                    System.out.println("third check point");

                    dos.writeInt(dis.readInt());
                    System.out.println(" ");

                } catch (Exception e) {
                    System.out.println(e);

                    continue;
                }
            }
        } catch (Exception e) {

        }

    }
}
