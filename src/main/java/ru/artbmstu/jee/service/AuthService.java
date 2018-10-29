package ru.artbmstu.jee.service;

import lombok.SneakyThrows;
import ru.artbmstu.jee.entity.User;
import ru.artbmstu.jee.util.FieldConst;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class AuthService {

    @Inject
    private HttpServletRequest request;

    @Inject UserService userService;

    public boolean openSession(final String login, final String password){
        final boolean check = userService.check(login, password);
        if (!check) return false;
        final User user = userService.getUserByLogin(login);
        if (user == null) return false;
        final HttpSession httpSession = request.getSession();
        httpSession.setAttribute(FieldConst.USER_ID, user.getId());
        httpSession.setAttribute(FieldConst.LOGIN, user.getLogin());
        return true;
    }

    public void closeSession() {
        request.getSession().invalidate();
    }

    public String getLogin() throws AuthException{
        final HttpSession httpSession = request.getSession();
        if (httpSession == null) throw new AuthException();
        final Object value = httpSession.getAttribute(FieldConst.LOGIN);
        if (value == null) throw new AuthException();
        return (String) value;
    }

    public String getUserId() throws AuthException{
        final HttpSession httpSession = request.getSession();
        if (httpSession == null) throw new AuthException();
        final Object value = httpSession.getAttribute(FieldConst.USER_ID);
        if (value == null) throw new AuthException();
        return (String) value;
    }

    public boolean isAuth(){
        final HttpSession httpSession = request.getSession();
        return isAuth(httpSession);
    }

    public static boolean isAuth(final HttpSession httpSession){
        if (httpSession == null) return false;
        final boolean hasLogin = httpSession.getAttribute(FieldConst.LOGIN) != null;
        final boolean hasUserId = httpSession.getAttribute(FieldConst.USER_ID) != null;
        return hasLogin && hasUserId;
    }
}