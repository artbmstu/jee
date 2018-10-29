package ru.artbmstu.jee.filter;

import ru.artbmstu.jee.service.AuthService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final HttpSession httpSession = request.getSession();
        final boolean isAuth = AuthService.isAuth(httpSession);
        if (isAuth) filterChain.doFilter(servletRequest, servletResponse);
        else response.sendRedirect("/login");
    }

    @Override
    public void destroy() {

    }
}