package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MSConexion
        extends Thread {

    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String nick;

    public MSConexion(Socket s) {
        try {
            this.s = s;
            this.dis = new DataInputStream(s.getInputStream());
            this.dos = new DataOutputStream(s.getOutputStream());
            start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getNick() {
        return this.nick;
    }

    public void run() {
        try {
            for (;;) {
                int nCodigo = this.dis.readInt();
                String sTrama = this.dis.readUTF();
                switch (nCodigo) {
                    case 1:
                        this.nick = sTrama;
                        MSGestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 2:
                        sTrama = "<" + this.nick + "> - " + sTrama;
                        MSGestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 3:
                        MSGestorConexiones.getInstance().desconecta(this);
                }
            }
        } catch (Exception e) {
        }
    }

    public void enviarTrama(int nCodigo, String sTrama) {
        try {
            this.dos.writeInt(nCodigo);
            this.dos.writeUTF(sTrama);
        } catch (Exception e) {
        }
    }
}