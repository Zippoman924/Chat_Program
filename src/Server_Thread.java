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

            InputStream sin = soc.getInputStream();
            DataInputStream sdis = new DataInputStream(sin);
            OutputStream sout = soc.getOutputStream();
            DataOutputStream sdos = new DataOutputStream(sout);

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
