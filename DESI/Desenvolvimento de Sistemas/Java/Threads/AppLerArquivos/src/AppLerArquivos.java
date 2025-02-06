import javax.swing.*;
import java.awt.*;

public class AppLerArquivos extends JFrame {

    private JTextArea textArea1;
    private JTextArea textArea2;

    public AppLerArquivos() {
        // Configurando o JFrame
        setTitle("Leitor de Arquivos Texto ");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Inicializando o JTextArea
        textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setFont(new Font("Serif", Font.PLAIN, 16));

        textArea2 = new JTextArea();
        textArea2.setEditable(false);
        textArea2.setFont(new Font("Serif", Font.PLAIN, 16));

        // Adicionando o JTextArea a um JScrollPane para permitir rolagem
        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        scrollPane1.setBounds(10, 10, 200, 300);
        add(scrollPane1, BorderLayout.CENTER);

        JScrollPane scrollPane2 = new JScrollPane(textArea2);
        scrollPane2.setBounds(280, 10, 200, 300);
        add(scrollPane2, BorderLayout.CENTER);
    }

    public void lerArquivos(String filePath1, String filePath2) {
        // Criando instâncias de FileLoaderTask para cada arquivo

        TarefaLerArquivo task1 = new TarefaLerArquivo(filePath1, textArea1);
        TarefaLerArquivo task2 = new TarefaLerArquivo(filePath2, textArea2);

        // Criando threads para cada tarefa de leitura de arquivo
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Iniciando as threads
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppLerArquivos gui = new AppLerArquivos();
                gui.setVisible(true);

                gui.lerArquivos("./arquivo1.txt", "./arquivo2.txt");
            }
        });
    }
}
