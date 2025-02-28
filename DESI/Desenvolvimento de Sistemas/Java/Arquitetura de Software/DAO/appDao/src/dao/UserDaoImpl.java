package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conexao;
import model.User;

public class UserDaoImpl implements UserDao {
    private Connection connection;

    public UserDaoImpl() {
        this.connection = Conexao.conector();
    }

    @Override
    public User findUserById(int id) {
        User user = null;
        if (verifyId(id)) {
            try {
                String query = "SELECT * FROM users WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    user = new User(resultSet.getInt("id"), resultSet.getString("name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        try {
            String query = "INSERT INTO users (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "O usuário foi Adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Houve um erro ao Adicionar usuário!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteUser(int id) {
        if (verifyId(id)) {
            try {
                String query = "DELETE FROM users WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "O usuário foi Deletado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Houve um erro ao Deletar usuário!", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            String query = "UPDATE users SET name = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "O usuário foi Atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Houve um erro ao Atualizar usuário!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            String query = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean verifyId(int id) {
        boolean exists = false;
        try {
            String query = "SELECT COUNT(*) FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!exists) {
            JOptionPane.showMessageDialog(null, "O ID do Usuário é inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return exists;
    }

}
