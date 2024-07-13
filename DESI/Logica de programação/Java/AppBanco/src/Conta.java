
/**
 * @author julio_busarello
 */
public class Conta {

    private boolean ativa; // true- ativa / false- inativa
    private boolean bloqueada; // true- bloqueada / false- desbloqueada 
    private byte tpConta; // 0- C. Corrente / 1- C. Poupança / 2- C. Salário
    private int nConta;
    private String titular;
    private double saldo = 0.0;
    private double limite;
    private double limiteMax;

    // --- Construtor
    public Conta(){
        
    }
    
    public Conta(String titular, byte tipo, int nConta, double limite) {
        this.tpConta = tipo;
        this.nConta = nConta;
        this.titular = titular;
        this.limite = limite;
        this.limiteMax = limite;
    }

    // --- Getter and Setter
    public boolean isAtivo() {
        return ativa;
    }

    public void setAtivo(boolean ativa) {
        this.ativa = ativa;
    }

    public boolean isBloqueado() {
        return bloqueada;
    }

    public void setBloqueado(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public byte getTpConta() {
        return tpConta;
    }

    public void setTpConta(byte tpConta) {
        this.tpConta = tpConta;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getLimiteMax() {
        return limiteMax;
    }

    public void setLimiteMax(double limiteMax) {
        this.limiteMax = limiteMax;
    }

    // --- Métodos da Conta
    
    // Faz o saque
    public void sacar(double vSaq) {
        if (this.saldo >= vSaq) { // Se o saldo cubrir o valor do saque
            this.saldo -= vSaq;
            System.out.println("- Voce realizou um saque no valor de R$" + vSaq + " com sucesso!");
        } else if (this.tpConta == 0 && this.saldo + this.limite >= vSaq) { // Se for conta corrente e o valor do saque for menor que o disponível no limite e no saldo
            this.limite -= vSaq - this.saldo;
            this.saldo = 0.0;
            System.out.println("- Voce realizou um saque no valor de R$" + vSaq + " utilizando seu limite com sucesso!");
        } else { // Se não possuir dinheiro para o saque
            System.err.println("X Saldo insuficiente para realizar o saque");
        }
        System.out.println("");
    }

    // Faz um depósito na conta
    public void depositar(double vDep) {
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

    // Faz a transferência de uma conta pra outra
    public void transferir(double vTra, int conta) {
        if (this.tpConta == 0) { // Se for conta corrente
            if (vTra > this.saldo + this.limite) { // Se nem o saque somado com o limite for suficiente
                System.err.println("X Saldo insuficiente para efetuar a transferencia!");
            } else if (vTra <= this.saldo) { // Se o saldo for suficiente desconta somente o saldo
                this.saldo -= vTra;
                System.out.println("- Voce realizou uma transferencia no valor de R$" + vTra + " conta: " + conta);
            } else { // Se o saldo não for suficiente usar o limite
                this.limite -= vTra - this.saldo;
                this.saldo = 0.0;
                System.out.println("- Voce realizou uma transferencia no valor de R$" + vTra + " conta: " + conta);
            }
        } else { // Se não for conta corrente
            if (vTra <= this.saldo) { // Se o saldo for suficiente para transferir
                this.saldo -= vTra;
                System.out.println("- Voce transferiu R$" + vTra + " para conta: " + conta);
            } else { // Se o saldo não for suficiente para transferir
                System.err.println("X Saldo insuficiente para efetuar a transferencia!");
            }
        }
        System.out.println("");
    }

    // Verificar o saldo atual da conta
    public double verSaldo() {
        return this.saldo;
    }

    // Verifica as informações da conta
    public void verStatus() {
        System.out.println("=================================");
        System.out.println("=      Informacoes da conta     =");
        System.out.println("=================================");
        System.out.println("= Tipo:      | " + this.tpConta);
        System.out.println("= Numero:    | " + this.nConta);
        System.out.println("= Titular:   | " + this.titular);
        System.out.println("= Saldo:     | " + this.saldo);
        System.out.println("= Limite:    | " + this.limite);
        System.out.println("= Bloqueada: | " + this.bloqueada);
        System.out.println("= Ativa:     | " + this.ativa);
        System.out.println("=================================");
        System.out.println("");
    }

    public boolean verAtividade() {
        return this.ativa;
    }
}
