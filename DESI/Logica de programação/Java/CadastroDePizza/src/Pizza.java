/**
 * @author julio_busarello
 */
public class Pizza {

    private int codigo;
    private String tam;
    private String sabor1;
    private String sabor2;
    private boolean borda;
    private String formato;
    private int fatias;
    private boolean premium;

    // ----- Construtores
    public Pizza() {
        codigo++;
    }

    public Pizza(String tam, String sabor1, String sabor2, String formato, int fatias, boolean borda, boolean premium) {
        codigo++;
        this.tam = tam;
        this.sabor1 = sabor1;
        this.sabor2 = sabor2;
        this.formato = formato;
        this.fatias = fatias;
        this.borda = borda;
        this.premium = premium;
    }

    // ----- Getters and Setters
    public int getCodigo() {
        return codigo;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public String getSabor1() {
        return sabor1;
    }

    public void setSabor1(String sabor1) {
        this.sabor1 = sabor1;
    }

    public String getSabor2() {
        return sabor2;
    }

    public void setSabor2(String sabor2) {
        this.sabor2 = sabor2;
    }

    public boolean isBorda() {
        return borda;
    }

    public void setBorda(boolean borda) {
        this.borda = borda;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getFatias() {
        return fatias;
    }

    public void setFatias(int fatias) {
        this.fatias = fatias;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    // ----- Métodos


}
