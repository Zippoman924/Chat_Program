import java.io.*;

/**
 * This thread takes the DataInputStream as an input in the constructor and
 * constantly checks the InputStream for new strings.
 *
 * @author hurleyb5
 *
 */
public class Server_Input extends Thread{

    DataInputStream dis = null;

    public Server_Input(DataInputStream d){
        dis = d;
    }

    @Override
    public void run() {
        try{
            while(true){
                send_msg(dis.readUTF());
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method sends the String s to each instance of the Server_Thread class
     * in an ArrayList that was created in the Chat_Server class.
     *
     * @param s <i>(String)</i> Message to be sent to each Server_Thread instance.
     */
    public void send_msg(String s){
        for(Server_Thread x : Chat_Server.t){
            x.rec_msg(s);
        }
    }

}
