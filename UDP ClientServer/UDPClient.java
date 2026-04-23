import java.net.*;
import java.util.Scanner;

public class UDPClient {

    public static StringBuilder convertToStr(byte[] a){
        StringBuilder str = new StringBuilder();
        int i =0;
        while(a[i] != 0){
            str.append((char)a[i]);
            i++;
        }
        return str;
    }
    
    public static void main(String[] args) throws Exception {
        DatagramPacket dp = null;
        DatagramSocket ds = null;
        byte[] buf = null;
        Scanner sc = new Scanner(System.in);
        InetAddress ip = InetAddress.getLocalHost();
        byte[] b = new byte[65535];
        while (true) { 
            System.out.println("Enter your message: ");
            String m = sc.next();
            buf = m.getBytes();
            
            ds = new DatagramSocket();
            dp = new DatagramPacket(buf, buf.length,ip,35000 );
            ds.send(dp);

            DatagramPacket dp1 = new DatagramPacket(b, b.length);
            ds.receive(dp1);

            StringBuilder recMsg = new StringBuilder("");
            recMsg = convertToStr(b);
            System.out.println("Message from Server: " + recMsg);

            

            if(m.equals("bye")) break;
        }



    }
}
