public class Verificador {
    private String retorno = "";

    public String validarCpf(String cpf) {
        cpf = tratarCpf(cpf);

        if (cpf.length() < 11) {
            retorno = "menosdigitos";
        } else if (cpf.length() > 11) {
            retorno = "maisdigitos";
        }

        if (verificarIgualdade(cpf)) {
            retorno = "digitosiguais";
        }

        if (verificarLetras(cpf)) {
            retorno = "contemletras";
        }

        if (!retorno.equals("")) {
            return retorno;
        }

        if (verificarValidade(cpf)) {
            retorno = "valido";
        } else {
            retorno = "invalido";
        }

        return retorno;
    }

    private String tratarCpf(String cpf) {
        return cpf.replaceAll("[^0-9A-Za-z]", "");
    }

    private boolean verificarIgualdade(String cpf) {
        return cpf.matches("(\\d)\\1{10}");
    }

    private boolean verificarLetras(String cpf) {
        return cpf.matches(".*[A-Za-z].*");
    }

    private boolean verificarValidade(String cpf) {
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
