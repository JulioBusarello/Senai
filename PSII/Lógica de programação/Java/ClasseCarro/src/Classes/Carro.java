package Classes;

/**
 *
 * @author julio_busarello
 */
public class Carro {

    // ----- Variáveis
    private int velocidade = 0;
    private boolean status = false; // False desligado, true ligado

    // ----- Construtor
    public Carro() {

    }
    
    public Carro(int velocidade, boolean status){
        this.velocidade = velocidade;
        this.status = status;
    }

    // ----- Getters and Setters
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    // ----- Métodos da Classe
    // Método acelerar
    public void acelerar(int velocidade) {
        if (status) { // Se estiver ligado
            System.out.println("Voce acelerou " + velocidade + "Km/h");
            this.velocidade += velocidade;
        } else { // Se estiver desligado
            System.out.println("O carro esta desligado!");
        }
    }
    // Método frear
    public void frear(int velocidade) {
        if (velocidade <= this.velocidade) { // Velocidade maior que a para frear
            this.velocidade -= velocidade;
        } else if (this.velocidade == 0) { // Se ja estiver parado
            System.out.println("O veiculo esta parado!");
        } else { // Se estiver mais devagar que o solicitado para frear
            System.err.println("Sua velocidade e menor!");
        }
    }
    // Método ligar
    public void ligar() {
        if (status) { // Se ja esta ligado
            System.out.println("Carro ja esta ligado!");
        } else { // Se estiver desligado
            System.out.println("Carro foi ligado!");
            status = true;
        }
    }
    // Método desligar
    public void desligar() {
        if (!status) { // Se estiver desligado
            System.out.println("Carro ja esta desligado");
        } else if (status && this.velocidade > 0) { // Se estiver ligado e em movimento
            System.err.println("Voce nao pode desligado o carro em movimento!");
        } else { // Se estiver ligado e nao em movimento
            System.out.println("Carro foi desligado!");
            status = false;
        }
    }
    // Método verificar Status
    public void verStatus() { // Mostra os status
        System.out.println("Velocidade:   | " + this.velocidade);
        System.out.println("Ligado:       | " + this.status);
    }
}
