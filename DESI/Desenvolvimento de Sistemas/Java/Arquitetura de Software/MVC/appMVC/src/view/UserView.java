package view;

import model.User;
import javax.swing.*;

import controller.UserController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserView extends JFrame {
    private UserController userController;
    private JButton btnAdd;
    private JButton btnFind;
    private JButton btnDel;
    private JButton btnUpdate;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public UserView() {
        userController = new UserController();

        setTitle("User Management");
        setSize(400, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Panel para adicionar usuário
        JPanel panel = new JPanel();
        panel.setLayout(null);

        btnAdd = new JButton("Add User");
        btnAdd.setBounds(10, 10, 360, 30);
        panel.add(btnAdd);

        btnUpdate = new JButton("Update User");
        btnUpdate.setBounds(10, 50, 360, 30);
        panel.add(btnUpdate);

        btnFind = new JButton("Find User");
        btnFind.setBounds(10, 90, 360, 30);
        panel.add(btnFind);

        btnDel = new JButton("Delete User");
        btnDel.setBounds(10, 130, 360, 30);
        panel.add(btnDel);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 180, 360, 100);
        panel.add(scrollPane);

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        add(panel);

        // Botão para Adicionar Usuário
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Informe o nome do Usuário:");
                if (name != null && name.isBlank()) { // Verificando se o campo estava vazio após pressionar "OK"
                    JOptionPane.showMessageDialog(null, "Você deve informar um Nome!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else if (name != null) { // Caso tenha uma informação
                    userController.addUser(name);
                }
                // Carrega a lista de usuários atualizada
                loadUser();
            }
        });

        // Botão para Atualizar Usuário
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Informe o ID do Usuário a ser atualizado:");
                if (id != null && id.isBlank()) { // Verificando se o campo estava vazio após pressionar "OK"
                    JOptionPane.showMessageDialog(null, "Você deve informar um ID!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else if (id != null) { // Caso tenha uma informação
                    if (userController.verifyId(Integer.parseInt(id))) {
                        String name = JOptionPane.showInputDialog("Informe o nome atualizado do Usuário:");
                        if (name != null && name.isBlank()) { // Verificando se o campo estava vazio
                            JOptionPane.showMessageDialog(null, "Você deve informar um Nome!", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        } else if (name != null) { // Caso tenha uma informação
                            User user = new User(Integer.parseInt(id), name);
                            userController.updateUser(user);
                        }
                    }
                }
                // Carrega a lista de usuários atualizada
                loadUser();
            }
        });

        // Botão para Buscar Usuário
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Informe o ID do Usuário a ser buscado:");
                if (id != null && id.isBlank()) { // Verificando se o campo estava vazio após pressionar "OK"
                    JOptionPane.showMessageDialog(null, "Você deve informar um ID!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else if (id != null) { // Caso tenha uma informação
                    User user = userController.getUserById(Integer.parseInt(id));
                    if (user != null) { // Verificando se existe um usuário com esse id
                        JOptionPane.showMessageDialog(null, "ID: " + user.getId() + "\n" + "Name: " + user.getName(),
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        // Botão para Deletar Usuário
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Informe o id do Usuário:");
                if (id != null && id.isBlank()) { // Verificando se o campo estava vazio após pressionar "OK"
                    JOptionPane.showMessageDialog(null, "Você deve informar um ID!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else if (id != null) { // Caso tenha uma informação
                    userController.deleteUser(Integer.parseInt(id));
                    loadUser(); // Carrega a lista de usuários atualizada
                }
            }
        });
        // Carrega a lista de usuários atualizada
        loadUser();
    }

    // Carregar os Usuários cadastrados no banco e adicionar a TextArea
    private void loadUser() {
        List<User> users = userController.getAllUsers();
        StringBuilder usersString = new StringBuilder();
        for (User user : users) {
            usersString.append("ID: ").append(user.getId()).append(" Name: ").append(user.getName()).append("\n");
        }
        textArea.setText(usersString.toString());
    }
}