
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        Queue fila = new LinkedList();
        
        fila.add("Primeiro");
        fila.add("Segundo");
        fila.add("Terceiro");
        
        System.out.println("Mostrando fila: "+fila);
        
        System.out.println("Removido: "+fila.poll());
        
        System.out.println("Elementos na fila apas remocao: "+fila);
        
        System.out.println("Proximo objeto a ser removido: "+fila.peek());
    }
    
}
