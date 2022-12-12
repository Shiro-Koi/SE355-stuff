import java.io.*;
import java.net.*;

public class Server2 {

    public Server2() {

            try {
                ServerSocket ss = new ServerSocket(2000);

                while (1==1) {
                    try {
                        try {
                            Thread.sleep(15000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Socket s1 = ss.accept();
                        Socket s = new Socket("localhost", 3000);

                        DataInputStream in = new DataInputStream(s1.getInputStream()); // input from terminal
                        DataOutputStream out = new DataOutputStream(s.getOutputStream()); // output to socket

                        out.writeUTF(in.readUTF());
                        System.out.println("Server says: " + in.readUTF());
                    
                } catch (Exception e) {
                    continue;
                }
                    
                }

            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
        }

    public static void main(String[] args) {
        Server3 s = new Server3();
    }
}
