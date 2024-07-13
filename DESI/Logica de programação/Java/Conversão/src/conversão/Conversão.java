package conversão;

import java.util.Scanner;

public class Conversão {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        int opcao;
        do{
            System.out.println("============== MENU ==============");
            System.out.println("1 - Converter moeda");
            System.out.println("2 - Converter velocidade");
            System.out.println("3 - Converter peso");
            System.out.println("4 - Converter comprimento");
            System.out.println("5 - Sair");
            System.out.println("===================================");
            System.out.println("Informe qual a conversao desejada: ");
            opcao = ler.nextInt();
        
            switch(opcao){
                case 1:
                    double cota, valor;
                    System.out.print("Informe o valor: ");
                    valor = ler.nextDouble();
                    System.out.print("Informe a cotacao: ");
                    cota = ler.nextDouble();
                    System.out.println("Valor da conversao: "+(valor*cota));
                    break;
                    
                case 2:
                    double conversao;
                    int km, escolha = 0;
                    System.out.print("Informe a velocidade em Km/h: ");
                    km = ler.nextInt();
                    System.out.println("======== Conversao ======");
                    System.out.println("1 - m/s: ");
                    System.out.println("2 - Mph/h: ");
                    System.out.println("3 - Velocidade da luz ");
                    System.out.println("=========================");
                    escolha = ler.nextInt();
                    
                    switch(escolha){
                        case 1:
                            conversao = km / 3.6;
                            System.out.println("A conversao de Km/h para m/s: "+ conversao);
                            break;
                        case 2:
                            conversao = km / 1.609;
                            System.out.println("A conversao de Km/h para Mph/h: "+ conversao);
                            break;
                        case 3:
                            conversao = km / 1079252848.7999;
                            System.out.println("A conversao de Km/h para Velocidade da Luz: "+ conversao);
                            break;
                        default:
                            System.out.println("Opcao Invalida");
                    }
                    
                    break;
                case 3:
                
                    break;
                case 4:
                
                    break;
                case 5:
                    System.out.println("Voce escolheu sair");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }while(opcao != 5);
    }
}
