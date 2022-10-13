package view;

import view.FuncoesTelaPrincipal.Administrador;
import view.FuncoesTelaPrincipal.Cadastrar;
import view.FuncoesTelaPrincipal.Login;

/**
 *
 * @author fillipe.santos
 */
public class Principal extends javax.swing.JFrame {

    Administrador loginAdm = new Administrador();
    
    Cadastrar cadastrar = new Cadastrar();
    
    Login login = new Login();
    
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnLongin = new javax.swing.JMenu();
        btnCadastrar = new javax.swing.JMenu();
        btnLoginAdministrador = new javax.swing.JMenu();
        btnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Busca Jobs.png"))); // NOI18N
        getContentPane().add(jLabel2);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alunos2.jpeg"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1);

        btnLongin.setText("Login");
        btnLongin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLonginMousePressed(evt);
            }
        });
        jMenuBar1.add(btnLongin);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCadastrarMousePressed(evt);
            }
        });
        jMenuBar1.add(btnCadastrar);

        btnLoginAdministrador.setText("Administrador");
        btnLoginAdministrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLoginAdministradorMousePressed(evt);
            }
        });
        jMenuBar1.add(btnLoginAdministrador);

        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSairMousePressed(evt);
            }
        });
        jMenuBar1.add(btnSair);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMousePressed
        System.exit(0);
    }//GEN-LAST:event_btnSairMousePressed

    private void btnLoginAdministradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginAdministradorMousePressed
        loginAdm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoginAdministradorMousePressed

    private void btnCadastrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMousePressed
       cadastrar.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnCadastrarMousePressed

    private void btnLonginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLonginMousePressed
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLonginMousePressed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnCadastrar;
    private javax.swing.JMenu btnLoginAdministrador;
    private javax.swing.JMenu btnLongin;
    private javax.swing.JMenu btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
