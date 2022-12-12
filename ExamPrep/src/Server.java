import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            ServerSocket ss = new ServerSocket(2020);
            System.out.println("Waiting for connection...");
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            while (1==1) {
                System.out.println("Client says: " + dis.readUTF());
                System.out.print("Enter a message: ");
                dos.writeUTF(in.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
