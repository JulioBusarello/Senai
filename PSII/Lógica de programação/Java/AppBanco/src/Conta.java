/**
 * @author julio_busarello
 */
public class Conta {
    // ------------------------- Atributos de Classe -------------------------
    // tpConta = (0-C. Corrente 1-C. Poupança 2-C. Salario)
    char tpConta;
    int nConta;
    String titular;
    float saldo = 0.0f;
    float limite = 0.0f;
    
    // ------------------------- Métodos da Classe -------------------------
    // Efetuar um saque
    public void sacar(float vSaq){ 
        if(this.tpConta == '0'){
            if(this.saldo >= vSaq){
                this.saldo -= vSaq;
                System.out.println("- Voce realizou um saque no valor de R$"+vSaq+" com sucesso!");
            }else if(vSaq > this.saldo + this.limite){
                System.out.println("X Saldo insuficiente para realizar o saque");
            }else{
                this.limite -= vSaq - this.saldo;
                this.saldo = 0.0f;
                System.out.println("- Voce realizou um saque no valor de R$"+vSaq+" utilizando seu limite com sucesso!");
            }
        }else{
            if(this.saldo >= vSaq){
                this.saldo -= vSaq;
                System.out.println("- Voce realizou um saque no valor de R$"+vSaq+" com sucesso!");
            }else{
                System.out.println("X Saldo insuficiente para realizar o saque");
            }
        }
        System.out.println("");
    }
    
    // Efetuar um depósito
    public void depositar(float vDep){ 
        if(this.tpConta == '0'){ // Se for conta corrente
            if(this.limite < 1000){ // Se o limite não estiver no máximo da conta executa
                this.limite += vDep; // Soma o limite com o deposito
                if(this.limite >= 1000){ // Se o valor de limite for maior que o máximo depois do deposito executa
                    this.limite -= 1000.0f; // Calcula o que ficou a mais
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
    public void transferir(float vTra, int conta){ 
        if(this.tpConta == '0'){ // Se for conta corrente
            if(vTra > this.saldo + this.limite){ // Se nem o saque somado com o limite for suficiente
                System.out.println("X Saldo insuficiente para efetuar a transferencia!");
            }else if(vTra <= this.saldo){ // Se o saldo for suficiente desconta somente o saldo
                this.saldo -= vTra;
                System.out.println("- Voce realizou uma transferencia no valor de R$"+vTra+" para "+conta);
            }else{ // Se o saldo não for suficiente usar o limite
                this.limite -= vTra - this.saldo;
                this.saldo = 0.0f;
                System.out.println("- Voce realizou uma transferencia no valor de R$"+vTra+" para "+conta);
            }
        }else{ // Se não for conta corrente
            if(vTra <= this.saldo){ // Se o saldo for suficiente para transferir
                this.saldo -= vTra;
                System.out.println("- Voce transferiu R$"+vTra+" para "+conta);
            }else{ // Se o saldo não for suficiente para transferir
                System.out.println("X Saldo insuficiente para efetuar a transferencia!");
            }
        }
        System.out.println("");
    }
    
    // Verificar somente o saldo
    public float verSaldo(){ 
        return this.saldo;
    }
    
    // Ver os status geral da conta
    public void status(String obj){ 
        String tipo; // Formatar o tipo de conta
        if(this.tpConta == '0'){
            tipo = "Conta Corrente";
        }else if(tpConta == '1'){
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
