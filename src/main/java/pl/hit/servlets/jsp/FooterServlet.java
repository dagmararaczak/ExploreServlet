package pl.hit.servlets.jsp;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "FooterServlet")
public class FooterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        StringBuilder builder = new StringBuilder();


        builder.append("<div>").append("<p>")
                .append("Imie : " +req.getParameter("name") +" Dzisiejsza data : "+ LocalDate.now())
                .append("</p>").append("</div>");

        out.println(builder.toString());


    }
}
