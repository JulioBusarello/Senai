
import java.util.Scanner;

/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        Fila f = new Fila();
        Scanner ler = new Scanner(System.in);
        int option, nElementos=0;
        String vazio, nome = "";
        boolean continuar = true;
        
        do{
            System.out.println("======= MENU =======");
            System.out.println("1 - Adicionar nome");
            System.out.println("2 - Remover nome no inicio da fila");
            System.out.println("3 - Retornar nome no inicio da fila");
            System.out.println("4 - Verificar se esta vazia");
            System.out.println("0 - Sair");
            System.out.println("====================");
            System.out.print("Informe uma opcao: ");
            option = ler.nextInt();

            switch(option){
                case 1:
                    System.out.print("Informe o nome: ");
                    nome = ler.next();
                    f.adicionar(nome);
                    nElementos++;
                break;
                case 2:
                    System.out.println("Você removeu o nome");
                    f.remover();
                    nElementos--;
                break;
                case 3:
                    System.out.println(nome);
                break;
                case 4:
                    if(f.estaVazia()){
                        vazio = "A lista esta vazia";
                    }else{
                        vazio = "Existem "+nElementos+" elementos na lista";
                    }
                    System.out.println(vazio);
                break;
                default:
                    continuar = false;
            }
        }while(continuar);
    } 
    
}
