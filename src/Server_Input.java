import java.io.*;

public class Server_Input extends Thread{

    DataInputStream dis = null;

    public Server_Input(DataInputStream d){
        dis = d;
    }

    @Override
    public void run() {
        try{
            while(true){
                send_msg(dis.readUTF());
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void send_msg(String s){
        for(Server_Thread x : Chat_Server.t){
            x.rec_msg(s);
        }
    }

}
