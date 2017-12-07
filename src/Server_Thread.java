import java.net.*;
import java.io.*;

/**
 * This program is the new thread that gets created for each client connected.
 * It creates all of the input and output streams, it creates a separate thread
 * for the server input.
 *
 * @author hurleyb5
 *
 */
public class Server_Thread extends Thread {

    Socket soc = null;
    String str = null;
    DataOutputStream sdos = null;

    public Server_Thread(Socket s){
        soc = s;
    }

    @Override
    public void run() {
        try {

            InputStream sin = soc.getInputStream();
            DataInputStream sdis = new DataInputStream(sin);
            OutputStream sout = soc.getOutputStream();
            sdos = new DataOutputStream(sout);

            Server_Input in = new Server_Input(sdis);
            in.start();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called by the Server_Input thread in order to send the newly received message
     * to each of the connected clients.
     *
     * @param s <i>(String)</i> Message outgoing from the server
     */
    public void rec_msg(String s){
        str = s;
        try {
            if (str != null) {
                sdos.writeUTF(str);
                str = null;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
