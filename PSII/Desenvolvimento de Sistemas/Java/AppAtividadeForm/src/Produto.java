

/**
 * @author julio_busarello
 */
public class Produto {
    private int codigo;
    private String descricao;
    private String unidade;
    private int qtd;
    private double preco;
    
    public Produto() {
    }
    
    public Produto(int codigo, double preco , String unidade, int qtd, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.qtd = qtd;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
