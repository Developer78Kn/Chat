/* ChatServer 2021-04-10-1_Halozat_Port_Socket_Chat.mp4 00:23:50 */
package chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author Zsolt Ollé
 */
public class ChatServer {

    private static Vector<KliensKapcsolat> kliensek;
    
    public static void main(String[] args) {
        try {
            kliensek = new Vector<>();
            System.out.println("Várunk egy kliens kapcsolatra...");
            ServerSocket ss = new ServerSocket(8888);
            
            do {                
                Socket socket = ss.accept(); // megállítja a végrehajtást amig nem kap kapcsolódást
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientName = br.readLine();
                System.out.println(clientName+ " kliens kapcsolódása megtörtént");
                
                KliensKapcsolat kk = new KliensKapcsolat(clientName, socket);
                kliensek.add(kk);
                
                OlvasoSzal osz = new OlvasoSzal(kk, kliensek);
                osz.start();
                
            } while (true);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    
}
