import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            System.out.println("Servidor UDP esperando por dados...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String mensagem = new String(receivePacket.getData(), 0, receiveData.length);
                System.out.println("Mensagem recebida " + mensagem);

                InetAddress clientAddres = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String resposta = "Mensagem recebida!";
                DatagramPacket sendPacket = new DatagramPacket(resposta.getBytes(), resposta.length(), clientAddres,
                        clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
