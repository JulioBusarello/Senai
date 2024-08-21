import java.util.Locale;
import java.util.Scanner;

import entities.MediaFunc;

public class Media {
    public static void main(String[] args) throws Exception {
        // Definindo a língua do código
        Locale.setDefault(Locale.US);

        // Criando um novo Scanner
        Scanner ler = new Scanner(System.in);

        // Definindo Variáveis
        MediaFunc x;
        x = new MediaFunc();

        // Solicitando notas
        System.out.println("Enter whit the notes: ");
        x.nota1 = ler.nextDouble();
        x.nota2 = ler.nextDouble();
        x.nota3 = ler.nextDouble();
        x.nota4 = ler.nextDouble();

        // Verificando estado do aluno
        System.out.printf("Final media is: %.2f%n", x.finalMedia());
        if(x.finalMedia() >= 7){
            System.out.println("The student is Approved");
        }else if(x.finalMedia() < 5){
            System.out.println("The student is Reproved");
        }else{
            System.out.println("The student is at Recuperation");
        }
        ler.close();
    }
}
