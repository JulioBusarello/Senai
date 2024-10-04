package dao;

/**
 * @author julio_busarello
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;

public class FornecedorDaoImpl implements FornecedorDao {
    private Connection connection;

    public FornecedorDaoImpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/db_cad";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addFornecedor(Fornecedor fornecedor) {
        try {
            String query = "INSERT INTO fornecedor (id, contato, telefone, email, empresa) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,fornecedor.getCodigo());
            statement.setString(2, fornecedor.getContato());
            statement.setString(3, fornecedor.getTelefone());
            statement.setString(4, fornecedor.getEmail());
            statement.setString(5, fornecedor.getEmpresa());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Fornecedor getFornecedor(int id) {
        Fornecedor fornecedor = null;
        try {
            String query = "SELECT * FROM fornecedor WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                fornecedor = new Fornecedor(resultSet.getInt("id"), resultSet.getString("contato"), resultSet.getString("telefone"), resultSet.getString("email"), resultSet.getString("empresa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> getAllFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            String query = "SELECT * FROM fornecedor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                fornecedores.add(new Fornecedor(resultSet.getInt("id"), resultSet.getString("contato"), resultSet.getString("telefone"), resultSet.getString("email"), resultSet.getString("empresa")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fornecedores;
    }

    @Override
    public void updateFornecedor(Fornecedor fornecedor) {
        try {
            String query = "UPDATE fornecedor SET contato = ?, telefone = ?, email = ?, empresa = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, fornecedor.getContato());
            statement.setString(2, fornecedor.getTelefone());
            statement.setString(3, fornecedor.getEmail());
            statement.setString(4, fornecedor.getEmpresa());
            statement.setInt(5, fornecedor.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFornecedor(int id) {
        try {
            String query = "DELETE FROM fornecedor WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
