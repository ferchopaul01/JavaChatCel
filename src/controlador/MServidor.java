package controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MServidor
        extends Thread {

    private int port;
    private JFrame ventana;

    public MServidor(JFrame ventana, int port) {
        this.port = port;
        this.ventana = ventana;
    }

    public void run() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(this.port);
             JOptionPane.showMessageDialog(this.ventana,"Puerto abierto correctamente");
            for (;;) {
                Socket s = ss.accept();
                MSGestorConexiones.getInstance().conectaNuevo(new MSConexion(s));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.ventana, "Error al abrir el puerto. Posiblemente ya esté en uso.");
            System.out.println(e);
           
        }
    }
}
