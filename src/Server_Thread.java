import java.net.*;
import java.io.*;

public class Server_Thread implements Runnable {

    Socket soc = null;

    public Server_Thread(Socket s){
        this.soc = s;
    }

    @Override
    public void run() {
        try {

            String str = null;  //Used to prevent errors while creating a new output thread

            InputStream sin = soc.getInputStream();
            DataInputStream sdis = new DataInputStream(sin);
            OutputStream sout = soc.getOutputStream();
            DataOutputStream sdos = new DataOutputStream(sout);

            (new Thread(new Server_Input(sdis))).start();
            (new Thread(new Server_Output(sdos, str))).start();     //may adjust later

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
