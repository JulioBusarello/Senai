
/**
 * @author julio_busarello
 */
public class Retangulo {

    private double lado1;
    private double lado2;
    private double area;
    private double perimetro;

    // ----- Construtor da Classe
    public Retangulo() {

    }

    public Retangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    // ----- Getter and Setter
    
    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    // ----- Métodos da Classe
    
    public void calcArea() {
        this.area = this.lado1 * this.lado2;
        System.out.println("A area do retangulo: " + this.area);
    }

    public void calcPerimetro() {
        this.perimetro = 2 * this.lado1 + 2 * this.lado2;
        System.out.println("O perimetro do retangulo: " + this.perimetro);
    }

}
