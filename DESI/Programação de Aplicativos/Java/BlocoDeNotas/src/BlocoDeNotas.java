
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.FileChooserUI;

/**
 * @author julio_busarello
 */
public class BlocoDeNotas extends javax.swing.JFrame {

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu menuArquivo, menuEditar;
    private JMenuItem menuNovo, menuAbrir, menuSalvar, menuSair;
    private JMenuItem menuClaro, menuEscuro, menuFonte, menuPerso;
    private JLabel label;
    private int fontSize = 12;

    public BlocoDeNotas() {
        //initComponents();
        setTitle("Bloco de Notas");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // DISPOSE_ON_CLOSE, NOTHING_ON_CLOSE, HIDE_ON_CLOSE
        setLocationRelativeTo(null);
        //pack(); // Ajusta tela de acordo com os componentes
        setResizable(false);
        
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        Font font = new Font("Arial", Font.PLAIN, fontSize);
        textArea.setFont(font);

        add(scrollPane, BorderLayout.CENTER);
        
        label = new JLabel("ABC");
        
        add(label, BorderLayout.SOUTH);

        // Barra de menu
        menuBar = new JMenuBar();
        menuArquivo = new JMenu("Arquivo");
        menuEditar = new JMenu("Editar");
        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);

        // 
        menuNovo = new JMenuItem("Novo");
        menuAbrir = new JMenuItem("Abrir");
        menuSalvar = new JMenuItem("Salvar");
        menuSair = new JMenuItem("Sair");

        menuClaro = new JMenuItem("Tema claro");
        menuEscuro = new JMenuItem("Tema escuro");
        menuPerso = new JMenuItem("Tema personalizado");
        menuFonte = new JMenuItem("Tamanho fonte");

        menuArquivo.add(menuNovo);
        menuArquivo.add(menuAbrir);
        menuArquivo.add(menuSalvar);
        menuArquivo.addSeparator();
        menuArquivo.add(menuSair);

        menuEditar.add(menuClaro);
        menuEditar.add(menuEscuro);
        menuEditar.add(menuPerso);
        menuEditar.add(menuFonte);

        setJMenuBar(menuBar);

        menuNovo.addActionListener(e -> novoArquivo());
        menuAbrir.addActionListener(e -> abrirArquivo());
        menuSalvar.addActionListener(e -> salvarArquivo());
        menuClaro.addActionListener(e -> modoClaro());
        menuEscuro.addActionListener(e -> modoEscuro());
        menuFonte.addActionListener(e -> mudarFonte());
        menuPerso.addActionListener(e -> modoPersonalizado());
        menuSair.addActionListener(e -> System.exit(0));
    }

    private void novoArquivo() {
        if (textArea.getText().isEmpty()) {
            textArea.setText("");
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem alterações não salvas, deseja prosseguir?");
            if (option == 0) {
                textArea.setText("");
            }
        }

    }

    private void abrirArquivo() {
        JFileChooser arquivo = new JFileChooser();
        int option = arquivo.showOpenDialog(this);
        if (textArea.getText().isEmpty()) {
            textArea.setText("");
        } else {
            int asnwear = JOptionPane.showConfirmDialog(null, "Você tem alterações não salvas, deseja prosseguir?");
            if (asnwear == 0) {
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        File arquivoB = arquivo.getSelectedFile();
                        BufferedReader reader = new BufferedReader(new FileReader(arquivoB));
                        textArea.read(reader, null);
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private void salvarArquivo() {
        JFileChooser arquivo = new JFileChooser();
        int option = arquivo.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File arquivoB = arquivo.getSelectedFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoB));
                textArea.write(writer);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void modoClaro() {
        textArea.setBackground(Color.white);
        textArea.setForeground(Color.black);
    }

    private void modoEscuro() {
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
    }
    
    private void modoPersonalizado() {
        JColorChooser.showDialog(null, "Roleta cores", Color.white);
    }

    private void mudarFonte() {
        fontSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o tamanho da fonte", fontSize));
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        textArea.setFont(font);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlocoDeNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
