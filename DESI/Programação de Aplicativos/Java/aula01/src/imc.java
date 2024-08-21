import java.util.Locale;
import java.util.Scanner;

public class imc {
    public static void main(String[] args) throws Exception {
        // Definindo a língua do código
        Locale.setDefault(Locale.US);

        // Criando um novo Scanner
        Scanner ler = new Scanner(System.in);

        // Definição de Variável
        double peso, altura, imc;


        // Solicita o peso do usuário
        System.out.print("\nInforme o seu peso (Ex: 100): ");
        peso = ler.nextDouble();

        // Solicita a altura do usuário
        System.out.print("\nInforme sua altura (Ex: 1.90): ");
        altura = ler.nextDouble();

        // Cálcula o IMC
        imc = peso / (altura * altura);

        // Informa o resultado do cálculo
        System.out.printf("Seu imc e: %.2f%n", imc);

        ler.close();  // Fecha o scanner
    }
}
