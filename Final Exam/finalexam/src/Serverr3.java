import java.io.*;
import java.net.*;
import java.util.*;

public class Serverr3 { // D

    public Serverr3() {
        try {
            ServerSocket ss = new ServerSocket(3000); // D

            while (1 == 1) {
                Socket s1 = ss.accept();
                Socket s = new Socket("localhost", 4000);

                DataInputStream in = new DataInputStream(s1.getInputStream()); // input from terminal
                DataOutputStream out = new DataOutputStream(s.getOutputStream()); // output to socket

                String str = in.readUTF();
                out.writeUTF(str);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        Serverr3 s = new Serverr3();
    }
}
