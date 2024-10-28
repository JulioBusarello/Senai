package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * @author julio_busarello
 */
public class ConexaoBanco {
    
    // Função para conexão com o banco de dados
    public Connection getConexao(){
        try {
            String url = "jdbc:mysql://localhost:3306/db_carro";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão com o Banco de Dados!" +e.getMessage());
            return null;
        }
    }
    
}
