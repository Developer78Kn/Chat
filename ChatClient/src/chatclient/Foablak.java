/* ChatClient 2021-04-10-1_Halozat_Port_Socket_Chat.mp4 01:00:33  */
package chatclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Zsolt Ollé
 */
public class Foablak extends javax.swing.JFrame {

    private PrintWriter pw;
    private Socket socket;
    private boolean kapcsolat;

    public void kapcsolodas() {
        if (!kapcsolat) {
            btnExit.setEnabled(true);
            btnKuld.setEnabled(true);
            btnConnect.setEnabled(false);
            tfNev.setEditable(false);
            tfServer.setEditable(false);
            try {
                socket = new Socket(tfServer.getText(), 8888);
                pw = new PrintWriter(socket.getOutputStream());
                pw.println(tfNev.getText());
                tfNev.getText();
                pw.flush();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OlvasoSzal osz = new OlvasoSzal(br, taUzenetek);
                osz.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.toString(), "Hiba történt", JOptionPane.ERROR_MESSAGE);
            }
            kapcsolat = true;
        }
    }

    public void uzenetKuldese() {
        if (kapcsolat) {
            pw.println(tfUzenet.getText());
            pw.flush();
            taUzenetek.append(tfUzenet.getText() + "\n");
            tfUzenet.setText("");
        }
    }

    public Foablak() {
        initComponents();
        btnExit.setEnabled(false);
        btnKuld.setEnabled(false);

        // getRootPane().setDefaultButton(btnKuld); // enter leütésénél ez lesz az alap
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfNev = new javax.swing.JTextField();
        tfServer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnConnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taUzenetek = new javax.swing.JTextArea();
        btnKuld = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfUzenet = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Név:");

        tfNev.setText("Jhon");
        tfNev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNevActionPerformed(evt);
            }
        });
        tfNev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNevKeyReleased(evt);
            }
        });

        tfServer.setText("localhost");
        tfServer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfServerKeyReleased(evt);
            }
        });

        jLabel2.setText("Server:");

        btnConnect.setText("Kapcsolódás");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        taUzenetek.setEditable(false);
        taUzenetek.setColumns(20);
        taUzenetek.setRows(5);
        jScrollPane1.setViewportView(taUzenetek);

        btnKuld.setText("Küldés");
        btnKuld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKuldActionPerformed(evt);
            }
        });

        jLabel3.setText("Üzenet :");

        tfUzenet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfUzenetKeyReleased(evt);
            }
        });

        btnExit.setText("Kilépés");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfUzenet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKuld))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNev, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfServer, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConnect)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKuld)
                    .addComponent(jLabel3)
                    .addComponent(tfUzenet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        kapcsolodas();
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnKuldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKuldActionPerformed
        if (kapcsolat) {
            pw.println(tfUzenet.getText());
            pw.flush();
            taUzenetek.append(tfUzenet.getText() + "\n");
            tfUzenet.setText("");
        }
    }//GEN-LAST:event_btnKuldActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if (kapcsolat) {
            kapcsolat = false;
            btnConnect.setEnabled(true);
            btnExit.setEnabled(false);
            btnKuld.setEnabled(false);
            tfNev.setEditable(true);
            tfServer.setEditable(true);
            pw.println("Kilépés");
            pw.flush();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void tfNevKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNevKeyReleased
        if (evt.getKeyChar() == '\n') {
            kapcsolodas();

            System.out.println("ez enter");
        }
    }//GEN-LAST:event_tfNevKeyReleased

    private void tfServerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfServerKeyReleased
        if (evt.getKeyChar() == '\n') {
            kapcsolodas();
            System.out.println("ez enter");
        }
    }//GEN-LAST:event_tfServerKeyReleased

    private void tfNevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNevActionPerformed

    private void tfUzenetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUzenetKeyReleased
        if (evt.getKeyChar() == '\n') {
            uzenetKuldese();
        }
    }//GEN-LAST:event_tfUzenetKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Foablak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnKuld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea taUzenetek;
    private javax.swing.JTextField tfNev;
    private javax.swing.JTextField tfServer;
    private javax.swing.JTextField tfUzenet;
    // End of variables declaration//GEN-END:variables
}
