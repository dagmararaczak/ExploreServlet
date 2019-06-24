package pl.hit.servlets.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

@WebFilter(urlPatterns = "/*")
public class ResponseInfoFilter extends HttpFilter {
    private Logger logger = Logger.getLogger(ResponseInfoFilter.class.getName());
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        System.out.println("RESPONSE FILTER");
        chain.doFilter(req,res);

        System.out.println("STATUS ODPOWIEDZI: " +res.getStatus());
        System.out.println("TYP ODPOWIEDZI" + res.getContentType());
        Enumeration<String> headersName = req.getHeaderNames();
        System.out.println("NAGLOWKI: ");
        while(headersName.hasMoreElements()){
            String header = headersName.nextElement();
            logger.info(header +"\n");
            Enumeration<String> headers = req.getHeaders(header);
            while(headers.hasMoreElements()){
                String headerValue = headers.nextElement();
                logger.info(headerValue);
            }

        }

    }
}
