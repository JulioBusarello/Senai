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

        System.out.println("Name: ");
        funcionario.name = ler.nextLine();
        System.out.println("Gross salary: ");
        funcionario.grossSalary = ler.nextDouble();
        System.out.println("Tax: ");
        funcionario.tax = ler.nextDouble();

        System.out.println("Employee: "+funcionario.name+", $"+funcionario.netSalary());

        System.out.println("Which percentage to increase salary? ");
        funcionario.increaseSalary(ler.nextDouble());

        System.out.println("Updated data: "+funcionario.name+", $"+funcionario.grossSalary);
        ler.close();
    }
}
