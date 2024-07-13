package insertionsortletras;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortLetras {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        String letras = new String();
        
        System.out.println("Entre com as letras: ");
        letras = ler.nextLine();
        
        char[] caracteres = letras.toCharArray();
        Arrays.sort( caracteres);
        
        String ordenada = new String( caracteres);
        System.out.println("Caracteres Ordenados: " + ordenada);
        
        ler.close();
    }
    
}
