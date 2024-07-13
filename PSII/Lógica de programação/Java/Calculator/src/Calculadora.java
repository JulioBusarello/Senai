
/**
 * @author julio_busarello
 */
public class Calculadora {

    private char par; // Verifica se os pares de "(" , "[" ou "{" estão corretos
    private boolean ok = true; // Retorno do método expOk()
    private String infixa; // Recebe a expressão INFIXA para decompor

    private String[] expInfixa = new String[50]; // Guarda a expressao infixa decomposta em um valor

    private double resultado; // Guarda o resultado da expressão calculada

    private String[] npr = new String[100];
    private String input = "";

    // Construtor da classe
    public Calculadora() {

    }

    // ----- Metodos
    // Avaliar a expressão
    public String evalExp(String strInFixa) {
        if (expOk(strInFixa)) {
            this.expInfixa = decompor(strInFixa);
            this.npr = posFixa();
            System.out.println("Expressão Balanceada!");

            for (int i = 0; npr[i] != null; i++) {
                System.out.println(npr[i] + " ");
            }
            this.resultado = calcular();
        } else {
            System.out.println("Expressão Não Balanceada");
        }

        return String.valueOf(resultado);
    }

    // Verificar se a expressão esta ok (balanceada)
    public boolean expOk(String str) {
        Pilha p = new Pilha();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '(') {
                p.empilha(str.charAt(i));
            } else if (str.charAt(i) == ']' || str.charAt(i) == ')') {
                if (!p.vazia()) {
                    par = p.desempilha().toString().charAt(0);
                } else {
                    ok = false;
                }
                if (par != '[' && par != '(') {
                    ok = false;
                }
            }
        }
        if (!p.vazia()) {
            ok = false;
        }
        return ok;
    }

    // Decompor a String da expressão infixa em um vetor de Strings
    public String[] decompor(String str) {
        this.infixa = str;
        String[] arrayInfixa = new String[50];

        int indexIni = 0;
        boolean operando = false;
        boolean fimOperando = true;
        int indexArray = 0;

        for (int x = 0; x < infixa.length(); x++) {
            char ch = infixa.charAt(x);
            if ((ch >= '0') && (ch <= '9')) {
                operando = true;
                fimOperando = false;
            } else if ((ch == '(') || (ch == ')') || (ch == '*') || (ch == '/') || (ch == '+') || (ch == '-')) {
                if (operando) {
                    fimOperando = true;
                } else {
                    operando = false;
                    fimOperando = false;
                }
            }
            if (operando && fimOperando) { // Se era um operando e terminou
                // Coloca operando na matriz
                arrayInfixa[indexArray] = infixa.substring(indexIni, x);
                indexArray++;
                operando = false;
                indexIni = x;

                // Coloca operador na matriz
                arrayInfixa[indexArray] = infixa.substring(indexIni, x + 1);
                indexArray++;
                indexIni = x + 1;

            } else if (!operando && !fimOperando) { // Se era um operador coloca na matriz
                arrayInfixa[indexArray] = infixa.substring(indexIni, x + 1);
                indexArray++;
                indexIni = x + 1;
            }
        }
        if (indexIni < infixa.length()) { // Atualiza o restante da expressão
            arrayInfixa[indexArray] = infixa.substring(indexIni, infixa.length());
        }
        this.expInfixa = arrayInfixa; // Atualiza a variável expInfixa

        return arrayInfixa;
    }

    public String[] posFixa() {
        String[] arrayNpr = new String[100];
        Pilha p = new Pilha();
        int indexArray = 0;

        for (int i = 0; expInfixa[i] != null; i++) {
            String valor = expInfixa[i];

            if (valor.charAt(0) == '+' || valor.charAt(0) == '-' || valor.charAt(0) == '*' || valor.charAt(0) == '/') {
                while (!p.vazia() && pri(p.topo().toString().charAt(0)) >= pri(valor.charAt(0))) {
                    arrayNpr[indexArray] = p.desempilha().toString();
                    indexArray++;
                }
                p.empilha(valor);
            } else if (valor.charAt(0) == '(') {
                p.empilha(valor);
            } else if (valor.charAt(0) == ')') {
                while (p.topo().toString().charAt(0) != '(') {
                    arrayNpr[indexArray] = p.desempilha().toString();
                    indexArray++;
                }
                p.desempilha();
            } else {
                arrayNpr[indexArray] = valor;
                indexArray++;
            }
        }
        while (!p.vazia()) {
            arrayNpr[indexArray] = p.desempilha().toString();
            indexArray++;
        }
        return arrayNpr;
    }

    // Criar a operação
    public double calcular() {
        Pilha p = new Pilha();
        double res = 0;
        for (int i = 0; npr[i] != null; i++) {
            input = npr[i];

            //1º Verificar se é operando ou operador
            //Criar a operação ==> Resultado = esquerdo OPERA direito (res
            //Calcular a operação e retornar o valor
            if (isOperando(input)) {
                p.empilha(Double.parseDouble(input));
            } else if (isOperador(input)) {
                double atual = fazOperacao(input, p);
                p.empilha(atual);
            }
        }
        return res;
    }

    public double fazOperacao(String operador, Pilha p) {
        double temp;
        if (p.vazia()) {
            temp = 0;
        } else {
            temp = Double.parseDouble(p.desempilha().toString());
        }
        if (!p.vazia()) {
            temp = calcValores(operador, Double.parseDouble(p.desempilha().toString()), temp);
        }
        return temp;
    }

    public double calcValores(String operador, double esquerdo, double direito) {
        if (operador.equals("+")) {
            return esquerdo + direito;
        } else if (operador.equals("-")) {
            return esquerdo - direito;
        } else if (operador.equals("*")) {
            return esquerdo * direito;
        } else if (operador.equals("/")) {
            if (direito == 0) {
                System.out.println("Erro: não pode dividir por zero");
                return esquerdo;
            }
            return esquerdo / direito;
        } else {
            return esquerdo;
        }
    }

    public boolean isOperador(String input) {
        if (input == null) {
            return false;
        }
        return input.equals("+") || input.equals("-")
                || input.equals("*") || input.endsWith("/");
    }

    public boolean isOperando(String input) {
        if (input == null) {
            return false;
        }

        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private int pri(char op) {
        int nPri = 0;
        if (op == '/' || op == '*') {
            nPri = 3;
        }
        if (op == '+' || op == '-') {
            nPri = 2;
        }
        if (op == '(') {
            nPri = 1;
        }
        return nPri;
    }
}
