import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public class ClienteUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("10.74.241.150"); // Ip do servidor

            while (true) {
                JOptionPane.showMessageDialog(null, , null, 0);
            }
            String mensagem = "Hello, servidor UDP! Eu sou o Julio Busarello";
            byte[] sendData = mensagem.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String resposta = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Resposta do servidor: " + resposta);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
