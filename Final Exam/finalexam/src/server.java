import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    public static void main(String[] args) {
        // ring topology bidirectional communication
        try {
            ServerSocket ss = new ServerSocket(2001);
            while (true) {
                try {
                    Socket s2 = new Socket("localhost", 2002); // E
                    Socket s3 = new Socket("localhost", 2005); // B
                    Socket s = ss.accept();
                    Random rand = new Random();
                    int random = rand.nextInt(100);

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s2.getOutputStream()); // E
                    DataOutputStream dos2 = new DataOutputStream(s3.getOutputStream()); // B

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

    //send backup to B
    // static void sendBackup(Socket s, int portCounter) {
    //     try {
    //         Socket s2 = new Socket("localhost", 2002 + (portCounter%3));
    //         DataOutputStream dos = new DataOutputStream(s2.getOutputStream());
    //         dos.writeInt(1);
    //     } catch (Exception e) {
    //     }
    // }
}
