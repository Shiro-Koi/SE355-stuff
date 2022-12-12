import java.io.*;
import java.util.*;
import java.net.*;

public class ClientFour {
    public static void main(String[] args) throws IOException {
        // receiver node to accept election message from bully algorithm
        ServerSocket ss = new ServerSocket(8091);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = br.readLine();
        System.out.println(str);
        br.close();
        s.close();
        ss.close();

        // send election message to the next node
        Socket s1 = new Socket("localhost", 8092);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
        bw.write("Election message is sent from 4 to 5");
        bw.flush();
        bw.close();
        s1.close();
    }
}
