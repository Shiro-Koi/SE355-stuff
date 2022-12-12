import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 2022);

            Thread writeThread = new writeThreadHandler2(s);
            writeThread.start();
            Thread readThread = new readThreadHandler2(s);
            readThread.start();
        } catch (Exception e) {
            System.err.println(e);
        } 
    }
}

class readThreadHandler2 extends Thread {

    Socket s;

    public readThreadHandler2(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println("Client2 says: " + dis.readInt());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

class writeThreadHandler2 extends Thread {

    Socket s;
    Scanner sc = new Scanner(System.in);

    public writeThreadHandler2(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                System.out.print("please write a message: ");
                dout.writeInt(sc.nextInt());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}