import java.net.*;
import java.io.*;

public class Client {

    public Client(String address, int port) {
        try {
            Socket s = new Socket(address, port);
            Socket s2 = new Socket(address, port);
            System.out.println("Connected to server!");

            Thread writeThread = new writeThreadHandler(s);
            writeThread.start();
            Thread readThread = new readThreadHandler(s2);
            readThread.start();

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void main(String[] args) {
        Client client = new Client("localhost", 2022);
    }
}

class readThreadHandler extends Thread {

    Socket s;

    public readThreadHandler(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println("Server: " + dis.readUTF());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

class writeThreadHandler extends Thread {

    Socket s;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public writeThreadHandler(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF(br.readLine());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}