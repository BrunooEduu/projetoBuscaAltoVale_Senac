package view;

import controller.ControllerPessoaDB;
import javax.swing.JOptionPane;
import model.ModelPessoa;

/**
 *
 * @author Bruno
 */
public class ExcluirCadastroPadrao extends javax.swing.JFrame{
 
    ControllerPessoaDB pessoadb = new ControllerPessoaDB();
    
    protected boolean excluiCadastro(String pescpfcnpj){
        boolean excluiu = false;
        ModelPessoa pessoaBanco = pessoadb.getPessoa(pescpfcnpj);            
        if (pessoaBanco.getCodigo() > 0) {
            if (pessoadb.excluirPessoa(pessoaBanco.getCodigo())) {
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                excluiu = true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir cadastro com este cpf/cnpj!");  
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não existe pessoa/empresa cadastrada com este cpf/cnpj!");  
        }       
        
        return excluiu;
    }
}
