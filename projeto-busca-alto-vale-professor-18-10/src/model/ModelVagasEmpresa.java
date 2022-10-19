package model;

/**
 *
 * @author bruno
 */
public class ModelVagasEmpresa {
    
    private int codigo;
    private int codigopessoa;
    private String nome;
    private String descricao;
    
    private String nomeEmpresa;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public ModelVagasEmpresa(int codigo, int codigopessoa, String nome, String descricao, String nomeEmpresa) {
        this.codigo = codigo;
        this.codigopessoa = codigopessoa;
        this.nome = nome;
        this.descricao = descricao;
        this.nomeEmpresa = nomeEmpresa;
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
