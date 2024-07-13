
import java.util.Scanner;

/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        Pilha p1 = new Pilha(50);
        Scanner ler = new Scanner(System.in);
        int option, elemento, nElementos=0;
        String vazio;
        boolean continuar = true;
        
        do{
            System.out.println("======= MENU =======");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Desempilhar");
            System.out.println("3 - Vazio");
            System.out.println("4 - Printar");
            System.out.println("5 - Ultimo elemento");
            System.out.println("0 - Sair");
            System.out.println("====================");
            System.out.print("Informe uma opcao: ");
            option = ler.nextInt();

            switch(option){
                case 1:
                    System.out.println("Informe o elemento a ser empilhado: ");
                    elemento = ler.nextInt();
                    p1.empilha(elemento);
                    nElementos += 1;
                break;
                case 2:
                    System.out.println("Voce desempilhou");
                    p1.desempilha();
                    nElementos -= 1;
                break;
                case 3:
                    if(p1.vazia()){
                        vazio = "vazia";
                    }else{
                        vazio = "com "+nElementos+" elementos";
                    }
                    System.out.println("A pilha esta: "+vazio);
                break;
                case 4:
                    p1.print();
                break;
                case 5:
                    System.out.println("O ultimo elemento foi: "+p1.topo());
                break;
                default:
                    continuar = false;
            }
        }while(continuar);
    } 
    
}
