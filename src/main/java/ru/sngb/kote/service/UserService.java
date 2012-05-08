package ru.sngb.kote.service;

import ru.sngb.kote.domain.User;

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

    void getAllUsers();

    void updateUser(User user);

    void getUserById();

    void getUsersByDepartment();

    void autorization();
}
