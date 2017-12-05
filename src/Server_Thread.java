import java.net.*;
import java.io.*;

public class Server_Thread implements Runnable {

    Socket soc = null;
    String str = "";  //Used to prevent errors while creating a new output thread
    String in = null;

    public Server_Thread(Socket s){
        soc = s;
    }

    @Override
    public void run() {     //Must adjust in order to make this functional and completely handle each client
        try {

            InputStream sin = soc.getInputStream();
            DataInputStream sdis = new DataInputStream(sin);
            OutputStream sout = soc.getOutputStream();
            DataOutputStream sdos = new DataOutputStream(sout);

            while(true){

                in = sdis.readUTF();        //Messages from the client

                if(in!=null && in!=""){     //may need to adjust this
                    send_msg(in);
                    in = null;
                }
                if(rec_msg()==null || rec_msg().equals(str)){       //This may not be needed
                    sdos.writeUTF(rec_msg());
                }
            }

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        //catch(NullPointerException e){
            //do something
        //}
    }

    public void send_msg(String s){ //Needs to be remade, must somehow access or send messaged to arraylist of threads in Chat_Server.java
        //synchronized (str){
            this.str = s;
        //}
    }

    public String rec_msg(){    //May need to be rewritten as well
        //synchronized (str){
            return this.str;
        //}
    }

}
