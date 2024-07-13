/**
 *
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        byte tpConta = 0;
        Conta conta1 = new Conta("Wilian", tpConta, 1, 500);
        
        conta1.setSaldo(1000);
        
        conta1.verStatus();
        conta1.sacar(1000);
        conta1.verStatus();
    }
    
}
