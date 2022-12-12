import java.io.*;
import java.net.*;
import java.util.*;

public class ClientOne {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2001);
            Scanner sc = new Scanner(System.in);
            int counter = 0;
            int tr = 0;
            while (true) {
                try {
                    Socket s = ss.accept();
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    System.out.println(dis.readUTF());
                    while (true) {
                        System.out.println("guess a number");
                        int guess = sc.nextInt();
                        dos.writeInt(guess);
                        counter++;
                        System.out.println(dis.readUTF());
                        tr = dis.readInt();
                        if (tr == -2) {
                            System.out.println(dis.readUTF());
                            break;
                        }
                        if (tr == -1){
                            dos.writeUTF("Client 1 Won!"); // send to server
                            return;
                        }
                    }

                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
