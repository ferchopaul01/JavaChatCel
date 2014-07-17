package vista;

import controlador.MCliente;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.jdesktop.layout.GroupLayout;

public class VCliente
        extends JFrame {

    private MCliente cliente = null;

    public VCliente() {
        initComponents();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jLabel3 = new JLabel();
        this.jTextField2 = new JTextField();
        this.jButton1 = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.jTextField3 = new JTextField();
        this.jTextField4 = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.jList1 = new JList();
        this.jButton2 = new JButton();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();

        setDefaultCloseOperation(3);

        this.jLabel1.setFont(new Font("Tahoma", 1, 18));
        this.jLabel1.setText("Cliente");

        this.jLabel2.setText("Puerto:");
        this.jLabel2.setToolTipText("");

        this.jTextField1.setText("5800");
        this.jTextField1.setToolTipText("Puerto debe coincidir con el Puerto habilitado anteriormente");

        this.jLabel3.setText("URL - IP Servidor:");
        this.jLabel3.setToolTipText("");

        this.jTextField2.setText("190.12.61.30");
        this.jTextField2.setToolTipText("Escribir el Ip del Servidor que desean Conectarse");

        this.jButton1.setText("Conectar");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VCliente.this.jButton1ActionPerformed(evt);
            }
        });
        this.jTextArea1.setColumns(20);
        this.jTextArea1.setRows(5);
        this.jTextArea1.setToolTipText("Bandeja de Entrada");
        this.jScrollPane1.setViewportView(this.jTextArea1);

        this.jTextField3.setToolTipText("Escribe tu mensaje y Luego presiona Enter");
        this.jTextField3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                VCliente.this.jTextField3KeyPressed(evt);
            }
        });
        this.jTextField4.setText("Usuario");
        this.jTextField4.setToolTipText("Ingrese el Nombre del Usuario");

        this.jList1.setToolTipText("Lista de Contactos Activos");
        this.jScrollPane2.setViewportView(this.jList1);

        this.jButton2.setText("Desconectar");
        this.jButton2.setEnabled(false);
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VCliente.this.jButton2ActionPerformed(evt);
            }
        });
        this.jLabel4.setText("Nombre del Usuario:");

        this.jLabel5.setText("Clientes Conectados Activos");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jTextField3).add(2, layout.createSequentialGroup().add(layout.createParallelGroup(1).add(this.jLabel1).add(layout.createSequentialGroup().add(layout.createParallelGroup(2).add(this.jLabel4).add(this.jLabel2)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.jTextField4, -2, 107, -2).add(layout.createSequentialGroup().add(this.jTextField1, -2, 48, -2).addPreferredGap(0, -1, 32767).add(this.jLabel3))))).addPreferredGap(1).add(this.jTextField2, -2, 146, -2).add(46, 46, 46)).add(2, layout.createSequentialGroup().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(this.jButton1).addPreferredGap(0).add(this.jButton2)).add(this.jScrollPane1, -2, 308, -2)).add(18, 18, 18).add(layout.createParallelGroup(1).add(this.jScrollPane2, -2, 172, -2).add(this.jLabel5)).add(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel2).add(this.jTextField1, -2, -1, -2).add(this.jLabel3).add(this.jTextField2, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jTextField4, -2, -1, -2).add(this.jLabel4)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton1).add(this.jButton2).add(this.jLabel5)).addPreferredGap(0).add(layout.createParallelGroup(1, false).add(this.jScrollPane1).add(this.jScrollPane2, -1, 219, 32767)).add(18, 18, 18).add(this.jTextField3, -2, -1, -2).addContainerGap(-1, 32767)));
        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
        pack();
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        if (this.cliente != null) {
            this.cliente.enviarTrama(3, "");
            this.cliente.interrupt();
        }
        this.cliente = null;
        this.jButton1.setEnabled(true);
        this.jButton2.setEnabled(false);
        this.dlm.removeAllElements();
        this.jTextArea1.setText("");
    }

    private void jTextField3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.cliente.enviarMensaje(this.jTextField3.getText());
            this.jTextField3.setText("");
        }
    }

    DefaultListModel dlm = new DefaultListModel();
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JList jList1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.jList1.setModel(this.dlm);
        try {
            int port = Integer.parseInt(this.jTextField1.getText());
            String url = this.jTextField2.getText();
            String nick = this.jTextField4.getText();
            if (this.cliente == null) {
                this.cliente = new MCliente(port, url, nick, this);
                this.cliente.start();
            }
            this.jButton1.setEnabled(false);
            this.jButton2.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la entrada de datos");
            this.cliente = null;
        }
    }

    public void mensajeRecibido(String sMensaje) {
        this.jTextArea1.append(sMensaje + "\n");
    }

    public void nuevaPersona(String nick) {
        this.dlm.addElement(nick);
    }

    public void borrarPersona(int nPos) {
        this.dlm.remove(nPos);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VCliente().setVisible(true);
            }
        });
    }
}
