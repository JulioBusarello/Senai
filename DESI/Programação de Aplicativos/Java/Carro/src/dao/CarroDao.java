package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Carro;

/**
 * @author julio_busarello
 */
public class CarroDao {

    private Connection connection;

    public CarroDao() {
        this.connection = new ConexaoBanco().getConexao();
    }

    // Função Adicionar no banco de dados
    public void addCarro(Carro carro) {
        String sql = "INSERT INTO carro (des_carro, pot_carro, cor_carro) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, carro.getDes_carro());
            ps.setInt(2, carro.getPot_carro());
            ps.setString(3, carro.getCor_carro());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Carro adicionado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Função Buscar um carro no banco de dados
    public Carro getCarro(int codigo) {
        Carro carro = null;
        try {
            String query = "SELECT * FROM carro WHERE cod_carro = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                carro = new Carro(
                        resultSet.getInt("cod_carro"),
                        resultSet.getString("des_carro"),
                        resultSet.getInt("pot_carro"),
                        resultSet.getString("cor_carro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carro;
    }

    // Função Buscar todos os carro no banco de dados
    public List<Carro> getAllCarros() {
        String sql = "SELECT * FROM carro";
        ArrayList<Carro> carros = null;
        try (Connection connection = new ConexaoBanco().getConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (carros == null) {
                        carros = new ArrayList<>();
                    }
                    Carro carro = new Carro();
                    carro.setCod_carro(rs.getInt("cod_carro"));
                    carro.setDes_carro(rs.getString("des_carro"));
                    carro.setPot_carro(rs.getInt("pot_carro"));
                    carro.setCor_carro(rs.getString("cor_carro"));

                    carros.add(carro);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carros;
    }

    // Função Alterar um carro no banco de dados
    public void updateCarro(int codigo, String cor) {
        String sql = "UPDATE carro SET cor_carro = ? WHERE cod_carro = ?";
        try (Connection connection = new ConexaoBanco().getConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cor);
            ps.setInt(2, codigo);
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "A cor foi alterada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Função Deletar um carro no banco de dados
    public void deleteCarro(int codigo) throws SQLException {
        String sql = "DELETE FROM carro WHERE cod_carro = ?";
        try (Connection connection = new ConexaoBanco().getConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "O carro foi deletado com sucesso!");
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new SQLException("Erro: Não foi possível excluir o Carro!" + e);
        }
    }
}
