package dao;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author julio_busarello
 */
public class ConexaoBanco {
    public Connection getConexao(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_login","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão com o Banco de Dados!");
            return null;
        }
    }
}
