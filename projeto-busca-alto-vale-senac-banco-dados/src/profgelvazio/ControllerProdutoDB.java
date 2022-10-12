package profgelvazio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author gelvazio.camargo
 */
public class ControllerProdutoDB {

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
}
