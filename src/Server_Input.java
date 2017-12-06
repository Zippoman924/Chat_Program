import java.io.*;

public class Server_Input extends Thread{

    DataInputStream dis = null;

    public Server_Input(DataInputStream d){       //May not be needed
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

    public void send_msg(String s){ //May need to be remade, must somehow access or send messaged to arraylist of threads in Chat_Server.java
        for(Server_Thread x : Chat_Server.t){
            x.rec_msg(s);
        }
    }

}
