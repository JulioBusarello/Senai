package controller;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserController {
    private UserDao userDao;

    public UserController() {
        userDao = new UserDaoImpl();
    }

    public void addUser(String name) {
        userDao.saveUser(new User(name));
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User getUserById(int id) {
        return userDao.findUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }

    public boolean verifyId(int id) {
        return userDao.verifyId(id);
    }

}
