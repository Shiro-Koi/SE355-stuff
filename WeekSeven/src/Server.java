
/**
 * Server
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

/* 
 Server one will send a message and goes through
 the ring and it comes back to server one and then server one prints it.
 */

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2001);
            System.out.println("first check point");

            while (true) {
                try {
                    System.out.println("second check point");

                    Socket s2 = new Socket("localhost", 2002);
                    Socket s = ss.accept();

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s2.getOutputStream());

                    Scanner sc = new Scanner(System.in);
                    System.out.println("third check point");

                    System.out.println("please write an int");
                    dos.writeInt(sc.nextInt());

                    System.out.println("the message: " + dis.readInt());
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