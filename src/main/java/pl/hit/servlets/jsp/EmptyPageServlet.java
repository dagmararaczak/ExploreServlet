package pl.hit.servlets.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/jsp/empty-page-servlet")
public class EmptyPageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        StringBuilder builder = new StringBuilder();


        builder.append(" <html>").append(" <head>").append("<title>Pusta strona</title>")
                .append("</head>")
                .append(" <body>").append("<div>").append(" <h1>Pusta strona</h1>")
                .append("</div>").append(" </body>").append("</html>");

        out.println(builder.toString());


    }
}
