package kg.inai.socfond.services;

import kg.inai.socfond.entities.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> findAll();

    User getById(Long id);

    User update(User user);

    User getUserByUsername(String username);
}
