package applocadora;

/**
 * @author julio_busarello
 */
public class AppLocadora {

    public static void main(String[] args) {
        // Gerenciando a frota de veiculos1

        // Instanciando objetos
        // tp = 1 Gaso; 2 Alcool; 3 Flex
        Carro carro1 = new Carro("GOL G3", "PRETO", "AP 1.8" , 3);
        
        carro1.qtdCombustivel = 35.0;
        

        carro1.printStatus();

        System.out.println("------------------------------------");
    }

}
