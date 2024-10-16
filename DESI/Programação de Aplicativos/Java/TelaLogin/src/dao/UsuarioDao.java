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
        try(PreparedStatement ps = con.prepareStatement(sql)) {
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

    public void cadastrarUsu(Usuario usuario) {

    }

    public void removerUsu(int idLogin) throws SQLException {

    }

    public ArrayList<Usuario> getAllUsuarios() {
        return null;
    }

    public void alterarUsu(int codigo, String password) {

    }

}
