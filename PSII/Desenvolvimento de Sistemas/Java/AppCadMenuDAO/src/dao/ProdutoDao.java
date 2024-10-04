package dao;

import java.util.List;
import model.Produto;

/**
 * @author julio_busarello
 */
public interface ProdutoDao {
    void addProduto(Produto produto);
    Produto getProduto(int id);
    List<Produto> getAllProdutos();
    void updateProduto(Produto produto);
    void deleteProduto(int id);
}
