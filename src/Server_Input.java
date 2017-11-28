import java.io.*;
import java.net.*;

public class Server_Input implements Runnable {

    DataInputStream dis = null;

    public Server_Input(DataInputStream d){
        dis = d;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = dis.readUTF();

                //do stuff with string

            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
