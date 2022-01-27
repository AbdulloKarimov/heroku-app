package kg.inai.socfond.services.impl;

import kg.inai.socfond.entities.User;
import kg.inai.socfond.exceptions.RecordNotFoundException;
import kg.inai.socfond.repos.UserRepo;
import kg.inai.socfond.repos.UserRoleRepo;
import kg.inai.socfond.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepo.getById(id);
    }

    @Override
    public User update(User user) {
        return userRepo.findById(user.getId())
                .map(newUser -> {
                    newUser.setUsername(user.getUsername());
                    newUser.setPassword(passwordEncoder.encode(user.getPassword()));
                    newUser.setFirstName(user.getFirstName());
                    newUser.setLastName(user.getLastName());
                    newUser.setEmail(user.getEmail());
                    newUser.setPhoneNumber(user.getPhoneNumber());
                    newUser.setUserRoles(user.getUserRoles());
                    newUser.setUserRoles(user.getUserRoles());
                    return userRepo.save(user);
                })
                .orElseThrow(() -> new RecordNotFoundException("Record not found with id " + user.getId()));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }
}
