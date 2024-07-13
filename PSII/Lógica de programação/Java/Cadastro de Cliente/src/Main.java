
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        // ----- Janela
        JFrame form = new JFrame();

        form.setSize(500, 400);
        form.setTitle("Cadastro de Clientes");
        form.setLayout(null);
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ----- Textos
        // Texto do Titulo
        JLabel titulo = new JLabel();

        titulo.setText("Cadastro de Cliente");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBounds(30, 10, 180, 30);

        // Texto do Nome
        JLabel nome = new JLabel();

        nome.setText("Nome");
        nome.setFont(new Font("Arial", Font.PLAIN, 14));
        nome.setBounds(50, 50, 40, 30);

        JLabel cpf = new JLabel();

        cpf.setText("CPF");
        cpf.setFont(new Font("Arial", Font.PLAIN, 14));
        cpf.setBounds(56, 90, 40, 30);

        // Texto do Email
        JLabel email = new JLabel();

        email.setText("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 14));
        email.setBounds(49, 130, 40, 30);

        // Texto do Telefone
        JLabel telefone = new JLabel();

        telefone.setText("Telefone");
        telefone.setFont(new Font("Arial", Font.PLAIN, 14));
        telefone.setBounds(30, 170, 60, 30);

        // Adiciona todos os textos ao Form
        form.add(titulo);
        form.add(nome);
        form.add(cpf);
        form.add(email);
        form.add(telefone);

        // ----- Caixas de texto
        // Caixa de texto do Nome
        JTextField caixaNome = new JTextField();

        caixaNome.setBounds(120, 50, 300, 30);

        // Caixa de texto do CPF
        JTextField caixaCpf = new JTextField();

        caixaCpf.setBounds(120, 90, 300, 30);

        // Caixa de texto do Email
        JTextField caixaEmail = new JTextField();

        caixaEmail.setBounds(120, 130, 300, 30);

        // Caixa de texto do Telefone
        JTextField caixaTelefone = new JTextField();

        caixaTelefone.setBounds(120, 170, 300, 30);

        // Adiciona todas as caixas de texto ao Form
        form.add(caixaNome);
        form.add(caixaCpf);
        form.add(caixaEmail);
        form.add(caixaTelefone);

        // ----- Botoes
        // Botao Cadastrar
        JButton cadastrar = new JButton("Cadastrar");

        cadastrar.setBounds(20, 250, 100, 25);
        cadastrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou o botão cadastrar");
            }  
        });

        // Botao Limpar
        JButton limpar = new JButton("Limpar");

        limpar.setBounds(130, 250, 100, 25);
        limpar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou o botão limpar");
            }  
        });

        // Botao Fechar
        JButton fechar = new JButton("Fechar");

        fechar.setBounds(240, 250, 100, 25);
        fechar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou o botão fechar");
            }  
        });

        // Botao Busca
        JButton busca = new JButton("Busca");

        busca.setBounds(350, 250, 100, 25);
        busca.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou o botão busca");
            }  
        });

        // Botao Alterar
        JButton alterar = new JButton("Alterar");

        alterar.setBounds(20, 290, 100, 25);
        alterar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou o botão alterar");
            }  
        });

        // Adiciona todos os botoes ao Form
        form.add(cadastrar);
        form.add(limpar);
        form.add(fechar);
        form.add(busca);
        form.add(alterar);
        
        // Torna o form visivel
        form.setVisible(true);
    }

}
