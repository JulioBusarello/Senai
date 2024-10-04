package dao;

import java.util.List;

import model.Fornecedor;

/**
 * @author julio_busarello
 */
public interface FornecedorDao {
    void addFornecedor(Fornecedor fornecedor);
    Fornecedor getFornecedor(int id);
    List<Fornecedor> getAllFornecedores();
    void updateFornecedor(Fornecedor fornecedor);
    void deleteFornecedor(int id);
}
