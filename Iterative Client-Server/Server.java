import java.io.*;
import java.net.*;

public class Server {

    private ServerSocket ss = null;
    private Socket s = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;

    public Server(int port){
        try {
            ss = new ServerSocket(port);
            while(true){
                System.out.println("Server is waiting for client...");
                 s = ss.accept();
                 String hostAddress = s.getInetAddress().getHostAddress();
                 int port1 = s.getPort();

                 System.err.println("Hostadress: "+ hostAddress + "\nHost-Port: " + port1);
                 dis = new DataInputStream(s.getInputStream());
                 dos = new DataOutputStream(s.getOutputStream());
                 String clientMsg = dis.readUTF();
                 System.out.println("Message from client: " + clientMsg);
                 dos.writeUTF("Hello from Server");
                 dos.close();
                 dis.close();
                 s.close();


            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        

    }

    public static void main(String[] args) {
        Server serv = new Server(35000);


    }
}
