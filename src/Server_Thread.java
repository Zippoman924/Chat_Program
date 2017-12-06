import java.net.*;
import java.io.*;

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
