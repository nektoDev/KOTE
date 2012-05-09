package ru.sngb.kote.service;

import ru.sngb.kote.domain.User;

import java.util.Collection;

/**
 * UserServivice - user business layer class.
 * <p/>
 * Date: 09.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public interface UserService {
    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    Collection<User> getAllUsers();

    User getUserById(String id);

    Collection<User> getUsersByDepartment(String department);

    boolean autorization(String login, String password);
}
