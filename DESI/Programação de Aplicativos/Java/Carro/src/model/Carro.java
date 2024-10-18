package model;

/**
 * @author julio_busarello
 */
public class Carro {
    private int cod_carro;
    private String des_carro;
    private int pot_carro;
    private String cor_carro;
    
    
    // -- Construtores
    
    public Carro(){
    }
    
    public Carro(String descricao, int potencia, String cor){
        this.des_carro = descricao;
        this.pot_carro = potencia;
        this.cor_carro = cor;
    }
    
    // -- Getters and Setters

    public int getCod_carro() {
        return cod_carro;
    }

    public void setCod_carro(int cod_carro) {
        this.cod_carro = cod_carro;
    }

    public String getDes_carro() {
        return des_carro;
    }

    public void setDes_carro(String des_carro) {
        this.des_carro = des_carro;
    }

    public int getPot_carro() {
        return pot_carro;
    }

    public void setPot_carro(int pot_carro) {
        this.pot_carro = pot_carro;
    }

    public String getCor_carro() {
        return cor_carro;
    }

    public void setCor_carro(String cor_carro) {
        this.cor_carro = cor_carro;
    }
    
}
