package main;

import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author julio_busarello
 */
public class Main extends JFrame{

    public Main() {
        setTitle("Aplicativo Exemplo de Formulário");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel lblNome = new JLabel("Nome do Aluno");
        lblNome.setBounds(100, 50, 100, 30);
        
        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 80, 200, 30);
        
        add(lblNome);
        add(txtNome);
    }

    public static void main(String[] args) {
        Main form = new Main();
        form.setVisible(true);
    }  
}
