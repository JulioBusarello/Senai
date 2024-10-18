package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.Usuario;

/**
 * @author julio_busarello
 */
public class UsuarioDao {

    private Connection con;
    ResultSet rs;
    PreparedStatement pstm;

    public UsuarioDao() {
        this.con = new ConexaoBanco().getConexao();
    }

    public Usuario login(String user, String senha) {
        Usuario usuario = null;
        String sql = "SELECT * FROM login WHERE user_login = ? AND password_login = ?";

        try (Connection connection = new ConexaoBanco().getConexao(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setUser(rs.getString("user_login"));
                    usuario.setPassword(rs.getString("password_login"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public Usuario cadUser(Usuario usuario) {
        String sql = "INSERT INTO login (user_login, nome_login, password_login) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getName());
            ps.setString(3, usuario.getPassword());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return usuario;
    }

    public void removeUsu(int idLogin) throws SQLException {
        String sql = "DELETE FROM login WHERE id = ?";
        try (Connection connection = new ConexaoBanco().getConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idLogin);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "O usuário foi excluído com sucesso!");
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new SQLException("Erro: Não foi possível excluir o Usuário!" + e);
        }
    }

    public ArrayList<Usuario> getAllUsuarios() {
        String sql = "SELECT * FROM login";
        ArrayList<Usuario> usuarios = null;
        try (Connection connection = new ConexaoBanco().getConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if(usuarios == null){
                        usuarios = new ArrayList<>();
                    }
                    Usuario user = new Usuario();
                    user.setCod(rs.getInt("id"));
                    user.setName(rs.getString("nome_login"));
                    user.setPassword(rs.getString("password_login"));
                    user.setUser(rs.getString("user_login"));

                    usuarios.add(user);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    public void alterarUsu(int codigo, String password) {
        String sql = "UPDATE login SET password_login = ? WHERE id = ?";
        try (Connection connection = new ConexaoBanco().getConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, password);
            ps.setInt(2, codigo);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "A senha foi alterada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
