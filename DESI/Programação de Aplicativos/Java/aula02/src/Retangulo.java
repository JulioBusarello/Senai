import java.util.Scanner;
import java.util.Locale;

import entities.Rectangle;

public class Retangulo {
    public static void main(String[] args) throws Exception {
        // Definindo a língua do código
        Locale.setDefault(Locale.US);

        // Criando um novo Scanner
        Scanner ler = new Scanner(System.in);

        // Definindo Variáveis
        Rectangle retangulo = new Rectangle();

        System.out.println("Enter retangle width and height: ");
        retangulo.width = ler.nextDouble();
        retangulo.height = ler.nextDouble();

        System.out.println("Area: "+retangulo.area());
        System.out.println("Perimeter: "+retangulo.perimeter());
        System.out.println("Diagonal: "+retangulo.diagonal());

        ler.close();
    }
}
