package view;

import view.Administrador.LoginAdministrador;
import view.PessoaFisica.CadastroFisico;
import view.PessoaFisica.LoginFisico;
import view.PessoaJuridica.CadastroJuridico;
import view.PessoaJuridica.LoginJuridico;



/**
 *
 * @author fillipe.santos
 */
public class Principal extends javax.swing.JFrame {

    
    
    
    
    
    
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
        jMenu1 = new javax.swing.JMenu();
        btnLoginJuridico = new javax.swing.JRadioButtonMenuItem();
        btnLoginFisico = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnCadastrarJuridico = new javax.swing.JRadioButtonMenuItem();
        btnCadastrarFisico = new javax.swing.JRadioButtonMenuItem();
        btnLoginAdministrador = new javax.swing.JMenu();
        btnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Busca Jobs.png"))); // NOI18N
        getContentPane().add(jLabel2);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alunos2.jpeg"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1);

        jMenu1.setText("Login");

        btnLoginJuridico.setSelected(true);
        btnLoginJuridico.setText("Pessoa Jurídica");
        btnLoginJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginJuridicoActionPerformed(evt);
            }
        });
        jMenu1.add(btnLoginJuridico);

        btnLoginFisico.setSelected(true);
        btnLoginFisico.setText("Pessoa Física");
        btnLoginFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginFisicoActionPerformed(evt);
            }
        });
        jMenu1.add(btnLoginFisico);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastrar");

        btnCadastrarJuridico.setSelected(true);
        btnCadastrarJuridico.setText("Pessoa Jurídica");
        btnCadastrarJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarJuridicoActionPerformed(evt);
            }
        });
        jMenu2.add(btnCadastrarJuridico);

        btnCadastrarFisico.setSelected(true);
        btnCadastrarFisico.setText("Pessoa Física");
        btnCadastrarFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFisicoActionPerformed(evt);
            }
        });
        jMenu2.add(btnCadastrarFisico);

        jMenuBar1.add(jMenu2);

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

    private void btnLoginJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginJuridicoActionPerformed
        LoginJuridico loginJuridico = new LoginJuridico();
        loginJuridico.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoginJuridicoActionPerformed

    private void btnLoginFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginFisicoActionPerformed
        LoginFisico loginFisico = new LoginFisico();
        loginFisico.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoginFisicoActionPerformed

    private void btnCadastrarJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarJuridicoActionPerformed
        CadastroJuridico cadastrarJuridico = new CadastroJuridico();
        cadastrarJuridico.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadastrarJuridicoActionPerformed

    private void btnCadastrarFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFisicoActionPerformed
        CadastroFisico cadastrarFisico = new CadastroFisico();
        cadastrarFisico.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadastrarFisicoActionPerformed

    private void btnLoginAdministradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginAdministradorMousePressed
        LoginAdministrador loginAdministrador = new LoginAdministrador();
        loginAdministrador.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoginAdministradorMousePressed

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
    private javax.swing.JRadioButtonMenuItem btnCadastrarFisico;
    private javax.swing.JRadioButtonMenuItem btnCadastrarJuridico;
    private javax.swing.JMenu btnLoginAdministrador;
    private javax.swing.JRadioButtonMenuItem btnLoginFisico;
    private javax.swing.JRadioButtonMenuItem btnLoginJuridico;
    private javax.swing.JMenu btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
