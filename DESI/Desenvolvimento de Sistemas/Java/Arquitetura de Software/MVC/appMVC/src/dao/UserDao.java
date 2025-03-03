package dao;

import java.util.List;

import model.User;

public interface UserDao {
    User findUserById(int id);

    void saveUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> findAllUsers();

    boolean verifyId(int id);
}
