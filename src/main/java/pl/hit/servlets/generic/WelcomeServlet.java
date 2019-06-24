package pl.hit.servlets.generic;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(urlPatterns = "/welcome")
public class WelcomeServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");


        PrintWriter writer = res.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("Hello, servlets world!");
        writer.println("<br>");
        writer.println("Nazwa serwera : " + req.getLocalName());
        writer.println("<br>");
        writer.println("Adres serwera : " + req.getLocalAddr());
        writer.println("<br>");
        writer.println("Port serwera : " + req.getLocalPort());
        writer.println("<br>");
        writer.println("Host klienta : " + req.getRemoteHost());
        writer.println("<br>");
        writer.println("Adres klienta : " + req.getRemoteAddr());
        writer.println("<br>");
        writer.println("Port klienta : " + req.getRemotePort());
        writer.println("<br>");
        writer.println("Protokol komunikacji : " + req.getProtocol());
        writer.println("<br>");
        writer.println("Kodowanie znakow : " + req.getCharacterEncoding());
        writer.println("<br>");
        writer.println("Typ tresci : " + req.getContentType());
        writer.println("<br>");
        writer.println("Parametry zadania : " );
        req.getParameterMap().forEach((param, values) -> writer.println(param + "=" + Arrays.toString(values)));
        writer.println("<br>");
        writer.println("Kodowanie znakow odpowiedzi : " + res.getCharacterEncoding());
        writer.println("<br>");
        writer.println("Typ tresci odpowiedzi : " + res.getContentType());
        writer.println("</body>");
        writer.println("</html>");
    }
}
