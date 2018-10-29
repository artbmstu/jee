package ru.artbmstu.jee.service;

import ru.artbmstu.jee.entity.User;
import ru.artbmstu.jee.repository.UserRepository;
import ru.artbmstu.jee.util.PasswordUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public void init(String login, String email, String password){
        if (!userRepository.isLoginUnique(login)) return;
        if (!userRepository.isEmailUnique(email)) return;
        create(login, email, password);
    }

    public void create(String login, String email, String password){
        if (login == null || login.isEmpty()) return;
        if (email == null || email.isEmpty()) return;
        if (password == null || password.isEmpty()) return;
        final String passwordHash = PasswordUtil.hashCode(password);
        final User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPasswordHash(passwordHash);
        userRepository.persist(user);
    }

    public boolean check(final String login, final String password){
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        final User user = userRepository.getUserByLogin(login);
        if (user == null) return false;
        final String passwordHash = PasswordUtil.hashCode(password);
        return passwordHash.equals(user.getPasswordHash());
    }
}