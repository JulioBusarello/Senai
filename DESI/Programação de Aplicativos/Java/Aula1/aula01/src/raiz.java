import java.util.Locale;
import java.util.Scanner;

public class raiz {
    public static void main(String[] args) throws Exception {
        // Definindo a língua do código
        Locale.setDefault(Locale.US);
        // Criando um novo Scanner
        Scanner ler = new Scanner(System.in);
        // Definição de Variável
        double valor;
        
        // Pede o valor
        System.out.print("\nInsira o valor: "); 
        valor = ler.nextDouble();  // Armazena o valor informado

        // Escreve o resultado
        System.out.printf("O valor da raiz quadrada é: %.2f%n", Math.sqrt(valor));

        ler.close(); // Fecha o scanner
    }
}
