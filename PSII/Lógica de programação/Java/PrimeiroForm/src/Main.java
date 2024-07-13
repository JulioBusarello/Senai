
import java.awt.*;
import javax.swing.*;

/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        // ----- Janela
        JFrame form = new JFrame();

        // Define o tamanho da janela
        form.setSize(600, 400);
        // Define o titulo da janela
        form.setTitle("Exemplo de form em Java");
        // Define onde a janela vai abrir
        form.setLocationRelativeTo(null);
        // Define oq o X faz quando pressionado
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Faz a janela funcionar
        form.setVisible(true);

        // Tira o layout padrao da janela
        form.setLayout(null);

        // ----- Texto
        JLabel label = new JLabel();

        // Define o texto de label
        label.setText("Teste de label no form");
        // Define os parametros
        label.setBounds(50, 50, 200, 30);
        // Define a opacidade da label
        label.setOpaque(true);
        // Cria uma cor
        Color cor1 = new Color(255, 0, 0);
        Color cor2 = new Color(255, 255, 0);
        // Define a fonte a ser usada
        label.setFont(new Font("Arial", Font.BOLD, 14));
        // Seta a cor de label
        label.setForeground(cor2);
        label.setBackground(cor1);

        // Adiciona label ao formulario
        form.add(label);

        // ----- Caixa de texto
        JTextField nome = new JTextField();
        
        // Define os tamanhos da caixa de texto
        nome.setBounds(50, 90, 200, 30);
        // Adiciona a caixa de texto ao form
        form.add(nome);

        // ----- Botao
        JButton botao = new JButton("Confirmar");

        // Define as dimensões do botão
        botao.setBounds(50, 130, 200, 30);
        // Adiciona o botao ao form
        form.add(botao);
    }

}
