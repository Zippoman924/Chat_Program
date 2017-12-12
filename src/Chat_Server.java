import java.net.*;
import java.io.*;
import java.util.ArrayList;

/**
 * This is a basic chat server that allows up to five clients to connect to eachother.
 * The server will facilitate the transfer of messages between each client. This creates
 * new threads for each client connection.
 *
 * @author hurleyb5
 *
 */
public class Chat_Server {

    static ArrayList<Server_Thread> t = new ArrayList<>();

    public static void main(String[]args) throws IOException{

        ServerSocket s = new ServerSocket(55535);

        while(true) {
            Socket s0 = s.accept();

            t.add(new Server_Thread(s0));
            t.get(t.size() - 1).start();
        }
    }
}
