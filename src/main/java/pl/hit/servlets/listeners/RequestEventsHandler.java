package pl.hit.servlets.listeners;

import pl.hit.servlets.events.EventManager;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Logger;

import static pl.hit.servlets.events.EventType.*;

@WebListener
public class RequestEventsHandler implements ServletRequestListener {

    private  static  final Logger logger = Logger.getLogger(RequestEventsHandler.class.getName());
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
       EventManager eventManager = (EventManager) sre.getServletContext().getAttribute("eventManager");
       eventManager.notify(REQUEST_STARTED);

        HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();

        Cookie[] cookies = httpServletRequest.getCookies();

        logger.info("Metoda Http: " + httpServletRequest.getMethod());
        logger.info("Sciezka kontekstu: " + httpServletRequest.getContextPath());
        logger.info("Sciezka zasobu: " + httpServletRequest.getPathInfo());


        if(cookies == null){
            logger.info("Brak ciasteczek");

        }else{
            System.out.println("COOKIES");
            Arrays.stream(cookies).forEach(cookie -> logger.info("NAZWA CIASTECZKA "+cookie.getName()+
                    " WARTOSC CIASTECZKA " + cookie.getValue()+
                    " SCIEZKA CIASTECZKA " + cookie.getPath()+
                    " WIEK CIASTECZKA " + cookie.getMaxAge() ));
        }

        logger.info("NAGLOWKI:");
        Enumeration<String> headersName = httpServletRequest.getHeaderNames();
        while(headersName.hasMoreElements()){
            String header = headersName.nextElement();
            logger.info(header +"\n");
            Enumeration<String> headers = httpServletRequest.getHeaders(header);
            while(headers.hasMoreElements()){
                String headerValue = headers.nextElement();
                logger.info(headerValue);
            }
        }
        logger.info("PARAMETRY");
        httpServletRequest.getParameterMap().forEach((param, value) -> logger.info( param + "=" + value +"&"));



    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        EventManager eventManager = (EventManager) sre.getServletContext().getAttribute("eventManager");
        eventManager.notify(REQUEST_END);
    }
}
