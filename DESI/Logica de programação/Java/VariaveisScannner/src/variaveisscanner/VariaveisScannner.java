package variaveisscanner;

import java.util.Scanner;

public class VariaveisScannner {

    public static void main(String[] args) {
        byte a = 2; //-128 a 127 = 1 byte
        short b = 0; //-32768 A 32767 = 2 bytes
        int c = 0; //-2147483648 a 2147483647 = 4 bytes
        long d = 0; //vai de 9 a uma porrada de números negativos e 9 a uma cacetada de números positivos
        boolean e = false; //1 bit
        char f = 'a'; //2 bytes
        float g = 3.21f; // 4 bytes
        double h = 6.31; //8 bytes
        
        Scanner ler = new Scanner(System.in);
        
        int n1, n2;
        
        System.out.println("Write a number: ");
        n1 = ler.nextInt();
        n2 = ler.nextInt();
        
        System.out.println("The result of the sum is: " +(n1+n2));
        
        if(n1+n2 > 10){
            System.out.println("The sum is bigger than 10");
        }
        else{
            System.out.println("The sum is smaller than 10");
        }
    }   
}