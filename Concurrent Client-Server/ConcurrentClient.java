import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ConcurrentClient{

    private Socket s = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    String m = null;

    public ConcurrentClient(String msg, int port){
        this.m = msg;
        try {
            s = new Socket("127.0.0.1",port);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            String mymsg;
            dos.writeUTF(m);
            mymsg = dis.readUTF();
            System.out.println("Message from Server" + mymsg);

        } catch (Exception e) {
            System.out.println(e);
        }
        

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your message: ");   
        String m = sc.next();

        ConcurrentClient c1 = new ConcurrentClient(m, 35000);

    }
}