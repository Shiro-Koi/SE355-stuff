import java.net.*;
import java.io.*;

public class Server {
 
    public Server (int port) {
        try {
            ServerSocket ss = new ServerSocket(5000);

            System.out.println("Waiting for User to connect...");

            Socket s = ss.accept();
            System.out.println("User accepted!!!");
            
            DataInputStream in = new DataInputStream(s.getInputStream()); // input from terminal
            DataOutputStream out = new DataOutputStream(s.getOutputStream()); // output to socket
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            while (1 == 1) {
                    System.out.println("User says: " + in.readUTF());
                    System.out.print("Enter a message: ");
                    out.writeUTF(br.readLine());
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Server s = new Server(2022);
    }
}
