class MinhaThread extends Thread {

    private int tempo;
    private String nome;

    public MinhaThread(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    public void run() {
        // Codigo a ser executado pela thread
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando " + nome + " Valor do Contador: " + i);
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        MinhaThread thread_1 = new MinhaThread("Thread #1", 500);
        thread_1.start();

        MinhaThread thread_2 = new MinhaThread("Thread #2", 3000);
        thread_2.start();

        System.out.println("Programa finalizado!");
    }
}
