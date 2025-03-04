import java.util.HashMap;
import java.util.Map;

public class Verificador {
    private String retorno = "";

    public String validarCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9a-zA-Z]", "");

        if (cpf.length() == 11) { // Verificando se o CPF possui 11 dígitos
            if (!verificarIgualdade(cpf)) {
                if (!cpf.matches(".*[A-Za-z].*")) { // Verificando se o CPF não possui letras
                    if (verificarCpfValido(cpf)) {
                        retorno = "valido";
                    }
                } else {
                    retorno = "contemletras";
                }
            } else {
                retorno = "digitosiguais";
            }
        } else { // Caso não possua exatamente 11 dígitos
            if (cpf.length() < 11) { // Verifica se é menos ou mais que 11 dígitos
                retorno = "menosdigitos";
            } else {
                retorno = "maisdigitos";
            }
        }
        return retorno;
    }

    private boolean verificarIgualdade(String cpf) {
        boolean igual = false;
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : cpf.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 11) {
                igual = true;
            } else {
                igual = false;
            }
        }
        return igual;
    }

    private boolean verificarCpfValido(String cpf) {
        int calculoPrimeiro = 0;
        int calculoSegundo = 0;

        for (int i = 0; i < 9; i++) {
            calculoPrimeiro += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
        }
        calculoPrimeiro %= 11;
        if (calculoPrimeiro < 2) {
            calculoPrimeiro = 0;
        } else {
            calculoPrimeiro = 11 - calculoPrimeiro;
        }

        for (int i = 0; i < 10; i++) {
            calculoSegundo += Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i);
        }
        calculoSegundo %= 11;
        if (calculoSegundo < 2) {
            calculoSegundo = 0;
        } else {
            calculoSegundo = 11 - calculoSegundo;
        }

        int digito1 = Integer.parseInt(cpf.substring(9, 10));
        int digito2 = Integer.parseInt(cpf.substring(10, 11));

        return (calculoPrimeiro == digito1 && calculoSegundo == digito2);
    }

}
