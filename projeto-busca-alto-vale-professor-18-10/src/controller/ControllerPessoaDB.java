package controller;

/**
 *
 * @author bruno.burger
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelPessoa;
import model.ModelVagasEmpresa;
import view.Conexao;

public class ControllerPessoaDB extends ControllerDBPadrao {

    public static int TIPO_PESSOA_TODOS = 0;
    public static int TIPO_PESSOA_FISICA = 1;
    public static int TIPO_PESSOA_JURIDICA = 2;

    public ArrayList<ModelPessoa> getTodos(int tipo_pessoa) {
        String sqlTodos = "select * from public.tbpessoa order by pescodigo";
        if (tipo_pessoa == TIPO_PESSOA_TODOS) {
            sqlTodos = "select * from public.tbpessoa order by pescodigo";
        } else if (tipo_pessoa == TIPO_PESSOA_FISICA) {
            sqlTodos = "select * from public.tbpessoa where pestipo = 1 order by pescodigo ";
        } else if (tipo_pessoa == TIPO_PESSOA_JURIDICA) {
            sqlTodos = "select * from public.tbpessoa where pestipo = 2 order by pescodigo";
        }
        ArrayList listaDados = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlTodos);
            while (rs.next()) {
                int codigo = rs.getInt("pescodigo");
                String nome = rs.getString("pesnome");
                String cpfcnpj = rs.getString("pescpfcnpj");
                String email = rs.getString("pesemail");
                String senha = rs.getString("pessenha");
                String telefone = rs.getString("pestelefone");
                String cidade = rs.getString("pescidade");
                String estado = rs.getString("pesestado");
                int tipo = rs.getInt("pestipo");
                String descricao = rs.getString("pesdescricao");
                String atuacao = rs.getString("pesatuacao");
                ModelPessoa pessoa = new ModelPessoa(codigo, nome, cpfcnpj, email, senha, telefone,
                        cidade, estado, tipo, descricao, atuacao);
                listaDados.add(pessoa);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no sql, getTodos():\n" + erro.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }
        return listaDados;
    }

    public boolean excluirPessoa(int codigoPessoa) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement("delete from tbpessoa where pescodigo = ?");
            pstmt.setInt(1, codigoPessoa);
            pstmt.executeUpdate();
            executou = true;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return executou;
    }

    public ModelPessoa getPessoa(String cpfcnpj) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ModelPessoa pessoaBancoDados = new ModelPessoa();
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from public.tbpessoa where pescpfcnpj = '" + cpfcnpj + "'");
            if (rs.next()) {
                int codigo = rs.getInt("pescodigo");
                String nome = rs.getString("pesnome");
                String email = rs.getString("pesemail");
                String senha = rs.getString("pessenha");
                String telefone = rs.getString("pestelefone");
                String cidade = rs.getString("pescidade");
                String estado = rs.getString("pesestado");
                int tipo = rs.getInt("pestipo");
                String descricao = rs.getString("pesdescricao");
                String atuacao = rs.getString("pesatuacao");
                ModelPessoa pessoa = new ModelPessoa(codigo, nome, cpfcnpj, email, senha, telefone,
                        cidade, estado, tipo, descricao, atuacao);
                pessoaBancoDados = pessoa;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return pessoaBancoDados;
    }

    public boolean gravarAlteracaoPessoa(ModelPessoa pessoa) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement(" update public.tbpessoa set "
                    + " pesnomesass=?, "
                    + " pescpfcnpj=?, "
                    + " pessenha=?, "
                    + " pestelefone=?, "
                    + " pescidade=?, "
                    + " pesestado=?, "
                    + " pestipo=?, "
                    + " pesdescricao=?, "
                    + " pesatuacao=?"
                    + "WHERE pesemail=?");
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getCpfcnpj());
            pstmt.setString(3, pessoa.getSenha());
            pstmt.setString(4, pessoa.getTelefone());
            pstmt.setString(5, pessoa.getCidade());
            pstmt.setString(6, pessoa.getEstado());
            pstmt.setInt(7, pessoa.getTipo());
            pstmt.setString(8, pessoa.getDescricao());
            pstmt.setString(9, pessoa.getAtuacao());
            pstmt.setString(10, pessoa.getEmail());
            pstmt.executeUpdate();
            executou = true;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!gravarAlteracaoPessoa() " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return executou;
    }

    public boolean gravarInsercaoPessoa(ModelPessoa pessoa) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement("INSERT INTO public.tbpessoa"
                    + "(pesnome, pescpfcnpj, pesemail, pessenha, "
                    + "pestelefone, pescidade, pesestado, pestipo, pesdescricao, pesatuacao)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getCpfcnpj());
            pstmt.setString(3, pessoa.getEmail());
            pstmt.setString(4, pessoa.getSenha());
            pstmt.setString(5, pessoa.getTelefone());
            pstmt.setString(6, pessoa.getCidade());
            pstmt.setString(7, pessoa.getEstado());
            pstmt.setInt(8, pessoa.getTipo());
            pstmt.setString(9, pessoa.getDescricao());
            pstmt.setString(10, pessoa.getAtuacao());
            pstmt.executeUpdate();
            executou = true;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível gravar! \n" + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return executou;
    }

    public boolean validaLogin(String email, String senha) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean valida = false;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from public.tbpessoa where pesemail = '" + email + "' and pessenha='" + senha + "'");
            if (rs.next()) {
                valida = true;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return valida;
    }

    public boolean validaLoginAdministrador(String email, String senha) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean valida = false;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from tbpessoa inner join tbadministrador on (tbadministrador.pescodigo = tbpessoa.pescodigo) "
                    + " where pesemail = '" + email + "' and pessenha='" + senha + "'");
            if (rs.next()) {
                valida = true;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return valida;
    }

    public ArrayList<ModelPessoa> getTodosInscritos(int pescodigo) {
        ArrayList listaDados = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(" select tbpessoa.* "
                    + "       from tbvagasempresa "
                    + " inner join tbpessoa on (tbpessoa.pescodigo = tbvagasempresa.pescodigo)"
                    + "      where tbpessoa.pescodigo = " + pescodigo);
            while (rs.next()) {
                int codigo = rs.getInt("pescodigo");
                String nome = rs.getString("pesnome");
                String cpfcnpj = rs.getString("pescpfcnpj");
                String email = rs.getString("pesemail");
                String senha = rs.getString("pessenha");
                String telefone = rs.getString("pestelefone");
                String cidade = rs.getString("pescidade");
                String estado = rs.getString("pesestado");
                int tipo = rs.getInt("pestipo");
                String descricao = rs.getString("pesdescricao");
                String atuacao = rs.getString("pesatuacao");
                ModelPessoa pessoa = new ModelPessoa(codigo, nome, cpfcnpj, email, senha, telefone,
                        cidade, estado, tipo, descricao, atuacao);
                listaDados.add(pessoa);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no sql, getTodosInscritos():\n" + erro.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }
        return listaDados;
    }

    public int getCodigoPessoaLogada(String email, String senha) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int codigo = 0;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select pescodigo from public.tbpessoa where pesemail = '" + email + "' and pessenha='" + senha + "'");
            if (rs.next()) {
                codigo = rs.getInt("pescodigo");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return codigo;
    }

    public ModelPessoa getPessoaPorCodigo(int pescodigo) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ModelPessoa pessoaBancoDados = new ModelPessoa();
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from public.tbpessoa where pescodigo = " + pescodigo);
            if (rs.next()) {
                int codigo = rs.getInt("pescodigo");
                String nome = rs.getString("pesnome");
                String email = rs.getString("pesemail");
                String cpfcnpj = rs.getString("pescpfcnpj");
                String senha = rs.getString("pessenha");
                String telefone = rs.getString("pestelefone");
                String cidade = rs.getString("pescidade");
                String estado = rs.getString("pesestado");
                int tipo = rs.getInt("pestipo");
                String descricao = rs.getString("pesdescricao");
                String atuacao = rs.getString("pesatuacao");
                ModelPessoa pessoa = new ModelPessoa(codigo, nome, cpfcnpj, email, senha, telefone,
                        cidade, estado, tipo, descricao, atuacao);
                pessoaBancoDados = pessoa;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return pessoaBancoDados;
    }
 
    public ArrayList<ModelVagasEmpresa> getVagasEmpresa() {
        String sqlTodos = "	      select tbpessoa.pescodigo,\n" +
                            "	  	     tbpessoa.pesnome,\n" +
                            "	  	     tbvagas.vagcodigo,\n" +
                            "	  	     tbvagas.vagnome,\n" +
                            "	  	     tbvagas.vagdescricao\n" +
                            "        from tbvagas \n" +
                            "  inner join tbpessoa on (tbpessoa.pescodigo = tbvagas.pescodigo)\n" +
                            "       where tbpessoa.pestipo = 2 -- deve listar apenas empresa";
        
    
        ArrayList listaDados = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlTodos);
            while (rs.next()) {
                int codigopessoa = rs.getInt("pescodigo");
                String nomeEmpresa = rs.getString("pesnome");
                int vagcodigo = rs.getInt("vagcodigo");
                String vagnome = rs.getString("vagnome");
                String vagdescricao = rs.getString("vagdescricao");
                
                ModelVagasEmpresa vagasEmpresa = new ModelVagasEmpresa(vagcodigo, codigopessoa, vagnome,vagdescricao, nomeEmpresa);
                
                listaDados.add(vagasEmpresa);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no sql, getTodos():\n" + erro.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }
        return listaDados;
    }

}
