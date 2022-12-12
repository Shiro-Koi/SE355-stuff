import java.io.*;
import java.net.*;
import java.util.Random;

public class A {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1000); // to accept a connection
            while(true) {
                try {
                    Socket s2 = new Socket("localhost", 2000); // to connect to B
                    Socket s = ss.accept(); // to accept a connection from D

                    DataInputStream dis = new DataInputStream(s.getInputStream()); // D
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream()); // D

                    DataInputStream dis2 = new DataInputStream(s2.getInputStream()); // B
                    DataOutputStream dos2 = new DataOutputStream(s2.getOutputStream()); // B

                    Random r = new Random();
                    int n = r.nextInt(100); // generate a random number
                    dos.writeInt(n); // send it to D
                    int m = dis.readInt(); // receive it from D
                    dos2.writeInt(m); // send it to B
                    int k = dis2.readInt(); // receive it from B
                    System.out.println(k);
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
