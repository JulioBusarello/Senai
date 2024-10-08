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
    
    public Usuario logar(String email, String senha){
        return null;
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
