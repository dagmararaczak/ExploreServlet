package pl.hit.servlets.listeners;

import pl.hit.servlets.events.EventManager;
import pl.hit.servlets.events.EventType;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionEventsHandler implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

        EventManager eventManager = (EventManager) se.getSession().getServletContext().getAttribute("eventManager");

        eventManager.notify(EventType.SESSION_STARTED);



    }


}
