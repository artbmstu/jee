package ru.artbmstu.jee.listener;

import ru.artbmstu.jee.event.AsyncEvent;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

@Stateless
public class AsyncListener {

    private static final Logger LOGGER = Logger.getLogger(AsyncListener.class.getSimpleName());

    @Asynchronous
    public void observe(@Observes final AsyncEvent event){
        LOGGER.info("Observe thread id: " + Thread.currentThread().getId());
    }
}