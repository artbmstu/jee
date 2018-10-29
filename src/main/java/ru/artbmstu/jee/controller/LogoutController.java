package ru.artbmstu.jee.controller;

import ru.artbmstu.jee.service.AuthService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class LogoutController {

    @Inject
    private AuthService authService;

    public String logout(){
        authService.closeSession();
        return "login";
    }
}