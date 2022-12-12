package test;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 2022);

            readThreadHandler readThread = new readThreadHandler(s);
            readThread.start();
            writeThreadHandler writeThread = new writeThreadHandler(s);
            writeThread.start();

            // while (true) {
            //     for (int i = 0; i < 5; i++) {
            //         System.out.println(dis.readUTF());
            //     }
            //     System.out.println("please write a message");
            //     dout.writeUTF(sc.nextLine());
            // }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class readThreadHandler extends Thread {

    Socket s;
    //DataInputStream dis;

    public readThreadHandler(Socket s, DataInputStream dis) {
        this.s = s;
    }
    @Override
    public void run() {
        try  {
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println("Client2 says: " + dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class writeThreadHandler extends Thread {

    Socket s;
    //DataOutputStream dos;

    public writeThreadHandler(Socket s, DataOutputStream dos) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.println("please write a message");
            dout.writeUTF(new Scanner(System.in).nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
