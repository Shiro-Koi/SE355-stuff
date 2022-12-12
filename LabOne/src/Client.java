import java.io.*;
import java.net.*;

public class Client {


    public Client (String address, int port) {
        try {
            Socket s = new Socket(address, port);
            
            System.out.println("Connection Established!!!");

            DataInputStream in = new DataInputStream(s.getInputStream()); // input from terminal
            DataOutputStream out = new DataOutputStream(s.getOutputStream()); // output to socket
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (1 == 1) {
                    System.out.print("Enter a message: ");
                    out.writeUTF(br.readLine());
                    System.out.println("Server says: " + in.readUTF());
            }

        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Client c = new Client("localhost", 2022);
    }
}
