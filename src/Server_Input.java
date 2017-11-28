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
                String str = dis.readUTF();

                System.out.println(str);

                //do stuff with string(print to screen)

            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
