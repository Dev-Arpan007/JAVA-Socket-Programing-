
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client{

    private Socket s = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    private String msg = null;
    
    public Client(String m, int port){
        this.msg = m;
        try {
            s = new Socket("127.0.0.1", 35000);
            dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(m);
            dis = new DataInputStream(s.getInputStream());
            String mymsg = dis.readUTF();
            System.out.println("Message from Server: " + mymsg);
            s.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            System.out.println("Error Occured in Client Side\n" + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int ch;
        while(flag == true){
            String m = null;
            System.out.println("Enter your message: ");
            m = sc.next();
            Client c = new Client(m, 35000);

            System.out.println("Do you want to make another Client\n1->Yes\t2->No: ");
            ch = sc.nextInt();
            if(ch == 2) flag = false;

        }
        

        
    }
}