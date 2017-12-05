import java.net.*;
import java.io.*;
import java.util.ArrayList;

/**
 * This is a basic chat server that allows up to five clients to connect to eachother.
 * The server will facilitate the transfer of messages between each client.
 *
 * @author hurleyb5
 *
 */
public class Chat_Server {
    public static void main(String[]args) throws IOException{       //Must create 5 named thread variables and store them in an array to use them.

        ServerSocket s = new ServerSocket(55535);

        ArrayList<Thread> t = new ArrayList<>();

        while(true) {
            Socket s0 = s.accept();

            t.add(new Thread(new Server_Thread(s0)));       //Add thread to arraylist
            t.get(t.size()-1).start();                        //Start newly added thread

            for(int i=0;i<t.size();i++){                    //Loop through arraylist to look for and send new messages
                //type
            }
        }
    }
}
