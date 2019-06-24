package pl.hit.servlets.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Random;

@WebServlet(urlPatterns = "/jsp/dynamic-content")
public class DynamicContentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Random random = new Random();
        Integer number = random.nextInt(10 + 1 + 10) - 10;
        LocalDateTime now = LocalDateTime.now();
        StringBuilder builder = new StringBuilder();


        builder.append(" <html>").append(" <head>").append("<title>Tresc dynamiczna</title>")
                .append("</head>")
                .append(" <body>").append("<div>").append(" <h1>Tresc Dynamiczna</h1>").append("<div>")
                .append("<p>Wylosowana liczba:" +number+"</p>");

                if(number<0){
                    builder.append(" <p>Liczba jest nieparzysta</p>");
                }else {
                    builder.append(" <p>Liczba jest parzysta</p>");
                }


                builder.append("</div>").append(" <p>Teraz jest: "+ now +"</p>").append("</div>")
                        .append("</div>").append(" </body>").append("</html>");

                out.println(builder.toString());
    }
}
