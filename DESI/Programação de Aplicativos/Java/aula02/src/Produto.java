import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Produto {
    public static void main(String[] args) throws Exception {
        // Definindo a língua do código
        Locale.setDefault(Locale.US);

        // Criando um novo Scanner
        Scanner ler = new Scanner(System.in);

        // Definição de Variáveis
        Product produto;
        produto = new Product();
        
        System.out.print("Enter the product data:");
        System.out.print("\nName: ");
        produto.name = ler.nextLine();
        System.out.print("Price: ");
        produto.price = ler.nextDouble();
        System.out.print("Quantity in stock: ");
        produto.quantity = ler.nextInt();


        System.out.println("\n"+produto.toString());

        System.out.print("\nEnter the number of products to be added in stock: ");
        produto.addProducts(ler.nextInt());

        System.out.println("\n"+produto.toString());

        System.out.print("\nEnter the number of products to be removed in stock: ");
        produto.removeProducts(ler.nextInt());

        System.out.println("\n"+produto.toString());

        ler.close();
    }
}
