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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        StringBuilder builder = new StringBuilder();

        builder.append(" <html>")
                .append("<head>")
                .append("<tittle>").append("Strona logowania").append("</tittle>")
                .append("</head>")
                .append("<body>")
                .append("<form action=\"/login\" method=\"post\">")
                .append("Login: ").append("<input type=\"text\" name=\"login\">")
                .append("Password: ").append("<input type=\"password\" name=\"password\">")
                .append("<input  type=\"submit\" name=\"submit\" value=\"Login\">")
                .append("</form>")
                .append("</body>").append("</html>");

        out.println(builder.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session;
        if (!login.equals("admin")| !password.equals("admin")){
            resp.sendRedirect("/login");
        }else{
           User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            session = req.getSession();
            session.invalidate();
            session = req.getSession(true);
            session.setAttribute("user",user);
            resp.sendRedirect("/profile");

        }
    }
}
