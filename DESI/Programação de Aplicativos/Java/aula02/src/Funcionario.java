import java.util.Scanner;
import java.util.Locale;

import entities.Employee;

public class Funcionario {
    public static void main(String[] args) throws Exception {
        // Definindo a língua do código
        Locale.setDefault(Locale.US);

        // Criando um novo Scanner
        Scanner ler = new Scanner(System.in);

        // Definição de Variáveis
        Employee funcionario = new Employee();

        System.out.print("Name: ");
        funcionario.name = ler.nextLine();
        System.out.print("Gross salary: ");
        funcionario.grossSalary = ler.nextDouble();
        System.out.print("Tax: ");
        funcionario.tax = ler.nextDouble();

        System.out.println("\nEmployee: "+funcionario.name+", $"+funcionario.netSalary());

        System.out.print("\nWhich percentage to increase salary? ");
        funcionario.increaseSalary(ler.nextDouble());

        System.out.println("\nUpdated data: "+funcionario.name+", $"+funcionario.netSalary());
        ler.close();
    }
}
