/* ChatClient 2021-04-10-2_SocketChat_SwingKartya.mp4 00:20:00*/
package chatclient;

import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author Zsolt Ollé
 */
public class OlvasoSzal extends Thread{
    
   private BufferedReader br;
   private JTextArea taUzenetek;


    public OlvasoSzal(BufferedReader br, JTextArea taUzenetek) {
        this.br = br;
        this.taUzenetek = taUzenetek;
        setDaemon(true);
    }

    @Override
    public void run() {
        do {            
            try {
                String uzenet = br.readLine();
                taUzenetek.append(uzenet+"\n");                
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        } while (true);
   
    }
    
}
