
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {

    public Main() {
        setTitle("Título"); // Título da Janela
        setSize(350, 240); // Tamanho da Janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Encerra o processo quando fecha
        setLocationRelativeTo(null); // A janela abre centralizada na tela
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(); // Instanciar objeto
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(350, 200));

        JLabel lblNome = new JLabel("Nome: ");
        lblNome.setBounds(20, 10, 100, 30);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(90, 10, 200, 30);

        JLabel lblSobrenome = new JLabel("Sobrenome: ");
        lblSobrenome.setBounds(20, 60, 100, 30);

        JTextField txtSobrenome = new JTextField();
        txtSobrenome.setBounds(90, 60, 200, 30);

        JButton addButton = new JButton("Exibir Mensagem");
        addButton.setBounds(15, 110, 300, 30);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txtNome.getText().isEmpty() || !txtSobrenome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Bem vindo " + txtNome.getText() + " " + txtSobrenome.getText() + "!");
                } else {
                    JOptionPane.showMessageDialog(null, "Algum campo está vazio!");
                }
            }
        });

        JButton clsButton = new JButton("Finalizar");
        clsButton.setBounds(15, 150, 300, 30);

        clsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Finalizando Sistema!");
                System.exit(0);
            }
        });

        add(addButton);
        add(clsButton);
        add(txtNome);
        add(lblNome);
        add(txtSobrenome);
        add(lblSobrenome);
        add(panel);
    }

    public static void main(String[] args) throws Exception {
        Main frame = new Main();
        frame.setVisible(true);
    }
}
