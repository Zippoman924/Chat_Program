import java.net.*;
import java.io.*;

public class Server_Thread implements Runnable {

    Socket soc = null;
    String str = null;  //Used to prevent errors while creating a new output thread
    String in = null;

    public Server_Thread(Socket s){
        this.soc = s;
    }

    @Override
    public void run() {     //Must adjust in order to make this functional and completely handle each client
        try {

            InputStream sin = soc.getInputStream();
            DataInputStream sdis = new DataInputStream(sin);
            OutputStream sout = soc.getOutputStream();
            DataOutputStream sdos = new DataOutputStream(sout);

            while(true){
                if(!in.equals(null)){
                    send_msg(in);
                    in = null;
                }
                if(!rec_msg().isEmpty() || !rec_msg().equals(str)){
                    rec_msg();
                }
            }

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void send_msg(String s){ //Needs testing, should be able to send messages between threads
        synchronized (str){
            this.str = s;
        }
    }

    public String rec_msg(){    //Needs testing, should be able to recieve messages from other threads
        synchronized (str){
            return this.str;
        }
    }

}
