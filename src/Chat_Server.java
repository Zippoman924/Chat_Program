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
            Socket s0 = s.accept(); //Wait for connection, possibly call a function to create a new socket for each client(create thread)?
            client_hand(s0);
        }


        /*
        while(true){
            //forward messages
            String str0 = s0dis.readUTF();
            String str1 = s1dis.readUTF();

            if(str0.equals("exit") || str1.equals("exit")){
                break;
            }

            else {
                s0dos.writeUTF(str1);
                s1dos.writeUTF(str0);
            }
        } */
    }

    /**
     * This method handles each new connecting client by creating a new thread to handle all of their needs.
     *
     * @param s <i>(Socket)</i> New connecting client
     */
    public static void client_hand(Socket s){
        (new Thread(new Server_Thread(s))).start();
    }

}
