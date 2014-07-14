package controlador;

import java.util.ArrayList;

public class MSGestorConexiones {

    private static MSGestorConexiones singleton = new MSGestorConexiones();

    public static MSGestorConexiones getInstance() {
        return singleton;
    }

    private ArrayList<MSConexion> conexiones = new ArrayList();

    public void enviarTrama(int nCodigo, String sTrama) {
        for (MSConexion ms : this.conexiones) {
            ms.enviarTrama(nCodigo, sTrama);
        }
    }

    public void conectaNuevo(MSConexion nuevo) {
        for (MSConexion ms : this.conexiones) {
            nuevo.enviarTrama(1, ms.getNick());
        }
        this.conexiones.add(nuevo);
    }

    public void desconecta(MSConexion eliminar) {
        int nPos = -1;
        for (int n = 0; n < this.conexiones.size(); n++) {
            if (this.conexiones.get(n) == eliminar) {
                nPos = n;
            }
        }
        if (nPos != -1) {
            for (int n = 0; n < this.conexiones.size(); n++) {
                if (n != nPos) {
                    ((MSConexion) this.conexiones.get(n)).enviarTrama(3, "" + nPos);
                }
            }
            this.conexiones.remove(nPos);
        }
    }
}
