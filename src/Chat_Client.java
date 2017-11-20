import java.net.*;
import java.io.*;

public class Chat_Client {
    public static void main(String[]args) throws IOException{

        /*Threads will eventually be added in order to allow for the ability to simultaneously send and receive messages
        from the server.
         */
        Socket s0 = new Socket("127.0.0.1", 55535);//Will change IP address during final test phase

        InputStream s0in = s0.getInputStream();
        DataInputStream s0dis = new DataInputStream(s0in);
        OutputStream s0out = s0.getOutputStream();
        DataOutputStream s0dos = new DataOutputStream(s0out);

        //type here

        s0dos.close();
        s0out.close();
        s0dis.close();
        s0in.close();
        s0.close();
    }
}
