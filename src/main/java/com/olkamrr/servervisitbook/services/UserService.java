package com.olkamrr.servervisitbook.services;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.User;
import com.olkamrr.servervisitbook.models.enums.Role;
import com.olkamrr.servervisitbook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createUser(User user) {
        if (userRepository.findByLogin(user.getLogin()) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_STUDENT);
        userRepository.save(user);
        return true;
    }

    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        Streamable.of(userRepository.findAll()).forEach(users::add);
        return users;
    }

    public List<User> getRole(Role roleNum){
        List<User> users = new ArrayList<>();
        Streamable.of(userRepository.findAll()).forEach(users::add);
        List<User> res = new ArrayList<>();
        for (User user: users) {
            for (Role role: user.getRoles()){
                if (role.equals(roleNum)){
                    res.add(user);
                }
            }
        }
        return res;
    }

    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }

    public User findOne(int id) {
        User foundUser = userRepository.findById(id);
        return foundUser;
    }

    public void disable(int id) {
        User user = userRepository.findById(id);
        if (user != null) {
            if (user.isActive()) {
                user.setActive(false);
            } else {
                user.setActive(true);
            }
        }
        userRepository.save(user);
    }
}
