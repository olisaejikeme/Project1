package com.sample.project1.service;

import com.sample.project1.models.User;
import java.util.Collection;

public interface UserService {
    User createUser(User user);

    Collection<User> getUsers();

    User getUser(String userId);

    User updateUser(String userId, User user);

    void deleteUser(String userId);
    }

