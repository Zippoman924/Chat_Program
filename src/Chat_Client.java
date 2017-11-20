import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * This is a basic chat client that will connect to a server in order to send messages to other client that are connected to the same server.
 *
 * @author hurleyb5
 *
 */
public class Chat_Client {
    public static void main(String[]args) throws IOException{

        /*Threads will eventually be added in order to allow for the ability to simultaneously send and receive messages
        from the server.
         */

        Scanner key = new Scanner(System.in);

        Socket s0 = new Socket("127.0.0.1", 55535);//Will change IP address during final test phase

        InputStream s0in = s0.getInputStream();
        DataInputStream s0dis = new DataInputStream(s0in);
        OutputStream s0out = s0.getOutputStream();
        DataOutputStream s0dos = new DataOutputStream(s0out);

        System.out.println("Please enter a username: ");
        String usr = key.next();

        while (true){

            System.out.println("Enter exit to close connection.");
            System.out.println("Please enter a message: ");
            StringBuilder str = new StringBuilder(usr + ":" + key.next());

            if(str.toString().equals(usr + ":exit")){
                s0dos.writeUTF("exit");
                break;
            }
            else{
                s0dos.writeUTF(str.toString());

                System.out.println(s0dis.readUTF());
            }
        }

        s0dos.close();
        s0out.close();
        s0dis.close();
        s0in.close();
        s0.close();
    }
}
