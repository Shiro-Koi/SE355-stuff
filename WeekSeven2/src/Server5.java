import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

public class Server5 {
    static String[] str = new String[10000];
    static int arrCounter = 0;
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

                    str[arrCounter++] = dis.readUTF();

                } catch (Exception e) {
                    System.out.println(e);

                    continue;
                }
            }
        } catch (Exception e) {

        }

    }
}
