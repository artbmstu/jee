package ru.artbmstu.jee.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import ru.artbmstu.jee.service.AuthService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@Getter
@Setter
@ViewScoped
@ManagedBean
@URLMapping(id = "login", pattern = "/login", viewId = "/WEB-INF/faces/login.xhtml")
public class LoginController {

    private String login = "";

    private String password = "";

    @Inject
    private AuthService authService;

    public String auth(){
        final boolean check = authService.openSession(login, password);
        if (check) return "admin-index";
        else return "login";
    }
}