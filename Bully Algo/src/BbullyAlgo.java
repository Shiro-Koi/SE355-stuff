import java.net.*;
import java.io.*;
import java.util.*;

public class BbullyAlgo {
    // Implementing Bully Algorithm with sockets
    static int n, co, j;
    static ArrayList<Integer> process = new ArrayList<Integer>();
    static ArrayList<String> status = new ArrayList<String>();
    static ArrayList<Integer> port = new ArrayList<Integer>();
    static ArrayList<String> ip = new ArrayList<String>();
    static ArrayList<Socket> socket = new ArrayList<Socket>();
    static ArrayList<PrintWriter> out = new ArrayList<PrintWriter>();
    static ArrayList<BufferedReader> in = new ArrayList<BufferedReader>();
    static ArrayList<Thread> thread = new ArrayList<Thread>();
    static ArrayList<Boolean> active = new ArrayList<Boolean>();
    static ArrayList<Boolean> election = new ArrayList<Boolean>();
    static ArrayList<Boolean> coordinator = new ArrayList<Boolean>();
    static ArrayList<Boolean> electionDone = new ArrayList<Boolean>();

    BbullyAlgo() {
        n = 0;
        co = 0;
    }

    static void findCoordinator(int x) { // x is the initiator process
        x = x - 1;
        co = x + 1;
        for (int i = 0; i < n; i++) { // for all processes
            if (process.get(x) < process.get(i)) { // if process x has lower priority than process i
                System.out.println("Election message is sent from " + (x + 1) + " to " + (i + 1));
                if (status.get(i) == "yes") // if process i is active
                    findCoordinator(i + 1);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        System.out.println("Enter the number of process:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("For process " + (i + 1) + ":");
            System.out.println("Active Status: (yes/no)");
            status.add(sc.next());
            System.out.println("Priority: (0-10)");
            process.add(sc.nextInt());
            System.out.println("Port:");
            port.add(sc.nextInt());
            System.out.println("IP:");
            ip.add(sc.next());
            active.add(false);
            election.add(false);
            coordinator.add(false);
            electionDone.add(false);
        }
        
        System.out.println("Which process will initiate election:");
        findCoordinator(sc.nextInt());
        System.out.println("Final Co-Ordinator: " + co);
        sc.close();

        for (j = 0; j < n; j++) {
            socket.add(new Socket(ip.get(j), port.get(j)));
            out.add(new PrintWriter(socket.get(j).getOutputStream(), true));
            in.add(new BufferedReader(new InputStreamReader(socket.get(j).getInputStream())));
            Thread t = new BullyThread(j);
            thread.add(t);
            t.start();
        }
    }

}

class BullyThread extends Thread {
    int j;
    BullyThread(int j) {
        this.j = j;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String inputLine;
                while ((inputLine = BbullyAlgo.in.get(j).readLine()) != null) {
                    if (inputLine.equals("election")) {
                        System.out.println("Election message received from " + (j + 1));
                        BbullyAlgo.election.set(j, true);
                        if (BbullyAlgo.coordinator.get(j)) {
                            System.out.println("I am the coordinator");
                            BbullyAlgo.out.get(j).println("coordinator");
                            BbullyAlgo.coordinator.set(j, false);
                        } else {
                            System.out.println("I am not the coordinator");
                            BbullyAlgo.out.get(j).println("notCoordinator");
                        }
                    } else if (inputLine.equals("coordinator")) {
                        System.out.println("Coordinator message received from " + (j + 1));
                        BbullyAlgo.coordinator.set(j, true);
                        BbullyAlgo.election.set(j, false);
                        BbullyAlgo.electionDone.set(j, true);

                    } else if (inputLine.equals("notCoordinator")) {
                        System.out.println("Not Coordinator message received from " + (j + 1));
                        BbullyAlgo.election.set(j, false);
                        BbullyAlgo.electionDone.set(j, true);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + BbullyAlgo.port.get(j)
                    + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
