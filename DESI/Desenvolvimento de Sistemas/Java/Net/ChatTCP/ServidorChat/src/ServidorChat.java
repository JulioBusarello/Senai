
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServidorChat {

    private static final int PORT = 12345;
    private static ServerSocket serverSocket;
    private static Map<String, PrintWriter> clients = new HashMap<>();

    public static void main(String[] args) throws Exception {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor aguardando conexões...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {

        private BufferedReader in;
        private PrintWriter out;
        private String clientName;

        public ClientHandler(Socket socket) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                clientName = in.readLine();

                synchronized (clients) {
                    while (clients.containsKey(clientName)) {
                        out.println("Nome ja esta em uso. Digite outro nome:");
                        clientName = in.readLine();
                    }
                    clients.put(clientName, out);
                    sendClientsListToClient(out);
                }

                System.out.println(clientName + " entrou no chat.");

                sendClientsListToAllClients();

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/send")) {
                        String[] parts = message.split(" ", 3);
                        if (parts.length == 3) {
                            String target = parts[1];
                            String msg = parts[2];
                            sendMessageToClient(target, msg);
                        }
                    }

                }
            } catch (Exception e) {
                System.out.println(clientName + " desconectou-se ou houve erro na comunicação.");
            } finally {
                synchronized (clients) {
                    if (clientName != null) {
                        clients.remove(clientName);
                        sendClientsListToAllClients();
                        System.out.println(clientName + " saiu do chat.");
                    }
                }
            }
        }

        private void sendClientsListToAllClients() {
            synchronized (clients) {
                StringBuilder userList = new StringBuilder("/users ");
                for (String client : clients.keySet()) {
                    userList.append(client).append(" ");
                }
                String userListSend = userList.toString().trim();

                for (PrintWriter writer : clients.values()) {
                    writer.println(userListSend);
                }
            }
        }

        private void sendClientsListToClient(PrintWriter clientOut) {
            synchronized (clients) {
                StringBuilder userList = new StringBuilder("/users ");
                for (String client : clients.keySet()) {
                    userList.append(client).append(" ");
                }

                clientOut.println(userList.toString().trim());
            }
        }

        private void sendMessageToClient(String target, String message) {
            PrintWriter targetOut = clients.get(target);
            if (targetOut != null) {
                targetOut.println(clientName + " diz: " + message);
            } else {
                out.println("Usuario: " + target + " nao encontrado!");
            }
        }

    }
}
