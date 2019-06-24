package pl.hit.servlets.http;

import pl.hit.servlets.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/profile")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");
        PrintWriter out = resp.getWriter();
        StringBuilder builder = new StringBuilder();

        builder.append(" <html>")
                .append("<head>")
                .append("<tittle>").append("Strona logowania").append("</tittle>")
                .append("</head>")
                .append("<body>")
                .append("<form action=\"/profile\" method=\"post\">")
                .append("Witaj ")
                .append(user.getLogin())
                .append("<br>")
                .append(" Zycze Ci milego dnia")
                .append("<br>")
                .append("<a href=\"/logout\">Logout</a>")
                .append("</form>")
                .append("<body>").append("</html>");

        out.println(builder.toString());

    }
}
