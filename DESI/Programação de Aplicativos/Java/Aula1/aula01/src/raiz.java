import java.util.Locale;
import java.util.Scanner;

public class raiz {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);
        
        double valor;

        System.out.print("\nInsira o valor: ");
        valor = ler.nextDouble();

        System.out.printf("O valor da raiz quadrada é: %.2f%n", Math.sqrt(valor));
        ler.close();
    }
}
