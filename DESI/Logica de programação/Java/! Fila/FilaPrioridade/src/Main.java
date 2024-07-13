
import java.util.PriorityQueue;

/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        PriorityQueue fila = new PriorityQueue();
        
        fila.add("Bolo");
        fila.add("Arroz");
        fila.add("Rato");
        
        System.out.println("Mostrando fila: "+fila);
        
        System.out.println("Removido: "+fila.poll());
        
        System.out.println("Elementos na fila apas remocao: "+fila);
        
        System.out.println("Proximo objeto a ser removido: "+fila.peek());
    }
    
}