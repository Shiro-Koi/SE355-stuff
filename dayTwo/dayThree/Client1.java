import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) throws IOException {
        // Socket s = new Socket("localhost", 6666);
        // InputStream in = s.getInputStream(); // read
        // OutputStream out = s.getOutputStream(); // write
        // byte n = 2;
        // byte[] arr = new byte[1];
        // arr[0] = n;
        // out.write(arr[0]);
        
        Socket s = new Socket("localhost", 6666);
        OutputStream out = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(100);
        dos.writeInt(200);
        dos.writeInt(300);
        dos.flush();

        OutputStream out1 = s.getOutputStream();
        //BufferedOutputStream bos = new BufferedOutputStream(out1);
        DataOutputStream dos2 = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
        dos2.writeInt(100);
        dos2.writeInt(200);
        dos2.writeInt(300);
        dos2.flush();

        // Socket s = new Socket("localhost", 6666);
        // OutputStream out = s.getOutputStream();
        // DataOutputStream dos = new DataOutputStream(out);
        // dos.writeInt(100);
        // dos.writeInt(200);
        // dos.writeInt(300);
        // dos.flush();

        // OutputStream out1 = s.getOutputStream();
        // DataOutputStream dos2 = new DataOutputStream(out1);
        // BufferedOutputStream bos = new BufferedOutputStream(dos2);
        // dos2.writeInt(100);
        // dos2.writeInt(200);
        // dos2.writeInt(300);
        // dos2.flush();
    }
}