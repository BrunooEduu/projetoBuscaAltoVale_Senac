package view;

/**
 *
 * @author Bruno Burger
 */
public class PainelPadrao extends javax.swing.JFrame {

    private int codigoPessoaLogada;

    public int getCodigoPessoaLogada() {
        return codigoPessoaLogada;
    }

    public void setCodigoPessoaLogada(int codigoPessoaLogada) {
        this.codigoPessoaLogada = codigoPessoaLogada;
    }

    public PainelPadrao(int codigoPessoaLogada) {
        this.codigoPessoaLogada = codigoPessoaLogada;
    }

    public PainelPadrao() {
    }
}
