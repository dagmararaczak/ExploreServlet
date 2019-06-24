package pl.hit.servlets.http;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "/scopes")
public class ScopesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
       List<String> contextAtributes = Collections.list(req.getServletContext().getAttributeNames());
        List<String> sessionAtributes = Collections.list(req.getServletContext().getAttributeNames());
        List<String> requestAtributes = Collections.list(req.getServletContext().getAttributeNames());

        StringBuilder build = new StringBuilder();
        build.append(" <html>")
                .append("<head>")
                .append("<tittle>").append("Atrybuty w różnych zasięgach").append("</tittle>")
                .append("</head>")
                .append("<body>")
                .append("<h1>").append("Dostępne atrybuty z podziałem na zasięgi").append("</h1>").append("<hr/>")
                .append("<h2>").append("Atrybuty kontekst").append("</h2>")
                .append("<table>")
                .append("<tr>")
                .append("<th>").append("Nazwa").append("</th>")
                .append("<th>").append("Typ").append("</th>")
                .append("<th>").append("Wartość").append("</th>")
                .append("</tr>");
        contextAtributes.forEach(atribute ->{ Object value = req.getServletContext().getAttribute(atribute); build.append("<tr>").append("<td>").append(atribute)
                .append("</td>").append("<td>").append(atribute.getClass())
                .append("</td>")
                .append("<td>").append(value)
                .append("</td>").append("</tr>");});


        build.append("</table>")
                .append("<h2>").append("Atrybuty sesji").append("</h2>")
                .append("<table>")
                .append("<tr>")
                .append("<th>").append("Nazwa").append("</th>")
                .append("<th>").append("Typ").append("</th>")
                .append("<th>").append("Wartość").append("</th>")
                .append("</tr>");
        sessionAtributes.forEach(atribute ->{ Object value = req.getSession().getAttribute(atribute); build.append("<tr>").append("<td>").append(atribute)
                .append("</td>").append("<td>").append(atribute.getClass())
                .append("</td>")
                .append("<td>").append(value)
                .append("</td>").append("</tr>");});
        build.append("</table>")
                .append("<h2>").append("Atrybuty zadania").append("</h2>")
                .append("<table>")
                .append("<tr>")
                .append("<th>").append("Nazwa").append("</th>")
                .append("<th>").append("Typ").append("</th>")
                .append("<th>").append("Wartość").append("</th>")
                .append("</tr>");

        requestAtributes.forEach(atribute ->{ Object value = req.getAttribute(atribute); build.append("<tr>").append("<td>").append(atribute)
                .append("</td>").append("<td>").append(atribute.getClass())
                .append("</td>")
                .append("<td>").append(value)
                .append("</td>").append("</tr>");});
        build.append("</table>")
                .append("</body>").append("</html>");

        writer.println(build.toString());

        System.out.println("ATRYBUT:" +  req.getSession().getAttribute("REQUEST_ATTR") );
        req.setAttribute("REQUEST_ATTR",req.getSession().getAttribute("REQUEST_ATTR"));
        req.getSession().removeAttribute("REQUEST_ATTR");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String value  = req.getParameter("value");
        String scope = req.getParameter("scope");

        if(name == null | value == null | scope == null){
            resp.sendError(400,"Bad Request");
            resp.sendRedirect("/scopes");
        }
        switch (scope){
            case "application scope":
                ServletContext servletContext = req.getServletContext();
                servletContext.setAttribute(name, value);
                break;
            case "session scope":

                HttpSession session = req.getSession();
                session.setAttribute(name,value);
                break;
            case "request scope":
                req.getSession(true);
                req.setAttribute(name,value);

                break;
        }


        resp.sendRedirect("/scopes");
        req.getSession().setAttribute("REQUEST_ATTR",name+"="+value);





    }
}
