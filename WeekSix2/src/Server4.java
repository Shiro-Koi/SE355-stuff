import java.io.*;
import java.net.*;

public class Server4 { // C

    public Server4() {
        String[] ll = new String[10000];
        try {
            ServerSocket ss = new ServerSocket(4000); // C
            int counter = 0;
            int loopCounter = 0;
            int printCounter = 0;

            while (1 == 1) {
                Socket s1 = ss.accept();
                DataInputStream in = new DataInputStream(s1.getInputStream()); // input from terminal
                ll[counter++] = in.readUTF(); // store the input in an array

                for (int j = 0; j < ll.length; j++) { // loop through the array
                    try {
                        if (ll[j].equals(null)) { // if the array is empty
                            break;
                        }
                    } catch (Exception e) {
                        break;
                    }
                    loopCounter++;
                }
                printCounter++;
                if (printCounter == 2) {
                    System.out.println("LinkedList: ");
                    for (int i = 0; i < loopCounter; i = i + 2) {
                        if (ll[i] != null) {
                            System.out.println(ll[i]);
                        }
                    }
                    printCounter = 0;
                }
                loopCounter = 0;
            }

        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        Server4 s = new Server4();
    }
}