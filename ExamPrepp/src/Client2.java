import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 2022);

            Thread readThread = new readThreadHandler(s);
            readThread.start();
            Thread writeThread = new writeThreadHandler(s);
            writeThread.start();

            // while (true) {
            //     for (int i = 0; i < 5; i++) {
            //         System.out.println(dis.readUTF());
            //     }
            //     System.out.println("please write a message");
            //     dout.writeUTF(sc.nextLine());
            // }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

class readThreadHandler extends Thread {

    Socket s;

    public readThreadHandler(Socket s) {
        this.s = s;
    }
    @Override
    public void run() {
        try  {
            while(true) {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println("Client1 says: " + dis.readInt());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

class writeThreadHandler extends Thread {

    Socket s;
    Scanner sc = new Scanner(System.in);

    public writeThreadHandler(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while(true) {
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                System.out.print("please write a message: ");
                dout.writeInt(sc.nextInt());
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
