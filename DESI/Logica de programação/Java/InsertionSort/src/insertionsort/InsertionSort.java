package insertionsort;

import java.util.Scanner;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random rand = new Random();
        
        // Variaveis
        int tam = 10;
        int vetor[] = new int[tam];
        int indice;
        int elementoAtual;
        
        for(int i = 0; i < tam; i++){
            int int_random = rand.nextInt(50);
            vetor[i] = int_random;
        }
        
        System.out.println("Vetor original: ");
        for(int i = 0; i < tam; i++){
            System.out.print(vetor[i]+ " ");
        }
        
        for(int i = 1; i < tam; i++){
            elementoAtual = vetor[i];
            indice = i;
            while(indice > 0 && vetor[indice-1] > elementoAtual){
                vetor[indice] = vetor[indice-1];
                indice--;
            }
            vetor[indice] = elementoAtual;    
        }
        
        System.out.println("");
        System.out.println("Vetor ordenado: ");
        for(int i = 0; i < tam; i++){
            System.out.print(vetor[i] + " ");
        }
    }
    
}
