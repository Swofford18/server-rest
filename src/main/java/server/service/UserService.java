package server.service;

import server.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User saveUser(User user);

    void delete(User user);
}
