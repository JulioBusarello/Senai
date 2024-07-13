
import java.io.*;
import java.util.*;

/**
 * @author julio_busarello
 */
public class Main {

    private static int codigo;
    private static String tam;
    private static String sabor1;
    private static String sabor2;
    private static String formato;
    private static int fatias;
    private static boolean borda;
    private static boolean premium;

    private static Scanner ler = new Scanner(System.in);
    private static ArrayList<Pizza> listap = new ArrayList<Pizza>();

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        byte option;
        do {
            System.out.println("========== MENU ==========");
            System.out.println("= 1 - Cadastrar Pizza    =");
            System.out.println("= 2 - Listar Pizza       =");
            System.out.println("= 3 - Alterar Pizza      =");
            System.out.println("= 4 - Apagar Pizza       =");
            System.out.println("= 5 - Deletar Pizza      =");
            System.out.println("= 6 - Recuperar Dados    =");
            System.out.println("= 0 - Sair               =");
            System.out.println("==========================");
            option = ler.nextByte();

            switch (option) {
                case 1:
                    cadastrarPizza();
                    break;
                case 2:
                    listarPizza();
                    break;
                case 3:
                    alterarPizza();
                    break;
                case 4:
                    apagarPizza();
                    break;
                case 5:
                    deletarPizza();
                    break;
                case 6:
                    recuperarDados();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (option != 0);
    }

    // Cadastra uma nova pizza
    private static void cadastrarPizza() {
        tam = ler.nextLine();
        System.out.println("Informe o tamanho da pizza: ");
        tam = ler.nextLine();
        System.out.println("Informe o 1º sabor: ");
        sabor1 = ler.nextLine();
        System.out.println("Informe o 2º sabor: ");
        sabor2 = ler.nextLine();
        System.out.println("Informe o formato da pizza: ");
        formato = ler.nextLine();
        System.out.println("Tera borda? (s/n)");
        String borda2 = ler.next();
        if ("s".equals(borda2)) {
            borda = true;
        } else {
            borda = false;
        }
        System.out.println("Sera premium? (s/n)");
        String premium2 = ler.next();
        if ("s".equals(premium2)) {
            premium = true;
        } else {
            premium = false;
        }
        System.out.println("Informe o numero de fatias: ");
        fatias = ler.nextInt();
        
        Pizza pizza = new Pizza(tam, sabor1, sabor2, formato, fatias, borda, premium);
        listap.add(pizza);
    }

    // Lista todas as informações da pizza
    private static void listarPizza() throws IOException {
        if (listap.isEmpty()) {
            System.err.println("Nenhuma pizza cadastrada");
            return;
        }
        FileWriter arquivo = new FileWriter("registro.txt", true);
        PrintWriter gravador = new PrintWriter(arquivo);
        String relatorio = "";

        gravador.printf("------- Lista de Pizzas -------\r\n");

        for (int i = 0; i < listap.size(); i++) {
            Pizza pizza = listap.get(i);

            relatorio ="- Tamanho: " + pizza.getTam()
                    + "\n- Sabor 1: " + pizza.getSabor1()
                    + "\n- Sabor 2: " + pizza.getSabor2()
                    + "\n- Fatias: " + pizza.getFatias()
                    + "\n- Formato: " + pizza.getFormato()
                    + "\n- Borda: " + (pizza.isBorda()? "Tem" : "Não tem")
                    + "\n- Premium: " + (pizza.isPremium()? "Sim" : "Não")
                    + "\n-------------------------------\n";
        }
        gravador.print(relatorio);
        System.out.println(relatorio);
        gravador.close();
    }

    // Alterar o tamanho da pizza
    private static void alterarPizza() {
        if (listap.size() == 0) {
            System.err.println("Nenhuma pizza cadastrada");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o codigo da pizza");
        int pesquisar = input.nextInt();
        for (int i = 0; i < listap.size(); i++) {
            Pizza alterarTam = listap.get(i);
            if (pesquisar == alterarTam.getCodigo()) {
                String debug = input.nextLine();
                System.out.println("Informe o novo tamanho");
                String novoTam = input.nextLine();

                alterarTam.setTam(novoTam);
                break;
            }
            System.out.println("Tamanho alterado com sucesso!");
        }
    }

    // Apaga uma pizza
    private static void apagarPizza() {
        if (listap.size() == 0) {
            System.err.println("Nenhuma pizza cadastrada");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o codigo da pizza");
        int pesquisar = input.nextInt();
        for (int i = 0; i < listap.size(); i++) {
            Pizza apagar = listap.get(i);
            if (pesquisar == apagar.getCodigo()) {
                listap.remove(i);
                System.out.println("Pizza apagada com sucesso! ");
            }
        }
    }

    // Deleta todas as pizzas
    private static void deletarPizza() {
        if (listap.size() == 0) {
            System.err.println("Nenhuma pizza cadastrada");
            return;
        }
        listap.clear();
        System.out.println("Todas pizzas apagadas com sucesso!");
    }

    // Mostra todas as pizzas que ja foram cadastradas
    private static void recuperarDados() throws IOException {
        String exib = "";
        String aarq = "registro.txt";
        String linha = "";
        File arq = new File(aarq);

        if (arq.exists()) {
            exib = "Recuperado \n";
            try {
                exib += "";
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    exib += linha + "\n";
                }
                leitor.close();
            } catch (Exception erro) {
            }
            System.out.println(exib);
        }
        FileWriter arquivo = new FileWriter("registro.txt", true);
        System.out.println("Todas recuperadas com sucesso!");
    }

}
