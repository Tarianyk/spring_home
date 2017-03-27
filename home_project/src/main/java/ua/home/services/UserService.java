package ua.home.services;

import ua.home.domain.User;

public interface UserService {
    User addUser(User user);

    User getUser(String id);
}
