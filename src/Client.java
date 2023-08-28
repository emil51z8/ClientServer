import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static int port = 2001;
    static String host = "localhost";
    static DataInputStream in;
    static DataOutputStream out;
    static Socket socket;

    public static void main(String[] args) {

        try {
            socket = new Socket(host, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            System.out.println("Indtast din besked her: ");
            Scanner input = new Scanner(System.in);


            try {
                String send = input.next();


                out.writeUTF(send);
                System.out.println(in.readUTF());


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
