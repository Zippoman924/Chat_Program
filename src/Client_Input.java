import java.io.*;

/**
 * This class constantly check for new incoming strings for the client.
 * When a new message is received it is printed to the screen.
 *
 * @author hurleyb5
 *
 */
public class Client_Input extends Thread {

    DataInputStream dis = null;

    public Client_Input(DataInputStream d){
        dis = d;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(dis.readUTF());
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
