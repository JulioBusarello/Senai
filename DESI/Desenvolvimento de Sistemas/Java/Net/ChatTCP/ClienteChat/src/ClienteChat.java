import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClienteChat extends JFrame {

    private JTextArea taChat;
    private JTextField jtfMessage;
    private JTextField jtfRecipient;
    private JButton btnSend;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String serverAddres = "10.74.241.66";
    private int port = 12345;

    public ClienteChat() {
        // Configurações da janela
        setTitle("Chat Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taChat = new JTextArea();
        taChat.setEditable(false);
        add(new JScrollPane(taChat), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Adicionando o label e o campo de texto para o destinatário
        JPanel recipientPanel = new JPanel();
        recipientPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblRecipient = new JLabel("Destinatário:");
        recipientPanel.add(lblRecipient);
        jtfRecipient = new JTextField(15);
        recipientPanel.add(jtfRecipient);
        panel.add(recipientPanel, BorderLayout.NORTH);

        // Adicionando o label e o campo de texto para a mensagem
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblMessage = new JLabel("Mensagem:");
        messagePanel.add(lblMessage);
        jtfMessage = new JTextField(20);
        messagePanel.add(jtfMessage);
        panel.add(messagePanel, BorderLayout.CENTER);

        // Botão de envio
        btnSend = new JButton("Enviar");
        panel.add(btnSend, BorderLayout.EAST);

        add(panel, BorderLayout.SOUTH);

        // Ação do botão de enviar
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Conectar ao servidor
        connectToServer();

        // Iniciar a thread de recebimento de mensagens
        new Thread(new MessageReceiver()).start();
    }

    private void connectToServer() {
        try {
            String iphost = JOptionPane.showInputDialog("Insira o ip do servidor");
            serverAddres = iphost;

            socket = new Socket(serverAddres, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String name = JOptionPane.showInputDialog("Insira seu nome:");
            setTitle("Chat client - " + name);
            out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String recipient = jtfRecipient.getText();
        String message = jtfMessage.getText();
        if (!message.isEmpty() && !recipient.isEmpty()) {
            out.println("/send " + recipient + " " + message);
            taChat.append("Você (para " + recipient + "): " + message + "\n");
            jtfMessage.setText("");
            jtfRecipient.setText("");
        }
    }

    private class MessageReceiver implements Runnable {

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    taChat.append(message + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClienteChat().setVisible(true);
            }
        });
    }
}
