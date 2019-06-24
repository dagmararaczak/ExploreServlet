package pl.hit.servlets.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "HeaderServlet")
public class HeaderServlet extends HttpServlet {

    private int counter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        LocalDateTime now = LocalDateTime.now();
        PrintWriter writer = resp.getWriter();
        StringBuilder builder = new StringBuilder();
        builder.append("<head>")
                .append("<title>")
                .append(" Technologia JSP Teraz jest: " + now + "Liczba odwiedzin "+ counter )
                .append( "</title>")
                .append("</head>")
                .append("<body>")
                .append("<p> Technologia JSP Teraz jest: "+ now + " Liczba odwiedzin "+ counter +"</p>");

        writer.println(builder.toString());
    }

    @Override
    public void init() {
        counter = 0;
    }
}
