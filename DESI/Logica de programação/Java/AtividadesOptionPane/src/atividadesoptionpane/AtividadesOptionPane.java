package atividadesoptionpane;

import javax.swing.JOptionPane;

public class AtividadesOptionPane {

    public static void main(String[] args) {
        dolar();
        investimento();
        concessionaria();
        reajuste();
        consumo();
    }

    public static void dolar() {
        double dolar, cotacao;

        dolar = Double.parseDouble(JOptionPane.showInputDialog("Quantos dolares? "));
        cotacao = Double.parseDouble(JOptionPane.showInputDialog("Qual a cotação? "));

        JOptionPane.showMessageDialog(null, "Você tem R$:" + dolar * cotacao);
    }

    public static void investimento() {
        double deposito;
        deposito = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor depositado: "));

        JOptionPane.showMessageDialog(null, "Ao final do mês você terá: R$" + (deposito + (deposito * 0.009)));
    }

    public static void concessionaria() {
        double valor, pagar, desconto;
        int ano;

        valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do carro:"));
        ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do veículo: "));

        if (ano <= 2000) {
            desconto = 0.18;
        } else {
            desconto = 0.09;
        }

        JOptionPane.showMessageDialog(null, "O valor a ser pago é: R$" + (valor - (valor * desconto)));

    }

    public static void reajuste() {
        double salario, reajuste, salMin = 1100;

        salario = Double.parseDouble(JOptionPane.showInputDialog("Informe o salario: "));

        if (salario < 3 * salMin) {
            salario = salario + (salario * 0.50);
        } else if (salario < 10 * salMin) {
            salario = salario + (salario * 0.20);
        } else if (salario < 20 * salMin) {
            salario = salario + (salario * 0.15);
        } else {
            salario = salario + (salario * 0.10);
        }

        JOptionPane.showMessageDialog(null, "Seu novo salário é: R$" + salario);
    }

    public static void consumo() {
        double km;
        int combustivel;
        
        km = Double.parseDouble(JOptionPane.showInputDialog("Quantos Km foram percorridos? "));
        
        combustivel = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos litros foram gastos: "));
        
        JOptionPane.showMessageDialog(null, "A média foi de: "+(km/combustivel)+"Km/L");
    }
}
