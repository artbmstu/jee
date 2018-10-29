package ru.artbmstu.jee.repository;

import ru.artbmstu.jee.entity.User;

import javax.ejb.Stateless;

@Stateless
public class UserRepository extends AbstractRepository{

    public User getUserByLogin(String login){
        if (login == null || login.isEmpty()) return null;
        return getEntity(em.createQuery("select  e from User e where e.login = :login", User.class)
                .setParameter("login", login));
    }

    public boolean isLoginUnique(final String login){
        if (login == null || login.isEmpty()) return false;
        return em.createQuery("select count(e.id) from User e where e.login = :login", User.class)
                .setParameter("login", login)
                .setMaxResults(1).getSingleResult().equals(0L);
    }

    public boolean isEmailUnique(final String email){
        if (email == null || email.isEmpty()) return false;
        return em.createQuery("select count(e.id) from User e where e.email = :email", User.class)
                .setParameter("email", email)
                .setMaxResults(1).getSingleResult().equals(0L);
    }

    public User persist(User user){
        if (user == null) return null;
        em.persist(user);
        return user;
    }
}