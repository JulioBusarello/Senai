package dao;

/**
 * @author julio_busarello
 */
import java.util.List;

import model.Cliente;

public interface ClienteDao {
    void addCliente(Cliente cliente);
    Cliente getCliente(int id);
    List<Cliente> getAllClientes();
    void updateCliente(Cliente cliente);
    void deleteCliente(int id);
}
