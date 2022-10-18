package view;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.Conexao;


import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {

    // CONEXAO EFETIVA EQUIPE BRUNO EDUARDO
//    private static final String HOST     = "db.vdcszqvvrwdqcnjvcoxt.supabase.co";
//    private static final String SENHA    = "SENHA";

    // CONEXAO TEMPORARIA BANCO GELVAZIO
    private static final String HOST     = "db.qdkrptzlqjneikbdakei.supabase.co";
    private static final String SENHA    = "kA2ifwAwkFiixk6L";

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
    
    public static void main(String[] args) {
        // System.out.println("ola");
        
        ArrayList listaDados = new ArrayList();
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;        
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from tbpessoa");
            
            while (rs.next()) {
                int codigo = rs.getInt("pescodigo");                
                String nome = rs.getString("pesnome");
                
                System.out.println("Usuário: \n codigo:" + codigo + " \n " + "nome:" + nome);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no sql, getTodos():\n" + erro.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }    
    }
}
