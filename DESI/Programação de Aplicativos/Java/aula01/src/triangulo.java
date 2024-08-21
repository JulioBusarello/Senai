import java.util.Locale;
import java.util.Scanner;

public class triangulo {
    public static void main (String[] args ) throws Exception{
        // Definindo a língua do código
        Locale.setDefault(Locale.US);

        // Criando um novo Scanner
        Scanner ler = new Scanner(System.in);

        // Definição de Variável
        double a,b,c,p;
        double area1,area2;

        // Pedindo valores Triângulo 1
        System.out.println("Informe o lado a do triangulo X: ");
        a = ler.nextDouble();
        System.out.println("Informe o lado b do triangulo X: ");
        b = ler.nextDouble();
        System.out.println("Informe o lado c do triangulo X: ");
        c = ler.nextDouble();

        // Calculos Triângulo 1
        p = (a+b+c)/2;

        area1 = Math.sqrt(p*(p-a)*(p-b)*(p-c));

        // Pedindo valores Triângulo 2
        System.out.println("Informe o lado a do triangulo Y: ");
        a = ler.nextDouble();
        System.out.println("Informe o lado b do triangulo Y: ");
        b = ler.nextDouble();
        System.out.println("Informe o lado c do triangulo Y: ");
        c = ler.nextDouble();

        // Calculos Triângulo 2
        p = (a+b+c)/2;

        area2 = Math.sqrt(p*(p-a)*(p-b)*(p-c));

        // Informando resultados
        System.out.printf("Area do triangulo X: %.2f%n", area1);
        System.out.printf("Area do triangulo Y: %.2f%n", area2);

        // Informando maior
        if(area1 > area2){
            System.out.print("O maior triangulo e o X");
        }else{
            System.out.print("O maior triangulo e o Y");
        }
        ler.close();
    }
}
