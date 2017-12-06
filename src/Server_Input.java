import java.io.*;

public class Server_Input implements Runnable {

    DataInputStream dis = null;

    public Server_Input(DataInputStream d){
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
