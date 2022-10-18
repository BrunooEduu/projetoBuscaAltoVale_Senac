package view;

import controller.ControllerPessoaDB;

/**
 *
 * @author bruno.burger
 */
public class LoginPadrao extends javax.swing.JFrame {
    
    public ControllerPessoaDB pessoadb = new ControllerPessoaDB();
    
    protected boolean validaLogin(String email, String senha) {
        
        if(pessoadb.validaLogin(email,senha)){
            return true;
        }
        
        return false;
    }
}
