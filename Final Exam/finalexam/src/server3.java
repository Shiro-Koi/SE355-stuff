import java.util.*;
import java.io.*;
import java.net.*;

public class server3 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2003);
            while (true) {
                try {
                    Socket s2 = new Socket("localhost", 2002);
                    Socket s3 = new Socket("localhost", 2004);
                    Socket s = ss.accept();
                    Random rand = new Random();
                    int random = rand.nextInt(100);

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s2.getOutputStream());
                    DataOutputStream dos2 = new DataOutputStream(s3.getOutputStream());

                    Scanner sc = new Scanner(System.in);

                    dos.writeInt(random);
                    dos2.writeInt(random);

                    System.out.println("the message: " + dis.readInt()/5);
                    System.out.println(" ");

                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }
                break;
            }
        } catch (Exception e) {

        }
    }
}
