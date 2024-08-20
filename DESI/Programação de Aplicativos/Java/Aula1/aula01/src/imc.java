import java.util.Locale;
import java.util.Scanner;

public class imc {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        double peso, altura, imc;

        System.out.print("\nInforme o seu peso (Ex: 100): ");
        peso = ler.nextDouble();

        System.out.print("\nInforme sua altura (Ex: 1.90): ");
        altura = ler.nextDouble();

        imc = peso / (altura * altura);

        System.out.printf("Seu imc é: %.2f%n", imc);
        ler.close();
    }
}
