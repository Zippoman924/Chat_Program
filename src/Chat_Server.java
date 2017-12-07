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

        /*
        Possible idea, may pass pointer to arraylist t to each thread on creation(if unable to pass pointer then I may just send a copy of the arraylist
        each time it gets updated in order to keep all threads up to date). This will allow each thread to independently go through the arraylist
        and call a method on each thread that sends a newly received message on that thread to all other threads. Those threads will then send
        this message to the client associated with that specific thread.(Must make sure that this is thread safe)

        May be able to use synchronize or volatile tags on variables in threads.

        Maybe use a blocking thread which is a synchronous queue.
        */

        while(true) {
            Socket s0 = s.accept();

            t.add(new Server_Thread(s0));
            t.get(t.size() - 1).start();
        }
    }
}
