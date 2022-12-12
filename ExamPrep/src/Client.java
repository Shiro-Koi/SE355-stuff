import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2020);
            System.out.println("Connected to server.");
            Scanner in = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            while (1==1) {
                System.out.print("Enter a message: ");
                dos.writeUTF(in.nextLine());
                System.out.println("Server says: " + dis.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
