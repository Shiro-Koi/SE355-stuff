import java.io.*;
import java.net.*;

public class UDP {

    // udp multicast example
    // public static void main(String[] args) {
    //     try {
    //         MulticastSocket socket = new MulticastSocket(4446);
    //         InetAddress group = InetAddress.getByName("");
    //         socket.joinGroup(group);
    //         byte[] buf = new byte[256];
    //         DatagramPacket packet = new DatagramPacket(buf, buf.length);
    //         socket.receive(packet);
    //         String received = new String(packet.getData(), 0, packet.getLength());
    //         System.out.println("Quote of the Moment: " + received);
    //         socket.leaveGroup(group);
    //         socket.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    // udp send example
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(); // create a socket
            InetAddress address = InetAddress.getByName("127.0.0.1"); // get the address of the server
            byte[] buf = "Hello, World!".getBytes(); // get the bytes of the message
            int port = 433; // get the port of the server
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port); // create a packet
            socket.send(packet); // send the packet
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // udp receive example
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(433);
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Quote of the Moment: " + received);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // udp broadcast example
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);
            InetAddress address = InetAddress.getByName("255.255.255.255");
            int port = 4445;
            byte[] buf = "Hello, World!".getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
