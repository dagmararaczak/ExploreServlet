package pl.hit.servlets.listeners;

import pl.hit.servlets.events.EventManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static pl.hit.servlets.events.EventType.*;

@WebListener
public class ContextEventsHandler implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("eventManager", EventManager.getInstance());
        EventManager eventManager = (EventManager) servletContext.getAttribute("eventManager");
        eventManager.notify(APPLICATION_STARTED);
        eventManager.load();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EventManager eventManager = (EventManager) sce.getServletContext().getAttribute("eventManager");
        eventManager.notify(APPLICATION_END);
        eventManager.store();

    }
}
