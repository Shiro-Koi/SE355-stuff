import java.net.*;
import java.io.*;

public class Server {

    public Server(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server is running...");
            Socket s = ss.accept();
            Socket s2 = ss.accept();
            System.out.println("Client connected!");

            Thread readThread = new readThreadHandler(s);
            readThread.start();
            Thread writeThread = new writeThreadHandler(s2);
            writeThread.start();

        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public static void main(String[] args) {
        Server server = new Server(2022);
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
                System.out.println("Client: " + dis.readUTF());
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