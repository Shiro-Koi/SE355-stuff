import java.io.*;
import java.util.*;
import java.net.*;

public class ClientSix {
    public static void main(String[] args) throws IOException {
        // receiver node to accept election message from bully algorithm
        ServerSocket ss = new ServerSocket(8092);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = br.readLine();
        System.out.println(str);
        br.close();
        s.close();
        ss.close();
    }
}
