package model;

/**
 *
 * @author Gelvazio Camargo
 */
public class ModelPessoa {

    private int codigo;
    private String nome;
    private String cpfcnpj;
    private String email;
    private String senha;
    private String telefone;
    private String cidade;
    private String estado;
    private int tipo;
    private String descricao;
    private String atuacao;

    public ModelPessoa(int codigo, String nome, String cpfcnpj, String email, String senha, String telefone, String cidade, String estado, int tipo, String descricao, String atuacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.tipo = tipo;
        this.descricao = descricao;
        this.atuacao = atuacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }


}
