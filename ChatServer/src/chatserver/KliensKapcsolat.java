/* ChetServer 2021-04-10-1_Halozat_Port_Socket_Chat.mp4 01:20:40 */
package chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Zsolt Ollé
 */
public class KliensKapcsolat {
    private String nev;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public KliensKapcsolat() {
    }

    public KliensKapcsolat(String nev, Socket socket) throws IOException {
        this.nev = nev;
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream() ));
        pw = new PrintWriter(socket.getOutputStream());
    }

    
    
    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }
    
    
    
    
    
}
