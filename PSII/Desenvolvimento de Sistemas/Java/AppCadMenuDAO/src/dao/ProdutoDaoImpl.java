package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 * @author julio_busarello
 */
public class ProdutoDaoImpl implements ProdutoDao {
    private Connection connection;

    public ProdutoDaoImpl() {
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
    public void addProduto(Produto produto) {
        try {
            String query = "INSERT INTO produto (id, preco, unidade, quantidade, descricao) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,produto.getCodigo());
            statement.setDouble(2, produto.getPreco());
            statement.setString(3, produto.getUnidade());
            statement.setInt(4, produto.getQtd());
            statement.setString(5, produto.getDescricao());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produto getProduto(int id) {
        Produto produto = null;
        try {
            String query = "SELECT * FROM produto WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                produto = new Produto(resultSet.getInt("id"), resultSet.getDouble("preco"), resultSet.getString("unidade"), resultSet.getInt("quantidade"), resultSet.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    @Override
    public List<Produto> getAllProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            String query = "SELECT * FROM produto";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                produtos.add(new Produto(resultSet.getInt("id"), resultSet.getDouble("preco"), resultSet.getString("unidade"), resultSet.getInt("quantidade"), resultSet.getString("descricao")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public void updateProduto(Produto produto) {
        try {
            String query = "UPDATE produto SET preco = ?, unidade = ?, quantidade = ?, descricao = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, produto.getPreco());
            statement.setString(2, produto.getUnidade());
            statement.setInt(3, produto.getQtd());
            statement.setString(4, produto.getDescricao());
            statement.setInt(5, produto.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduto(int id) {
        try {
            String query = "DELETE FROM produto WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
