import java.io.*;
import java.net.*;
import java.util.*;

public class Serverr2 { // B

    public Serverr2() {
            try {
                ServerSocket ss = new ServerSocket(2000); // B

                while (1==1) {
                    Socket s1 = ss.accept();
                    Socket s = new Socket("localhost", 4000);

                    DataInputStream in = new DataInputStream(s1.getInputStream()); // input from terminal
                    DataOutputStream out = new DataOutputStream(s.getOutputStream()); // output to socket
                    Scanner sc = new Scanner(System.in);
                    String str = in.readUTF();
                    out.writeUTF(str);
                }

            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
    }

    public static void main(String[] args) {
        Serverr2 s = new Serverr2();
    }
}
