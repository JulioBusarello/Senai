import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MySwingWorker extends SwingWorker<Void, String> {
    private final String filePath;
    private final JTextArea textArea;
    private final JButton button;
    private final JProgressBar progressBar;
    private final JTextField textField;
    private final int time;
    private final int totalLines;
    private int readLines;

    public MySwingWorker(String filePath, JTextArea textArea, JTextField textField, int time, JProgressBar progressBar,
            JButton button) {
        this.filePath = filePath;
        this.textArea = textArea;
        this.button = button;
        this.textField = textField;
        this.time = time;
        this.progressBar = progressBar;
        this.totalLines = CountTotalLines(filePath);
    }

    @Override
    protected Void doInBackground() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            button.setEnabled(false);
            button.setText("Tarefa em Andamento");

            while ((line = reader.readLine()) != null) {
                Thread.sleep(time);
                publish(line);
                readLines++;
            }
        } catch (IOException | InterruptedException e) {
            viewError("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String chunk : chunks) {
            textArea.append(chunk + "\n");
            textField.setText(chunk);
            int progress = (int) ((readLines / (double) totalLines) * 100);
            progressBar.setValue(progress);
        }
    }

    @Override
    protected void done() {
        button.setEnabled(true);
        button.setText("Iniciar a Leitura");
    }

    // -- Meus métodos

    private int CountTotalLines(String filePath) {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            viewError("Erro ao ler o arquivo: " + e.getMessage());
        }
        return lineCount;
    }

    private void viewError(final String msg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(textArea.getParent(), msg, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
