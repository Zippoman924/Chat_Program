import java.io.*;

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
