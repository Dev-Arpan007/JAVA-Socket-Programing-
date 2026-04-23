import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;


public class ConcurrentServer {

    private ServerSocket ss = null;
    private Socket s = null;
    
    public ConcurrentServer(int port){
        
        try {
            ss = new ServerSocket(port);
            while (true) { 
                s = ss.accept(); 
                new ClientHandler(s).start();
                s.close();
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        ConcurrentServer server1 = new ConcurrentServer(35000);
    }
}



class ClientHandler extends Thread{

    private Socket s = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    public ClientHandler(Socket s){
        this.s = s;
        try {
            dis = new DataInputStream(s.getInputStream());
            String hostAddress = s.getInetAddress().getHostAddress();
            int port1 = s.getPort();
            System.out.println("Host Address: " + hostAddress + " Port: " + port1);
            String msg = dis.readUTF();
            System.out.println("Message From Client: " + msg);
            dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Hello from server");
            dis.close();
            dos.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
