package main;

public class Main {
    
    public static void main(String[] args) {
        int[] vInt = new int[5];
        boolean[] vBool = new boolean[5];
        String[] vString = new String[5];
        int[] vInteiro = new int[5];
        
        System.out.println("Vetor de Inteiros utilizando o length");
        for(int i = 0; i < vInteiro.length; i++){
            System.out.println(vInteiro[i] + " ");
        }
        // Declarando e inicializando
        int[] vetorNumerosInicializado = new int[] {1,2,3,4,5};
        // Criando e inicializado
        int vetorEnxuto[] = {7,8,9,10,11};
        
        int i = 0;
        System.out.println("Vetor de Inteiros Inicializado");
        while(i < 5){
            System.out.println(vetorNumerosInicializado[i] + "");
            i++;
        }
        i = 0;
        System.out.println("Vetor de Inteiros Inicializado Enxuto");
        while(i < 5){
            System.out.println(vetorEnxuto[i] + "");
            i++;
        }
        i = 0;
        System.out.println("Vetor de Menorzinho");
        while(i < 5){
            System.out.println(vInt[i] + " ");
            i++;
        }
        i = 0;
        System.out.println("Vetor de Booleans");
        while(i < 5){
            System.out.println(vBool[i] + " ");
            i++;
        }
        i = 0;
        System.out.println("Vetor de Strings");
        while(i < 5){
            System.out.println(vString[i] + "");
            i++;
        }
        
        // Matrizes
        int matriz1[][] = new int[2][2];
        int[][] matriz2 = new int[2][2];
        int[][] matriz3 = {{1,2},{3,4}};
        
        for(int j =0; j < 2; j++){
            for(int k =0; k < 2; k++){
                System.out.println("Matriz: L: "+j+" C: "+k+". Valor: "+matriz3[j][k]+".");
            }
        }
    }
}
