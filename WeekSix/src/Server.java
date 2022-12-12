import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    public Server() {
        while (1==1) {
            try {
                ServerSocket ss = new ServerSocket(1000);

                    while(1==1) {
                        try {
                            Thread.sleep(15000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Socket s1 = ss.accept();
                        Socket s = new Socket("localhost", 2000);

                        DataInputStream in = new DataInputStream(s1.getInputStream()); // input from terminal
                        DataOutputStream out = new DataOutputStream(s.getOutputStream()); // output to socket
                        Scanner sc = new Scanner(System.in);

                        out.writeUTF(sc.nextLine());
                        System.out.println("Server says: " + in.readUTF());
                    }
                } catch (IOException e) {
                    continue;
                }
            }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
