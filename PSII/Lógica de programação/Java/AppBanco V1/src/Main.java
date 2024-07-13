/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        // Aqui fica a gerencia do POO
        System.out.println("=================================");
        System.out.println("= App de Gerenciamento do Banco =");
        System.out.println("=================================");
        
        // Instanciar um novo objeto Conta
        
        // Primeiro objeto
        Conta conta1 = new Conta();
        
        conta1.tpConta = 0;
        conta1.titular = "Amado Batista";
        conta1.limite = 1000.0;
        conta1.saldo = 500.0;
        conta1.nConta = 50;
        
        conta1.depositar(50);
        conta1.transferir(501, 100);
        conta1.status("conta1");
        
        // Segundo objeto
        Conta conta2 = new Conta();
        
        conta2.tpConta = '2';
        conta2.nConta = 100;
        conta2.titular = "Jorge Amado";
        conta2.saldo = 230.0;
        
        conta2.status("conta2");
    }
    
}