import java.io.*;

public class Server_Output implements Runnable{

    DataOutputStream dos = null;
    String str = null;

    public Server_Output(DataOutputStream d, String s){     //May need to adjust later, possibly sending data does not need a thread, use on an on action in javafx
        dos = d;
        str = s;
    }

    @Override
    public void run() {
        try{
            while(true){
                dos.writeUTF(str);      //may need to add more later
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
