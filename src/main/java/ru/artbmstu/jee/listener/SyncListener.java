package ru.artbmstu.jee.listener;

import ru.artbmstu.jee.event.SyncEvent;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.servlet.AsyncEvent;
import java.util.logging.Logger;

@Stateless
public class SyncListener {

    private static final Logger LOGGER = Logger.getLogger(SyncListener.class.getSimpleName());

    public void observe(@Observes SyncEvent event){
        LOGGER.info("Observe thread id: " + Thread.currentThread().getId());
    }
}