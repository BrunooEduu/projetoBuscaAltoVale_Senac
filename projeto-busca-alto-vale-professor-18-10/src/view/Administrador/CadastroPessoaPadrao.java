package view.Administrador;

import model.ModelPessoa;

/**
 *
 * @author bruno.burger
 */
public class CadastroPessoaPadrao extends javax.swing.JFrame {
    
    private ModelPessoa pessoa;

    public CadastroPessoaPadrao() {
     
    }

    public ModelPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(ModelPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public CadastroPessoaPadrao(ModelPessoa pessoa) {
        this.pessoa = pessoa;
    }
}
