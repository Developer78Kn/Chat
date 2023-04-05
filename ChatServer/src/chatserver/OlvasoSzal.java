/* ChatServer 2021-04-10-2_SocketChat_SwingKartya 00:03:00 */
package chatserver;

import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Zsolt Ollé
 */
public class OlvasoSzal extends Thread {

    KliensKapcsolat kliens;
    Vector<KliensKapcsolat> kliensek;

    public OlvasoSzal(KliensKapcsolat kliens, Vector<KliensKapcsolat> kliensek) {
        this.kliens = kliens;
        this.kliensek = kliensek;
        setDaemon(true); // ha a szerver leáll akkor az összes hozzátartozó olvasoszál leáll
    }
    
    
    @Override
    public void run() { // ami ebben van az fog futni a külön szálon
        String uzenet = "";
        do {
            try {
                uzenet = kliens.getBr().readLine(); // addig áll amig a kliens nem küld valamit
                if (!"Kilépés".equals(uzenet)) {
                    System.out.println(kliens.getNev() + ": " + uzenet);
                    for (KliensKapcsolat kk : kliensek) {
                        if (kk != kliens) {
                            kk.getPw().println(kliens.getNev() + ": " + uzenet);
                            kk.getPw().flush();
                        }
                    }
                }

            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        } while (!uzenet.equals("Kilépés"));
        kliensek.remove(kliens);
        System.out.println(kliens.getNev() + " lelépett a Chatszobából. "); // a server consoljara
        for (KliensKapcsolat kk : kliensek) {
            kk.getPw().println(kliens.getNev() + " lelépett a Chatszobából. ");
            kk.getPw().flush();
        }

    }

}
