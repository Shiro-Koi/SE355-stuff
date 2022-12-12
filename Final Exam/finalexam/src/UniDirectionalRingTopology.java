import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class UniDirectionalRingTopology {

    private static final int PORT = 1234;
    private static final int NUM_SOCKETS = 5;

    private List<Socket> sockets;

    public UniDirectionalRingTopology() {
        sockets = new ArrayList<>();
    }

    public void start() {
        try {
            // Create a server socket for each node in the ring
            for (int i = 0; i < NUM_SOCKETS; i++) {
                ServerSocket serverSocket = new ServerSocket(PORT + i);
                Socket socket = serverSocket.accept();
                sockets.add(socket);
                System.out.println("Node " + i + " connected");
            }

            // Connect each node to the next node in the ring
            for (int i = 0; i < NUM_SOCKETS; i++) {
                Socket socket = sockets.get(i);
                Socket nextSocket = sockets.get((i + 1) % NUM_SOCKETS);
                socket.connect(nextSocket.getRemoteSocketAddress());
            }

            // Start a thread to handle messages for each node in the ring
            for (int i = 0; i < NUM_SOCKETS; i++) {
                Socket socket = sockets.get(i);
                Thread thread = new Thread(new MessageHandler(socket, i));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MessageHandler implements Runnable {

        private Socket socket;
        private int nodeId;

        public MessageHandler(Socket socket, int nodeId) {
            this.socket = socket;
            this.nodeId = nodeId;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    String message = in.readLine();
                    System.out.println("Node " + nodeId + " received message: " + message);
                    out.println("Node " + nodeId + " received message: " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}