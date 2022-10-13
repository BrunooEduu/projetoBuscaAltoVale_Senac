package profgelvazio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.Conexao;

/**
 * @author gelvazio.camargo
 */
public class ControllerProdutoDB extends ControllerDBPadrao {

    private static final String
        sqlTodos = "select * from public.tbproduto order by procodigo";

    public ArrayList<ModelProduto> getTodos() {
        ArrayList listaDados = new ArrayList();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlTodos);

            while (rs.next()) {
                // Pega valor inteiro
                int codigo = rs.getInt("procodigo");

                // Pega valores String(texto)
                String descricao = rs.getString("prodescricao");
                float preco = rs.getFloat("propreco");

                ModelProduto produto = new ModelProduto(codigo, descricao, preco);

                listaDados.add(produto);
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

    public ModelProduto getProduto(int codigoProduto) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ModelProduto produtoBancoDados = new ModelProduto();

        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select procodigo,prodescricao,propreco "
                    + "from tbproduto where procodigo = " + codigoProduto);
            if(rs.next()) {
                // Pega valor inteiro
                int codigo = rs.getInt("procodigo");

                // Pega valores String(texto)
                String descricao = rs.getString("prodescricao");
                float preco = rs.getFloat("propreco");

                ModelProduto produto = new ModelProduto(codigo, descricao, preco);

                produtoBancoDados = produto;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }

        return produtoBancoDados;
    }

    public boolean gravarAlteracaoProduto(ModelProduto produto) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;

        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();

            pstmt = conn.prepareStatement
                (" update tbproduto set "
                    + " prodescricao = ?,"
                    + " propreco = ?"
                    + " where procodigo = ?");

            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setInt(3, produto.getCodigo());

            pstmt.executeUpdate();

            executou = true;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }

        return executou;
    }

    public boolean gravarInsercaoProduto(ModelProduto produto) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;

        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();

            pstmt = conn.prepareStatement
                (" insert into tbproduto "
                    + "(procodigo, prodescricao, propreco) "
                    + "values(?, ?, ?)");

            pstmt.setInt(1, produto.getCodigo());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());

            pstmt.executeUpdate();

            executou = true;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }

        return executou;
    }
}
