package view;

import controller.ControllerPessoaDB;

/**
 *
 * @author bruno.burger
 */
public class ViewConsultaPadrao extends javax.swing.JFrame {

    private int codigoPessoaLogada;
    public ControllerPessoaDB pessoadb = new ControllerPessoaDB();

    public int getCodigoPessoaLogada() {
        return codigoPessoaLogada;
    }

    public void setCodigoPessoaLogada(int codigoPessoaLogada) {
        this.codigoPessoaLogada = codigoPessoaLogada;
    }
}
