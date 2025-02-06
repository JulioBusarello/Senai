import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LerArquivos implements Runnable {

    private final String filePath;
    private final JTextArea textArea;
    private final JTextField textField;
    private final int tempo;
    private final int totalLinhas;
    private final JProgressBar progressBar;
    private int linhasLidas;
    int progresso;
    private JButton button;

    public LerArquivos(String filePath, JTextArea textArea, JTextField text, int tempo, JProgressBar progresso,
            JButton button) {
        this.filePath = filePath;
        this.textArea = textArea;
        this.textField = text;
        this.tempo = tempo;
        this.progressBar = progresso;
        this.totalLinhas = contaTotalLinhas(filePath);
        this.button = button;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Thread.sleep(tempo);

                final String finalLinha = linha;
                SwingUtilities.invokeLater(() -> {
                    textArea.append(finalLinha + "\n");
                    textField.setText(finalLinha);
                });

                linhasLidas++;
                int progresso = (int) ((linhasLidas / (double) totalLinhas) * 100);
                final int progressoFinal = progresso;
                SwingUtilities.invokeLater(() -> progressBar.setValue(progressoFinal));

                button.setEnabled(false);
            }
            button.setEnabled(true);
        } catch (IOException e) {
            mostraErro("Erro ao ler o arquivo: " + e.getMessage());
        } catch (InterruptedException e) {
            mostraErro("A leitura do arquivo foi interrompida: " + e.getMessage());
        }

    }

    private int contaTotalLinhas(String filePath) {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            mostraErro("Erro ao ler o arquivo: " + e.getMessage());
        }
        return lineCount;
    }

    private void mostraErro(final String msg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(textArea.getParent(), msg, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
