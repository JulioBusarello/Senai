
/**
 * @author julio_busarello
 */
public class Conta {

    // ------------------------- Atributos de Classe -------------------------
    // tpConta = (0-C. Corrente 1-C. Poupança 2-C. Salario)
    /*private byte tpConta;
    private int nConta;
    private String titular;
    private double saldo = 0.0;
    private double limite = 0.0;
    private double limiteMax = 0.0;*/
    byte tpConta;
    int nConta;
    String titular;
    double saldo = 0.0;
    double limite = 0.0;
    double limiteMax = 0.0;

    // ------------------------ Construtor da Classe ----------------------- 
    public Conta(byte tpConta, int nConta, String titular, double limite) {
        this.titular = titular;
        this.tpConta = tpConta;
        this.nConta = nConta;
        this.limite = limite;
        this.limiteMax = limite;
    }

    // ------------------------ Getters and Setters ------------------------
    public void setTpConta(byte tpConta) {
        this.tpConta = tpConta;
    }
    
    public byte etTpConta() {
        return this.tpConta;
    }

    public String getTitular() {
        return titular;
    }

    // ------------------------- Métodos da Classe -------------------------
    // Efetuar um saque
    public void sacar(double vSaq) {
        if (this.saldo >= vSaq) { // Se o saldo cubrir o valor do saque
            this.saldo -= vSaq;
            System.out.println("- Saque no valor de R$" + vSaq + " com sucesso!");
        } else if (this.tpConta == 0 && this.saldo + this.limite >= vSaq) { // Se for conta corrente e o valor do saque for menor que o disponível no limite e no saldo
            this.limite -= vSaq - this.saldo;
            this.saldo = 0.0;
            System.out.println("- Saque no valor de R$" + vSaq + " utilizando seu limite com sucesso!");
        } else { // Se não possuir dinheiro para o saque
            System.err.println("X Saldo insuficiente para realizar o saque");
        }
        System.out.println("");
    }

    // Efetuar um depósito
    public void depositar(double vDep, int conta) {
        if (this.tpConta == 0) { // Se for conta corrente
            if (this.limite < limiteMax) { // Se o limite não estiver no máximo da conta executa
                this.limite += vDep; // Soma o limite com o deposito
                if (this.limite >= limiteMax) { // Se o valor de limite for maior que o máximo depois do deposito executa
                    this.limite -= limiteMax; // Calcula o que ficou a mais
                    this.saldo += this.limite; // Soma o saldo com o que ficou a mais
                    this.limite = limiteMax; // Volta o limite a 1000
                }
            } else { // Se não for menor que 1000
                this.saldo += vDep;
            }
        } else { // Se não for conta corrente soma normalmente
            this.saldo += vDep;
        }
        System.out.println("+ Deposito no valor de R$" + vDep + " na conta de: " + this.titular);
        System.out.println("");
    }

    // Fazer uma transferência
    public void transferir(double vTra, String user) {
        if (this.saldo >= vTra) {
            this.saldo -= vTra;
            System.out.println("- Transferencia no valor de R$" + vTra + " para " + user);
        } else if (this.tpConta == 0 && this.saldo + this.limite <= vTra) {
            this.limite -= vTra - this.saldo;
            this.saldo = 0.0;
            System.out.println("- Transferencia no valor de R$" + vTra + " para " + user);
        } else {
            System.err.println("X Saldo insuficiente para efetuar a transferencia!");
        }
        System.out.println("");
    }

    public void receber(double vRec) {
        if (this.tpConta == 0) { // Se for conta corrente
            if (this.limite < limiteMax) { // Se o limite não estiver no máximo da conta executa
                this.limite += vRec; // Soma o limite com o deposito
                if (this.limite >= limiteMax) { // Se o valor de limite for maior que o máximo depois do deposito executa
                    this.limite -= limiteMax; // Calcula o que ficou a mais
                    this.saldo += this.limite; // Soma o saldo com o que ficou a mais
                    this.limite = limiteMax; // Volta o limite a 1000
                }
            } else { // Se não for menor que 1000
                this.saldo += vRec;
            }
        } else { // Se não for conta corrente soma normalmente
            this.saldo += vRec;
        }
    }

    // Verificar somente o saldo
    public double verSaldo() {
        return this.saldo;
    }

    // Ver os status geral da conta
    public void verStatus(int obj) {
        String tipo; // Formatar o tipo de conta
        tipo = switch (this.tpConta) {
            case 0 ->
                "Conta Corrente";
            case 1 ->
                "Conta Poupança";
            case 2 ->
                "Conta Salário";
            default ->
                "Indefinido";
        };
        System.out.println("=================================");
        System.out.println("=  Informacoes da conta  -  " + obj + "\t=");
        System.out.println("=================================");
        System.out.println("= Tipo:     | " + tipo);
        System.out.println("= Numero:   | " + this.nConta);
        System.out.println("= Titular:  | " + this.titular);
        System.out.println("= Saldo:    | " + this.saldo);
        System.out.println("= Limite:   | " + this.limite);
        System.out.println("=================================");
        System.out.println("");
    }
}
