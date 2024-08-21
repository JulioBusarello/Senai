import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class triangulo {
    public static void main(String[] args) throws Exception {
        // Definindo a língua do código
        Locale.setDefault(Locale.US);

        // Criando um novo Scanner
        Scanner ler = new Scanner(System.in);

        // Definição de Variáveis
        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        // Pedindo valores Triângulo 1
        System.out.println("Enter the measure of triangle X: ");
        x.a = ler.nextDouble();
        x.b = ler.nextDouble();
        x.c = ler.nextDouble();

        // Pedindo valores Triângulo 2
        System.out.println("Enter the measure of triangle Y: ");
        y.a = ler.nextDouble();
        y.b = ler.nextDouble();
        y.c = ler.nextDouble();

        // Informando resultados
        System.out.printf("Triangle X area: %.2f%n", x.area());
        System.out.printf("Triangle Y area: %.2f%n", y.area());

        // Informando maior
        if (x.area() > y.area()) {
            System.out.print("Larger area: X");
        } else if (x.area() < y.area()) {
            System.out.print("Larger area: Y");
        }else{
            System.out.print("The triangles have the same area");
        }
        ler.close();
    }
}