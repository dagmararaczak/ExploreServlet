package pl.hit.servlets.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(urlPatterns = "/cookies")

public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        StringBuilder build = new StringBuilder();
        build.append(" <html>").append("<head>").append("<tittle>").append("Ciasteczka na stronie")
                .append("</tittle>").append("</head>").append("<body>")
                .append("<h1>").append("Dostepne ciasteczka").append("</h1>").append("<table>")
                .append("<tr>")
                .append("<th>").append("Nazwa").append("</th>")
                .append("<th>").append("Wartosc").append("</th>")
                .append("<th>").append("Sciezka").append("</th>")
                .append("<th>").append("Wiek").append("</th>")
                .append("</tr>");

        Arrays.stream(cookies).forEach(cookie -> build.append("<tr>").append("<td>").append(cookie.getName())
                .append("</td>")
                .append("<td>").append(cookie.getValue())
                .append("</td>")
                .append("<td>").append(cookie.getPath())
                .append("</td>")
                .append("<td>").append(cookie.getMaxAge())
                .append("</td>").append("</tr>")
        );
        build.append("</table>").append("</body>").append("</html>");

        PrintWriter out = resp.getWriter();
        out.println(build.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String value = req.getParameter("value");
        String path = req.getParameter("path");
       String age = req.getParameter("age");
        Cookie cookie = new Cookie(name,value);
        cookie.setPath(path);
        cookie.setMaxAge(Integer.parseInt(age));
        resp.addCookie(cookie);
        resp.sendRedirect("/cookies");





    }
}
