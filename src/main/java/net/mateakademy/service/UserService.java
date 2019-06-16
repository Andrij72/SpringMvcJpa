package net.mateakademy.service;

import net.mateakademy.dto.User;
import java.util.List;

public interface UserService {
    void createUser(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();
}
