import java.net.*;
import java.io.*;

public class Chat_Server {
    public static void main(String[]args) throws IOException{

        /*For now the server can only manualy accept connections from two clients at a time.
        From there the server will send the messages between each client, research will need to be done into
        threads in order to properly facilitate the creation of each socket and handle each of them differently.
        This will allow for the ability to simultaneously send and receive messages from other clients.
         */

        //Client 0
        ServerSocket s = new ServerSocket(55535);
        Socket s0 = s.accept(); //Wait for connection, possibly call a function to create a new socket for each client?

        InputStream s0in = s0.getInputStream();
        DataInputStream s0dis = new DataInputStream(s0in);
        OutputStream s0out = s0.getOutputStream();
        DataOutputStream s0dos = new DataOutputStream(s0out);

        //Client 1
        ServerSocket ss = new ServerSocket(55535);
        Socket s1 = ss.accept(); //Wait for connection, possibly call a function to create a new socket for each client?

        InputStream s1in = s1.getInputStream();
        DataInputStream s1dis = new DataInputStream(s1in);
        OutputStream s1out = s1.getOutputStream();
        DataOutputStream s1dos = new DataOutputStream(s1out);

        //type here

        s0in.close();   //May add these all to some sort of method in each thread to close all
        s0dis.close();
        s0dos.close();
        s0out.close();
        s0.close();
        s.close();
        s1in.close();
        s1dis.close();
        s1dos.close();
        s1out.close();
        s1.close();
        ss.close();

    }
}
