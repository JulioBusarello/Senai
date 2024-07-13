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
    private double limite = 0.0;*/
    
    byte tpConta;
    int nConta;
    String titular;
    double saldo = 0.0;
    double limite = 0.0;
    
    // ------------------------- Métodos da Classe -------------------------
    // Efetuar um saque
    public void sacar(double vSaq){ 
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
    
    // Efetuar um depósito
    public void depositar(double vDep){ 
        if(this.tpConta == 0){ // Se for conta corrente
            if(this.limite < 1000){ // Se o limite não estiver no máximo da conta executa
                this.limite += vDep; // Soma o limite com o deposito
                if(this.limite >= 1000){ // Se o valor de limite for maior que o máximo depois do deposito executa
                    this.limite -= 1000.0; // Calcula o que ficou a mais
                    this.saldo += this.limite; // Soma o saldo com o que ficou a mais
                    this.limite = 1000; // Volta o limite a 1000
                }
            }else{ // Se não for menor que 1000
                this.saldo += vDep;
            }
        }else{ // Se não for conta corrente soma normalmente
            this.saldo += vDep;
        }
        System.out.println("+ Deposito no valor de R$"+vDep+" foi realizado com sucesso");
        System.out.println("");
    }
    
    // Fazer uma transferência
    public void transferir(double vTra, int conta){ 
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
    
    // Verificar somente o saldo
    public double verSaldo(){ 
        return this.saldo;
    }
    
    // Ver os status geral da conta
    public void status(String obj){ 
        String tipo; // Formatar o tipo de conta
        if(this.tpConta == 0){
            tipo = "Conta Corrente";
        }else if(tpConta == 1){
            tipo = "Conta Poupança";
        }else{
            tipo = "Conta Salario";
        }
        
        System.out.println("--- Informacoes da conta - "+obj+" ---");
        System.out.println("Tipo:     | "+tipo);
        System.out.println("Numero:   | "+this.nConta);
        System.out.println("Titular:  | "+this.titular);
        System.out.println("Saldo:    | "+this.saldo);
        System.out.println("Limite:   | "+this.limite);
        System.out.println("-------------------------------------");
        System.out.println("");
    }
}