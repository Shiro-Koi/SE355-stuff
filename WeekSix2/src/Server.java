import java.io.*;
import java.net.*;
import java.util.*;

public class Server { // A

    public Server() {
            try {

                while (1==1) {
                    Socket s = new Socket("localhost", 2000); // B
                    Socket s2 = new Socket("localhost", 3000); // D

                    
                    DataOutputStream out = new DataOutputStream(s.getOutputStream()); // output to socket
                    DataOutputStream out1 = new DataOutputStream(s2.getOutputStream()); // output to socket
                    Scanner sc = new Scanner(System.in);
                    String str = sc.nextLine();
                    out.writeUTF(str);
                    out1.writeUTF(str);
                }

            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
