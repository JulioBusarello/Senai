package view;

import model.User;
import dao.UserDao;
import dao.UserDaoImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserView extends JFrame {
    private UserDao userDao;
    private JButton btnAdd;
    private JButton btnFind;
    private JButton btnDel;
    private JButton btnUpdate;
    private JTextArea textArea;

    public UserView() {
        userDao = new UserDaoImpl();

        setTitle("User Management");
        setSize(400, 500);
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

        textArea = new JTextArea();
        textArea.setBounds(10, 180, 360, 100);
        textArea.setEditable(false);
        panel.add(textArea);

        add(panel);
        // add(scrollPane, BorderLayout.CENTER);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Informe o nome do Usuário:");
                if (name != null && name.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Você deve informar um Nome!");
                } else if (name != null) {
                    userDao.saveUser((new User(0, name)));
                }
                loadUser();
            }
        });

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Informe o ID do Usuário a ser buscado:");
                if (id != null && id.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Você deve informar um ID!");
                } else if (id != null) {
                    User user = userDao.findUserById(Integer.parseInt(id));
                    JOptionPane.showMessageDialog(null, "ID: " + user.getId() + "\n" + "Name: " + user.getName());
                }
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Informe o id do Usuário:");
                if (id != null && id.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Você deve informar um ID!");
                } else if (id != null) {
                    userDao.deleteUser(Integer.parseInt(id));
                    loadUser();
                }
            }
        });

        loadUser();
    }

    private void loadUser() {
        List<User> users = userDao.findAllUsers();
        StringBuilder usersString = new StringBuilder();
        for (User user : users) {
            usersString.append("ID: ").append(user.getId()).append(" Name: ").append(user.getName()).append("\n");
        }
        textArea.setText(usersString.toString());
    }
}