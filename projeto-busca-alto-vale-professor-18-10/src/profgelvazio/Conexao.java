package profgelvazio;

import view.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {

    // CONEXAO EFETIVA EQUIPE BRUNO EDUARDO
//    private static final String HOST     = "db.vdcszqvvrwdqcnjvcoxt.supabase.co";
//    private static final String SENHA    = "SENHA";

    // CONEXAO TEMPORARIA BANCO GELVAZIO
    private static final String HOST     = "db.vdcszqvvrwdqcnjvcoxt.supabase.co";
    private static final String SENHA    = "bMn0PTMuUVC06ijP";

    private static final String DRIVER   = "org.postgresql.Driver";
    private static final String BANCO    = "postgres";
    private static final String CONEXAO  = "jdbc:postgresql://" + HOST + "/" + BANCO;
    private static final String USUARIO  = "postgres";

    public static Connection getConexao() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CONEXAO, USUARIO, SENHA);
        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Erro de driver! \n" + erro.getMessage());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão! \n" + erro.getMessage());
        }
        return conn;
    }

    public static void closeAll(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão! \n " + erro.getMessage());
        }
    }
}
