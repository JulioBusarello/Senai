
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ClienteChat extends JFrame {

    private JTextArea taChat;
    private JList<String> userList;
    private DefaultListModel<String> userModel;
    private JTextField jtfMessage;
    private JTextField jtfRecipient;
    private JButton btnSend;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    // private String serverAddres = "localhost";
    private String serverAddres;
    private int port = 12345;

    private String nameUser;

    public ClienteChat() {
        // Configurações da janela
        setTitle("Chat Client");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taChat = new JTextArea();
        taChat.setEditable(false);
        taChat.setLineWrap(true);
        taChat.setWrapStyleWord(true);

        userModel = new DefaultListModel<>();
        userList = new JList<>(userModel);
        JScrollPane userScrollPane = new JScrollPane(userList);
        add(userScrollPane, BorderLayout.EAST);

        // Dividindo panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(taChat),
                new JScrollPane(userScrollPane));
        splitPane.setDividerLocation(400);
        splitPane.setDividerSize(5);
        add(splitPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Adicionando o label e o campo de texto para o destinatário
        JPanel recipientPanel = new JPanel();
        recipientPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblRecipient = new JLabel("Destinatário:");
        recipientPanel.add(lblRecipient);
        jtfRecipient = new JTextField(20);
        recipientPanel.add(jtfRecipient);
        panel.add(recipientPanel, BorderLayout.NORTH);

        // Adicionando o label e o campo de texto para a mensagem
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblMessage = new JLabel("Mensagem:");
        messagePanel.add(lblMessage);
        jtfMessage = new JTextField(30);
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

        jtfMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        userList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    String selectedUser = userList.getSelectedValue();
                    if (selectedUser != null) {
                        jtfRecipient.setText(selectedUser);
                    }
                }
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

            nameUser = JOptionPane.showInputDialog("Insira seu nome:");

            verifyName();

            while (true) {
                out.println(nameUser);
                String serverResponse = in.readLine();

                if (serverResponse.equals("Nome ja esta em uso. Digite outro nome:")) {
                    nameUser = JOptionPane.showInputDialog("Nome ja esta em uso. Digite outro nome:");
                    verifyName();
                } else {
                    break;
                }
            }

            setTitle("Chat client - " + nameUser);
            out.println(nameUser);
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
                    // System.out.println("Mensagem recebida: " + message);
                    if (message.startsWith("/users")) {
                        updateUserList(message);
                    } else {
                        taChat.append(message + "\n");
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(ClienteChat.this, "Conexão perdida com o servidor.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }

    }

    private void updateUserList(String message) {
        SwingUtilities.invokeLater(() -> {
            userModel.clear();
            String[] users = message.split(" ");
            for (int i = 1; i < users.length; i++) {
                if (!users[i].equals(nameUser)) {
                    userModel.addElement(users[i]);
                }
            }
        });
    }

    private void verifyName() {
        nameUser = nameUser.trim();

        if (nameUser.contains(" ")) {
            nameUser = nameUser.replace(" ", "_");
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
