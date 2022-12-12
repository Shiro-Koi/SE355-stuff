
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
    static String[] str = new String[10000];
    static int arrCounter = 0;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2001);
            int counter = 0;
            while (true) {
                try {

                    Socket s2 = new Socket("localhost", 2002 + (counter++%5));
                    Socket s = ss.accept();
                    
                    DataOutputStream dos = new DataOutputStream(s2.getOutputStream());


                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter a message: ");

                    String msg = sc.nextLine();

                    if (counter == 0) {
                        str[arrCounter++] = msg;
                    } else {
                        dos.writeUTF(msg);
                    }
                    

                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }
            }
        } catch (Exception e) {

        }

    }

}