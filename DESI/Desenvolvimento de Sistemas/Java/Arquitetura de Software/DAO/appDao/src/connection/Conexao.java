package connection;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
  public static Connection conector() {
    Connection conexao = null;

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_dao";
    String user = "root";
    String password = "senai";

    // tentativa de conexão
    try {
      Class.forName(driver);
      conexao = DriverManager.getConnection(url, user, password);
      return conexao;

    } catch (Exception erro) {
      JOptionPane.showMessageDialog(null,
          "Erro no módulo de conexão: " + erro);
      return null;
    }

  }
}