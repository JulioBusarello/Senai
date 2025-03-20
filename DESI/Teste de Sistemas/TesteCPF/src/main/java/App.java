
import javax.swing.JOptionPane;

/**
 * @author julio_busarello
 */
public class App {
    private static Verificador verificador = new Verificador();

    public static void main(String[] args) throws Exception {
        String cpf = JOptionPane.showInputDialog(null, "Informe o CPF a ser validado:");
        String validacao = verificador.validarCpf(cpf);

        switch (validacao) {
            case "contemletras" -> {
                JOptionPane.showMessageDialog(null, "CPF inválido, não pode conter letras!", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
            case "digitosiguais" -> {
                JOptionPane.showMessageDialog(null, "CPF inválido, não é permitido que todos os dígitos sejam iguais!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
            case "menosdigitos" -> {
                JOptionPane.showMessageDialog(null, "CPF inválido, possui menos que 11 dígitos", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
            case "maisdigitos" -> {
                JOptionPane.showMessageDialog(null, "CPF inválido, possui mais que 11 dígitos", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
            case "valido" -> {
                JOptionPane.showMessageDialog(null, "O CPF informado é Válido!", "Válido",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            default -> {
                JOptionPane.showMessageDialog(null, "O CPF informado é Inválido!", "Inválido",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
