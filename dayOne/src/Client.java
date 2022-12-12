import java.net.*;
import java.io.*;

// public class Client {

//     public static void main(String[] args) throws Exception {
//         // Socket socket = new Socket("google.com", 443);
//         // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//         // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//         // BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//         // String line = null;
//         // while ((line = keyboard.readLine()) != null) {
//         //     out.println(line);
//         //     System.out.println(in.readLine());
//         // }
//         Main();
//     }

//     public static void Main() {
//         try {
//             Socket socket = new Socket("google.com", 443); // TCP connection - send or receive data
//             DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
//             dout.writeUTF("Hello Server");
//             dout.writeUTF("Sa3a");
//             dout.writeUTF("is");
//             dout.writeUTF("the");
//             dout.writeUTF("best");
//             dout.writeUTF("teacher");
//             dout.writeUTF("ever");
//             dout.writeUTF("end");
//             dout.flush();
//             dout.close();
//             socket.close();
//             // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//             // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//             // BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//             // String line = null;
//             // while ((line = keyboard.readLine()) != null) {
//             //     out.println(line);
//             //     System.out.println(in.readLine());
//             // }
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
    
// }

public class Client {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(i);

            }
            throw new Exception();
        } catch (Exception e) {

        }
    }
}