package com.ratnikov.pp_3_1_1.service;


import com.ratnikov.pp_3_1_1.entity.User;
import java.util.List;

public interface UserService {
    void createUser(User user);

    List<User> getAllUsers();

    void deleteUserById(int id);

    void updateUser(User user);

    User getUserById(int id);
}
