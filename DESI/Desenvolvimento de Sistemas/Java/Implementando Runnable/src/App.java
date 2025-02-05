class MinhaRunnable implements Runnable {

    private int tempo;
    private String nome;

    public MinhaRunnable(String nome, int tempo) {
        this.tempo = tempo;
        this.nome = nome;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando " + nome + " Valor do contador: " + i);
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
        MinhaRunnable runnable1 = new MinhaRunnable("Thread 1", 1500);
        MinhaRunnable runnable2 = new MinhaRunnable("Thread 2", 4500);

        Thread thread_1 = new Thread(runnable1);
        thread_1.start();

        Thread thread_2 = new Thread(runnable2);
        thread_2.start();

        System.out.println("Programa finalizado!!!");
    }
}
