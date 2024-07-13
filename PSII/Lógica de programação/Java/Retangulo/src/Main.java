
/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        // ----- Retangulo 1
        Retangulo rec1 = new Retangulo(10, 5);

        System.out.println("Retangulo 1: ");
        rec1.calcArea();
        rec1.calcPerimetro();

        rec1.setLado2(7);

        rec1.calcArea();
        rec1.calcPerimetro();

        // ----- Retangulo 2
        Retangulo rec2 = new Retangulo(20, 15);

        System.out.println("Retangulo 2: ");
        rec2.calcArea();
        rec2.calcPerimetro();

        rec2.setLado2(10);

        rec2.calcArea();
        rec2.calcPerimetro();

        // ----- Retangulo 3
        Retangulo rec3 = new Retangulo(75, 55);

        System.out.println("Retangulo 3: ");
        rec3.calcArea();
        rec3.calcPerimetro();

        rec3.setLado2(40);

        rec3.calcArea();
        rec3.calcPerimetro();
        
        // ----- Retangulo 4
        Retangulo rec4 = new Retangulo(50, 30);

        System.out.println("Retangulo 4: ");
        rec4.calcArea();
        rec4.calcPerimetro();

        rec4.setLado2(25);

        rec4.calcArea();
        rec4.calcPerimetro();
    }

}
