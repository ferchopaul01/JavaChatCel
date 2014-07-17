package vista;

import controlador.MServidor;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.jdesktop.layout.GroupLayout;

public class VServidor
        extends JFrame {

    private MServidor servidor = null;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField jTextField1;

    public VServidor() {
        initComponents();
        int port = Integer.parseInt(this.jTextField1.getText());
            this.servidor = new MServidor(this, port);
            this.servidor.start(); 
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jButton1 = new JButton();

        setDefaultCloseOperation(3);
        setResizable(false);

        this.jLabel1.setFont(new Font("Tahoma", 1, 18));
        this.jLabel1.setText("Servidor");

        this.jLabel2.setText("Puerto");

        this.jTextField1.setText("5800");

        this.jButton1.setText("Abrir puerto");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VServidor.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1, false).add(this.jButton1).add(this.jLabel2).add(this.jLabel1).add(2, layout.createSequentialGroup().add(42, 42, 42).add(this.jTextField1))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel2).add(this.jTextField1, -2, -1, -2)).addPreferredGap(0).add(this.jButton1).addContainerGap(-1, 32767)));
      setSize(new java.awt.Dimension(200, 50));
        setLocationRelativeTo(null);
        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
      //  if (this.servidor == null) {
            int port = Integer.parseInt(this.jTextField1.getText());
            this.servidor = new MServidor(this, port);
            this.servidor.start();           
       // }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VServidor();
            }
        });
    }
}
