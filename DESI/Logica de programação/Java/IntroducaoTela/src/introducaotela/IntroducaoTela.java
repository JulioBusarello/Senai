package introducaotela;

import javax.swing.JOptionPane;

public class IntroducaoTela {

    public static void main(String[] args) {
        System.out.println("Bolo de morango");
        //JOptionPane.showMessageDialog(null, "Uauuuu!!!");

        String name, status;
        int idade;
        float salario;
        
        
        if (idade < 18) {
            status = "Menor";

        } else {
            status  = "Maior";
        }
        
        JOptionPane.showMessageDialog(null, "Seu nome é: "+ name +"\nSua idade é: "+ idade +" ("+ status+")\nSeu salário é: R$ "+ salario);
    }

}
