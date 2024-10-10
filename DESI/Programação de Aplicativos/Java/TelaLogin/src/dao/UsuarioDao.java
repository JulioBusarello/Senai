package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import view.Usuario;

/**
 * @author julio_busarello
 */
public class UsuarioDao {
    private Connection con;
    ResultSet rs;
    PreparedStatement pstm;
    
    public UsuarioDao(){  
        this.con = new ConexaoBanco().getConexao();
    }
    
    public Usuario logar(String nome, String senha){
        Usuario usuario = null;
        String sql = "SELECT * FROM login WHERE nome_login = ? AND password_login = ?";
        
        try (Connection connection = new ConexaoBanco().getConexao(); 
                PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    usuario = new Usuario();
                    usuario.setUsuario(rs.getString("nome_login"));
                    usuario.setPassword(rs.getString("password_login"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
    public void cadastrarUsu(Usuario usuario){
        
    }
    
    public void removerUsu(int idLogin) throws SQLException {
        
    }
    
    public ArrayList<Usuario> getAllUsuarios() {
        return null;
    }
    
    public void alterarUsu(int codigo, String password){
        
    }
    
}
