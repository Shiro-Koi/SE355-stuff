import java.net.*;
import java.io.*;

public class Server {
    static Socket[] clients = new Socket[3];
    static int count;

    public static void main(String... args) {
        try {
            ServerSocket ss = new ServerSocket(2022);
            while (true) {
                Socket s = ss.accept();
                clients[count] = s;
                Thread client = new ClientHandler(s, count, clients);
                count++;
                client.start();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket s;
    private int count;
    private Socket[] clients;

    public ClientHandler(Socket s, int count, Socket[] clients) {
        this.s = s;
        this.count = count;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {

            while (true) {
                DataInputStream dio = new DataInputStream(s.getInputStream());
                int msg = dio.readInt();
                System.out.println("Receiving a msg from Client #" + count);
                DataOutputStream dos;
                //int dstId = 0;
                // for (int i = 0; i < clients.length; i++) {
                //     if (i != count) {
                //         Socket dst = clients[i];
                //         dos = new DataOutputStream(dst.getOutputStream());
                //         dos.writeInt(msg);
                //         dos.flush();
                //         System.out.println("Sending a msg to Client #" + dstId);
                //     }
                //     dstId++;
                // }

                if (count == 1) {
                    Socket dst = clients[0];
                    dos = new DataOutputStream(dst.getOutputStream());
                    dos.writeInt(msg);
                    dos.flush();
                    System.out.println("Sending a msg to Client #" + 0);
                }

                if (count == 0) {
                    Socket dst = clients[1];
                    dos = new DataOutputStream(dst.getOutputStream());
                    dos.writeInt(msg);
                    dos.flush();
                    System.out.println("Sending a msg to Client #" + 1);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
