import java.net.*;
import java.io.*;

public class ServerMulti {
    static Socket[] clients = new Socket[3];
    static int count;

    public static void main(String... args) {
        try {
            try (ServerSocket ss = new ServerSocket(2022)) {
                while (true) {
                    Socket s = ss.accept();
                    clients[count] = s;
                    Thread client = new ClientHandler(s, count, clients);
                    count++;
                    client.start();
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket s;
    private int id;
    private Socket[] clients;

    public ClientHandler(Socket s, int id, Socket[] clients) {
        this.s = s;
        this.id = id;
        this.clients = clients;
    }

    @Override
	public void run(){
		try{
			DataInputStream dio = new DataInputStream(s.getInputStream());

			while(true){
				String msg = dio.readUTF();
				System.out.println("Receiving a msg from Client #" + id);
				DataOutputStream dos ;
				//id; //my
				for(int i = 0; i < clients.length; i++){
					// if(i == id)
						// continue;
					Socket dstClient = clients[i];
					dos = new DataOutputStream(dstClient.getOutputStream());
					dos.writeUTF(msg);
					dos.flush();
					System.out.println("Forwarding the msg to Client #" + i);
				}
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}