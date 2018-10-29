package ru.artbmstu.jee.bootstrap;

import ru.artbmstu.jee.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Bootstrap {

    @Inject
    private UserService userService;

    @PostConstruct
    private void start(){
        userService.init("test", "test@t.ru", "test");
    }

}