
package testes;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author gelvazio.camargo
 */
public class JButtonVagasEmpresa extends JButton {

    private int codigoVaga;
    private int codigoPessoa;
    
//    public JButtonVagasEmpresa(String text) {
//        super(text);
//    }

    public JButtonVagasEmpresa(String nomeVaga, int codigoVaga, int codigoPessoa) {
        super(nomeVaga);
        this.codigoVaga = codigoVaga;
        this.codigoPessoa = codigoPessoa;
        
        //System.out.println("olasdadadadadasas");
        
//        this.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButtonTesteActionPerformed(evt, codigoVaga, codigoPessoa);
//            }
//        });
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JButtonVagasEmpresaMousePressed(evt);
            }
        });
    }
    
    private void jButtonTesteActionPerformed(java.awt.event.ActionEvent evt, int codigoVaga, int codigoPessoa) {                                         
         //JOptionPane.showMessageDialog(null, "Teste de vagasssss: \ncodigoVaga" + " \ncodigoPessoa" + codigoPessoa);
         
         System.out.println("44444");
    } 
    
    private void JButtonVagasEmpresaMousePressed(java.awt.event.MouseEvent evt) {                                      
        System.out.println("123");
    }
    
}
