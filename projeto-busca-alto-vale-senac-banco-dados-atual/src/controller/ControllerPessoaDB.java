package controller;

/**
 *
 * @author bruno.burger
 */

package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelPessoa;

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

    public boolean excluirProduto(int codigoProduto) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;
        
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement("delete from tbproduto where procodigo = ?");
            pstmt.setInt(1, codigoProduto);
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
            if(rs.next()) {
                              
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
            
            pstmt = conn.prepareStatement
                (" update public.tbpessoa set " 
                        + " pesnomesass=?, "
                        + " pescpfcnpj=?, "
                        + " pessenha=?, "
                        + " pestelefone=?, "
                        + " pescidade=?, "
                        + " pesestado=?, "
                        + " pestipo=?, "
                        + " pesdescricao=?, "
                        + " pesatuacao=?" +
                     "WHERE pesemail=?");
            
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
            
            pstmt = conn.prepareStatement
                ("INSERT INTO public.tbpessoa" +
                "(pesnome, pescpfcnpj, pesemail, pessenha, "
                + "pestelefone, pescidade, pesestado, pestipo, pesdescricao, pesatuacao)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
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
}
