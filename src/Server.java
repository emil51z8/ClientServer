import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static int port = 2001;
    static DataInputStream in;
    static DataOutputStream out;
    static ServerSocket server;
    static Socket socket;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            socket = server.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {

                String modtaget = in.readUTF();
                System.out.println("Besked modtaget: " + modtaget);

                out.writeUTF("Denne besked er modtaget: " + modtaget);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
