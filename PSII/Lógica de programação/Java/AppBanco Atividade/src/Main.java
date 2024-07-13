
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * @author julio_busarello
 */
public class Main {

    //- ------  Utilitários  -------
    public static Conta[] conta = new Conta[100];
    public static Scanner ler = new Scanner(System.in);
    
    // --------  Variáveis  --------
    private static boolean autenticado;
    private static String titular;
    private static byte tpConta;
    private static double limite;
    private static int numero = 0;
    private static int nConta = 0;
    
    
    // -----  Funcões do banco  -----
    // Verificação inicial
    public static void main(String[] args) {
        byte reg;
        if(!autenticado){
            System.out.println("Você não está logado, escolha uma opção: ");
            System.out.println("1- Logar");
            System.out.println("2- Registrar");
            reg = ler.nextByte();
        }
    }
    
    // Menu opções
    private static void menu(){
        byte option;
        boolean continuar = true;
        
        do {
            System.out.println("====================================");
            System.out.println("= Aplicativo Gerenciador de Contas =");
            System.out.println("====================================");
            System.out.println("=               MENU               =");
            System.out.println("====================================");
            System.out.println("= 1 - Criar conta                  =");
            System.out.println("= 2 - Sacar                        =");
            System.out.println("= 3 - Listar conta                 =");
            System.out.println("= 4 - Depositar                    =");
            System.out.println("= 5 - Transferir                   =");
            System.out.println("= 6 - Verificar contas             =");
            System.out.println("= 7 - Fechar App                   =");
            System.out.println("====================================");
            System.out.print("Informe a opcao desejada: ");
            option = ler.nextByte();

            clearConsole();
            switch (option) {
                case 1: // Criar Conta
                    criarConta();
                    break;
                    
                case 2: // Sacar
                    sacar();
                    break;
                    
                case 3: // Listar Conta
                    status();
                    break;
                    
                case 4: // Depositar
                    depositar();
                    break;
                    
                case 5: // Transferir
                    transferir();
                    break;
                    
                case 6: // Verificar contas existentes
                    verContas();
                    break;
            }
        } while (continuar);
    }
    
    // Criar a conta do usuário
    private static void criarConta(){
        Scanner entrada = new Scanner(System.in);
        
        nConta++;
        // Pedindo nome do titular
        System.out.print("Informe seu nome completo: ");
        titular = entrada.nextLine();
        // Tipo de conta
        System.out.println("=====================");
        System.out.println("= 0 - C. Corrente   =");
        System.out.println("= 1 - C. Poupanca   =");
        System.out.println("= 2 - C. Salario    =");
        System.out.println("=====================");
        System.out.print("Informe o tipo de conta: ");
        tpConta = ler.nextByte();
        // Se for conta corrente pede o limite
        if (tpConta == 0) {
            System.out.print("Informe o limite da conta: ");
            limite = ler.nextDouble();
        }
        // Limpar console
        clearConsole();
        // Criar a conta
        conta[nConta] = new Conta(tpConta, nConta, titular, limite);
        
        System.out.println("O numero da sua conta e: " + nConta);
    }
    
    // Efetuar um saque
    private static void sacar(){
        System.out.println("Informe o numero da conta: ");
        numero = ler.nextInt();
        if (nConta < numero){
            System.err.println("X Conta inexistente");
        } else {
            System.out.print("Informe o valor que deseja sacar: ");
            conta[numero].sacar(ler.nextDouble());
        }
    }
    
    // Efetuar um deposito
    private static void depositar(){
        System.out.println("Informe o numero da conta para deposito: ");
        numero = ler.nextInt();
        if (nConta < numero){
            System.err.println("X Conta inexistente");
        } else {
            System.out.print("Informe o valor que deseja depositar: ");
            conta[numero].depositar(ler.nextDouble(), numero);
        }
    }
    
    // Efetuar uma transferência
    private static void transferir(){
        System.out.println("Informe o numero da sua conta: ");
        numero = ler.nextInt();
        if (nConta < numero){
            System.err.println("X Conta inexistente");
        } else {
            double vTransferir;
            String recebedor;
            int nRecebedor;
            System.out.print("Informe o valor que deseja transferir: ");
            vTransferir = ler.nextDouble();
            System.out.print("Informe o numero da conta do recebedor: ");
            nRecebedor = ler.nextInt();
            if (nConta < nRecebedor){
                System.err.println("X Conta inexistente");
            } else {
                recebedor = conta[nRecebedor].getTitular();
                conta[numero].transferir(vTransferir, recebedor);
                conta[nRecebedor].receber(vTransferir);
            }
        }
    }
    
    // Verificar os status da conta
    private static void status(){
        System.out.println("Informe o numero da conta a ser listada: ");
        numero = ler.nextInt();
        if (nConta < numero){
            System.err.println("X Conta inexistente");
        } else {
            conta[numero].verStatus(numero);
        }
    }
    
    // Verificar contas existentes
    private static void verContas(){
        if (nConta > 0) {
            System.out.println("================================");
            System.out.println("= Informando contas existentes =");
            System.out.println("================================");
            for (int i = 1; i <= nConta; i++) {
                System.out.println("Conta: " + conta[i].getTpConta());
                System.out.println("Titular: " + conta[i].getTitular());
                System.out.println("================================");
            }
        } else {
            System.err.println("X Nenhuma conta registrada");
        }
    }

    //Limpar Console
    public final static void clearConsole() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }
}
