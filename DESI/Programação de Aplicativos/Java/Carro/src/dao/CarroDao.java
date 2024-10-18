package dao;

import java.sql.*;
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
    
    public void addCarro(Carro carro){
        String sql = "INSERT INTO carro (des_carro, pot_carro, cor_carro) VALUES (?, ?, ?)"; 
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
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
    
    public Carro getCarro(int codigo){
        return null;
    }
    
    public List<Carro> getAllCarros(){
        return null;
    }
    
    public void updateCarro(Carro carro){
        
    }
    
    public void deleteCarro(int codigo){
        
    }
}
