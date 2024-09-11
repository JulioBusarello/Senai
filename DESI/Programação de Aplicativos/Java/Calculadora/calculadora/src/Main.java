
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {

    // Declaração das Variáveis
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel result;

    public Main() {
        setTitle("Calculadora");
        setSize(1000, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //num1Field.setBounds(200, 150, 100, 30);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        JButton addBotao = new JButton("+");
        JButton subBotao = new JButton("-");
        JButton multBotao = new JButton("*");
        JButton divBotao = new JButton("/");
        result = new JLabel("Resultado");

        panel.add(new JLabel("Numero 1"));
        panel.add(num1Field);
        panel.add(new JLabel("Numero 2"));
        panel.add(num2Field);
        panel.add(addBotao);
        panel.add(subBotao);
        panel.add(multBotao);
        panel.add(divBotao);
        panel.add(result);
        add(panel);

        addBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacaoMatematica('+');
            }
        });
        subBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacaoMatematica('-');
            }
        });
        multBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacaoMatematica('*');
            }
        });
        divBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacaoMatematica('/');
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Main frame = new Main();
        frame.setVisible(true);
    }

    private void operacaoMatematica(char operador) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num1Field.getText());
            double resultado = 0;

            switch (operador) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = num1 / num2; 
                    }else {
                        result.setText("Erro: Divisão por 0!");
                        return;
                    }break;
                default:
                    break; 
            }
            result.setText("Resultado: " + resultado);
        } catch (Exception e) {
        }
    }
}
