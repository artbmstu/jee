package ru.artbmstu.jee.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import ru.artbmstu.jee.event.AsyncEvent;
import ru.artbmstu.jee.event.SyncEvent;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSContext;
import java.util.Queue;
import java.util.logging.Logger;

@Named
@RequestScoped
@URLMapping(id = "event", pattern = "/event", viewId = "/WEB-INF/faces/event.xhtml")
public class EventController {

    private static final Logger LOGGER = Logger.getLogger(EventController.class.getSimpleName());

    @Inject
    private Event<AsyncEvent> asyncEvent;

    @Inject
    private Event<SyncEvent> syncEvent;

    @Inject
    private JMSContext context;

    public void fireAsyncEvent(){
        asyncEvent.fire(new AsyncEvent());
        showMessage("Fire Async Event");
        LOGGER.info("fireAsyncEvent: " + Thread.currentThread());
    }

    public void fireЫyncEvent(){
        syncEvent.fire(new SyncEvent());
        showMessage("Fire Sync Event");
        LOGGER.info("fireSyncEvent: " + Thread.currentThread());
    }

    private void showMessage(String fire) {
        System.out.println(fire);
    }
}