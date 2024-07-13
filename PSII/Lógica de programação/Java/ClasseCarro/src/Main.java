
import Classes.Carro;
import java.util.Scanner;

/**
 *
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        // Carro - Classe
        // carro - objeto
        // Carro() - construct

        Carro carro = new Carro(); // Instancia
        carro.isStatus();
        byte option;
        do {
            System.out.println("===========  MENU  ==========");
            System.out.println("= 1 - Acelerar              =");
            System.out.println("= 2 - Frear                 =");
            System.out.println("= 3 - Ligar                 =");
            System.out.println("= 4 - Desligar              =");
            System.out.println("= 5 - Status                =");
            System.out.println("= 0 - Sair                  =");
            System.out.println("=============================");
            option = ler.nextByte();

            switch (option) {
                case 1:
                    System.out.println("Informe a velocidade: ");
                    carro.acelerar(ler.nextInt());
                    break;
                case 2:
                    System.out.println("Informe a velocidade");
                    carro.frear(ler.nextInt());
                    break;
                case 3:
                    carro.ligar();
                    break;
                case 4:
                    carro.desligar();
                    break;
                case 5:
                    carro.verStatus();
                    break;
                default:
                    break;
            }
        } while (option != 0);
    }

}
