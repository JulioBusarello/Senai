
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        // RETIRE OS "//" EM FRENTE A CADA QUESTAO PARA EXECUTA-LAS.
        
        //questao1();
        //questao2();
        //questao3();
        //questao4();
        //questao5();
        //questao6();
    }
    
    // QUESTAO 1
    public static void questao1() {
        Scanner ler = new Scanner(System.in);
        /*
        1- Pedir 5 numeros pro usuário e armazenar em um vetor. mostrar o maior, menor, media e soma.
        Usuário deverá informar um valor e o algoritmo deverá consultar pra ver se ele existe
        */
    
        int numero[] = new int[5];
        int media = 0,soma = 0, tam = 5, elementoAtual, indice;
        
        for(int i =0; i < tam; i++){
            System.out.println("Informe um numero: ");
            numero[i] = ler.nextInt();
        }
        
        for(int i = 1; i < tam; i++){
            elementoAtual = numero[i];
            indice = i;
            while(indice > 0 && numero[indice-1] > elementoAtual){
                numero[indice] = numero[indice-1];
                indice--;
            }
            numero[indice] = elementoAtual;    
        }
        
        for(int i =0; i < tam; i++){
            soma += numero[i];
        }
        media = soma / tam;
        
        System.out.println("Maior valor: "+numero[tam-1]);
        System.out.println("Menor valor: "+numero[0]);
        System.out.println("Soma dos valor: "+soma);
        System.out.println("Media dos valor: "+media);
    }
    
    // QUESTAO 2
    public static void questao2(){
        Scanner ler = new Scanner(System.in);
        /*
        2- Soma de Matrizes: Escreva um programa que receba duas matrizes bidimensionais de mesmo tamanho 
        e realize a soma entre elas, armazenando o resultado em uma terceira matriz. Em seguida, exiba a 
        matriz resultante.
        */
        
        int matriz[][] = new int[2][2];
        int matriz2[][] = new int[2][2];
        int matrizSoma[][] = new int[2][2];
        
        for(int i = 0; i < 2; i++){
            for(int a = 0; a < 2; a++){
                System.out.println("Informe um valor da matriz 1: ");
                matriz[i][a] = ler.nextInt();
                System.out.println("Informe um valor da matriz 2: ");
                matriz2[i][a] = ler.nextInt();
            }
        }
        for(int i = 0; i < 2; i++){
            for(int a = 0; a < 2; a++){
                matrizSoma[i][a] = matriz[i][a] + matriz2[i][a];
            }
        }
        for(int i = 0; i < 2; i++){
            for(int a = 0; a < 2; a++){
                System.out.print(matrizSoma[i][a]+" ");
            }
            System.out.println("");
        }
    }
    
    // QUESTAO 3
    public static void questao3(){
        Scanner ler = new Scanner(System.in);
        /*
        3- Faça um programa que receba uma matriz bidimensional e retorne sua matriz transposta. 
        A matriz transposta é obtida ao trocar as linhas pelas colunas.
        */
        
        int matriz[][] = new int[3][3];
        int matrizTrans[][] = new int[3][3];
        
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        
        for(int i = 0; i < linhas; i++){
            for(int j =0; j < colunas; j++){
                System.out.println("Informe um numero");
                matriz[i][j] = ler.nextInt();
            }
        }
        System.out.println("Matriz: ");
        for(int i = 0; i < linhas; i++){
            for(int j =0; j < colunas; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizTrans[j][i] = matriz[i][j];
            }
        }
        System.out.println("Matriz transposta: ");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matrizTrans[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    // QUESTAO 4
    public static void questao4(){
        Scanner ler = new Scanner(System.in);
        /*
        4- Escreva um programa que receba uma matriz bidimensional e exiba o maior valor em cada linha. 
        Por exemplo, para a matriz [[1, 2, 3], [4, 5, 6], [7, 8, 9]], o programa deve exibir: 3, 6, 9.
        */
        
        int matriz[][] = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.println("Informe um valor: ");
                matriz[i][j] = ler.nextInt();
            }
        }
        int[] lista = new int[9];
        int aux = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                lista[aux++] = matriz[i][j];
            }
        }
        Arrays.sort(lista);
        aux = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = lista[aux++];
            }
        }
        System.out.println("Maior valor da linha 1: "+matriz[0][2]);
        System.out.println("Maior valor da linha 2: "+matriz[1][2]);
        System.out.println("Maior valor da linha 3: "+matriz[2][2]);
    }
    
    // QUESTAO 5
    public static void questao5(){
        Scanner ler = new Scanner(System.in);
        /*
        5- Implemente um programa que realize a multiplicação entre duas matrizes bidimensionais. 
        O usuário deve informar as dimensões das matrizes e seus elementos. O programa deve exibir a 
        matriz resultante da multiplicação.
        */
        
        int colunas;
        int linhas;
        System.out.println("Informe o tamanho de colunas da matriz: ");
        colunas = ler.nextInt();
        System.out.println("Informe o tamanho de linhas da matriz: ");
        linhas = ler.nextInt();
        
        int matriz[][] = new int[linhas][colunas];
        int matriz2[][] = new int[linhas][colunas];
        int matrizMult[][] = new int[linhas][colunas];
        
        for(int i = 0; i < linhas; i++){
            for(int a = 0; a < colunas; a++){
                System.out.println("Informe um valor da matriz 1: ");
                matriz[i][a] = ler.nextInt();
                System.out.println("Informe um valor da matriz 2: ");
                matriz2[i][a] = ler.nextInt();
            }
        }
        for(int i = 0; i < linhas; i++){
            for(int a = 0; a < colunas; a++){
                matrizMult[i][a] = matriz[i][a] * matriz2[i][a];
            }
        }
        for(int i = 0; i < linhas; i++){
            for(int a = 0; a < colunas; a++){
                System.out.print(matrizMult[i][a]+" ");
            }
            System.out.println("");
        }
    }
    
    // QUESTAO 6
    public static void questao6(){
        Scanner ler = new Scanner(System.in);
        /*
        7- Escreva um programa que receba uma matriz bidimensional e exiba a média dos valores em cada coluna. 
        Por exemplo, para a matriz [[1, 2, 3], [4, 5, 6], [7, 8, 9]], o programa deve exibir: 4.0, 5.0, 6.0.
        */
        
        int matriz[][] = new int [3][3];
        int vetor[] = new int[3];
        
        for(int l = 0; l < matriz.length; l++){
            for(int c =0; c < matriz[0].length; c++){
                System.out.println("Informe um numero");
                matriz[l][c] = ler.nextInt();
            }
        }
        for(int l = 0; l < matriz.length; l++){
            for(int c = 0; c < matriz[0].length; c++){
                vetor[l] += matriz[c][l];
            }
        }
        for(int i = 0; i < matriz.length; i++){
            vetor[i] = vetor[i] / matriz.length;
            System.out.println(vetor[i]+" ");
        }
    }
}