import java.io.*;
import java.net.*;

public class Serverr4 { // C

    public Serverr4() {
        String[] ll = new String[10000];
        try {
            ServerSocket ss = new ServerSocket(4000); // C
            int counter = 0;
            int loopCounter = 0;
            int printCounter = 0;

            while (1 == 1) {
                Socket s1 = ss.accept();
                DataInputStream in = new DataInputStream(s1.getInputStream()); // input from terminal
                ll[counter++] = in.readUTF();

                for (int j = 0; j < ll.length; j++) {
                    try {
                        if (ll[j].equals(null)) {
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
        Serverr4 s = new Serverr4();
    }
}
