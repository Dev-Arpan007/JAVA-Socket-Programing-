import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPServer {

    public static StringBuilder convertToStr(byte[] a){
        StringBuilder str = new StringBuilder();
        int i =0;
        while(a[i] != 0){
            str.append((char)a[i]);
            i++;
        }
        return str;
    }
    
    public static void main(String[] args) throws Exception{
        DatagramPacket dp1 = null;
        DatagramSocket ds1 = null;
        byte[] buf1 = new byte[65535];
        Scanner sc = new Scanner(System.in);
        InetAddress ip = InetAddress.getLocalHost();
        byte[] b2 = null;
        while (true) { 
            ds1 = new DatagramSocket(35000);
            System.out.println("Server is waiting");
            DatagramPacket dp2 = new DatagramPacket(buf1, buf1.length);
            ds1.receive(dp2);

            StringBuilder recMsg = new StringBuilder("");
            recMsg = convertToStr(buf1);
            System.out.println("Message from Client: " + recMsg);

            System.out.println("Enter your message: ");
            String m = sc.next();
            b2 = m.getBytes();
            
            
            dp1 = new DatagramPacket(b2, b2.length,ip,dp2.getPort() );
            ds1.send(dp1);

           

            

            if(recMsg.equals("bye")) break;
        }



        

    }
}
