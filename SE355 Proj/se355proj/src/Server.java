import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
    static int clientCounter = 0; // client counter
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2000);
            Random r = new Random();
            int randomInt = r.nextInt(100 - 1) + 1;
            int[] client = new int[3]; // client guesses number
            int nodeCounter = 0; // number of clients
            System.out.println(randomInt);
            while (true) {
                try {
                    int guessCounter = 0;
                    Socket clientSocket = new Socket("localhost", 2001 + (nodeCounter++ % 2));
                    Thread t = new ClientHandler(clientSocket, randomInt, client, guessCounter, clientCounter++);
                    t.start();
                } catch (Exception e) {
                    continue;
                }
            } 
        } catch (Exception e) {
            //System.out.println(e);
        }
    }
}

class ClientHandler extends Thread {
    Socket s = null;
    int randomInt;
    int guessCounter;
    int[] client = new int[3];
    int clientCounter;

    public ClientHandler(Socket s, int randomInt, int[] client, int guessCounter, int clientCounter) {
        this.s = s;
        this.randomInt = randomInt;
        this.client = client;
        this.guessCounter = guessCounter;
        this.clientCounter = clientCounter;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Pick a number between 1-100. You have 5 tries.");
            String sa3a;
            while (true) {
                int guess = dis.readInt();
                guessCounter++;
                if (guess == randomInt) {
                    dos.writeUTF("You won");
                    dos.writeInt(-1);
                    sa3a = dis.readUTF();
                    System.out.println(sa3a);
                    break;
                } else {
                    if (guess > randomInt) {
                        dos.writeUTF("Guess lower");
                    } else {
                        dos.writeUTF("Guess higher");
                    }
                    dos.writeInt(-3);
                    System.out.println("WRONG!");
                }
            }
            dos.writeUTF(sa3a);                      

        } catch (Exception e) {
        }
    }
}