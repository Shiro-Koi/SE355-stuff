import java.net.*;
import java.io.*;

public class Serverc {
    static Socket[] clients = new Socket[5];
    static int count;

    public static void main(String... args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            while (true) {
                Socket s = ss.accept();
                clients[count] = s;
                Thread client = new ClientHandler(s, count++, clients);
                client.start();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket s;
    private int id;
    private Socket[] clients;

    public ClientHandler(Socket s, int id, Socket[] clients) {
        this.s = s;
        this.id = id;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            DataInputStream dio = new DataInputStream(s.getInputStream());

            while (true) {
                String msg = dio.readUTF();
                System.out.println("Receiving a msg from Client #" + id);
                DataOutputStream dos;

                for (int i = 0; i < clients.length; i++) {
                    if (s.equals(clients[i])) {
                        int modulo = (i + 1) % 5; // 0, 1, 2, 3, 4
                        System.out.println(modulo);
                        dos = new DataOutputStream(clients[modulo].getOutputStream());
                        System.out.println("the array" + clients[modulo] + i);

                        dos.writeUTF(msg);
                        dos.flush();

                        dos = new DataOutputStream(clients[modulo + 1].getOutputStream());
                        System.out.println("the array" + clients[modulo] + i);

                        dos.writeUTF(msg);
                        dos.flush();
                    }

                }
            }

        } catch (

        Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
