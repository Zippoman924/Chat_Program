import java.net.*;
import java.io.*;

/**
 * This is a basic chat server that allows up to five clients to connect to eachother.
 * The server will facilitate the transfer of messages between each client.
 *
 * @author hurleyb5
 *
 */
public class Chat_Server {
    public static void main(String[]args) throws IOException{

        ServerSocket s = new ServerSocket(55535);

        while(true) {
            Socket s0 = s.accept();
            client_hand(s0);
        }
    }

    /**
     * This method handles each new connecting client by creating a new thread to handle all of their needs.
     *
     * @param s <i>(Socket)</i> New connecting client
     */
    public static void client_hand(Socket s){
        new Thread(new Server_Thread(s)).start();
    }

}
