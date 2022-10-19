package model;

/**
 *
 * @author Bruno
 */
public class ModelVagas {

    private int codigo;
    private int codigopessoa;
    private String nome;
    private String descricao;

    public ModelVagas(int codigo, int codigopessoa, String nome, String descricao) {
        this.codigo = codigo;
        this.codigopessoa = codigopessoa;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigopessoa() {
        return codigopessoa;
    }

    public void setCodigopessoa(int codigopessoa) {
        this.codigopessoa = codigopessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
