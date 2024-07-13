
import java.util.Scanner;
import java.util.Stack;

/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Stack par = new Stack();
        Stack impar = new Stack();
        int v = 0;
        int elemento;
        do {
            System.out.println("Informe um numero: ");
            elemento = ler.nextInt();
            if (elemento == 0) {
                if (!par.empty() && !impar.empty()) {
                    System.out.println("Voce removeu o elemento "+par.pop()+" da pilha par");
                    System.out.println("Voce removeu o elemento "+impar.pop()+" da pilha impar");
                } else {
                    System.out.println("Erro, pilha vazia");
                }
            } else if (elemento % 2 == 0) {
                System.out.println(elemento+" empilhado na pilha par");
                par.push(elemento);
            } else {
                System.out.println(elemento+" empilhado na pilha impar");
                impar.push(elemento);
            }
            v++;
        } while (v <= 10);
    }

}
