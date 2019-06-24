package pl.hit.servlets.jsp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/jsp/template-servlet")
public class TemplateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        PrintWriter out = resp.getWriter();
        RequestDispatcher dispatcher;
        StringBuilder builder = new StringBuilder();

        builder.append("<html>");
        out.println(builder.toString());
        builder.delete(0, builder.length());

        dispatcher = context.getNamedDispatcher("HeaderServlet");
        dispatcher.include(req, resp);

        builder.append("<p>").append("Koktajl zamętu , przeplatają sie zdarzenia.<br>" +
                " Gubię sie na pustej drodze pośród straganów codzienności. Ktos zamazał drogowskazy.<br> " +
                "Zmiksowalam łzy ze śmiechem. Paranoja. Uwierzyłam w dzien, zjadła mnie noc.<br>" +
                " Czekam wieczorami az dotkniesz mych powiek. Ćmy porywaja me sny Gwiazdy kradną chwile.<br>" +
                " Zjedz mnie. Zjedz w całości. Udław sie. Smacznego.")
                .append("</p>").append("</body>");

        out.println(builder.toString());
        builder.delete(0, builder.length());
        dispatcher = context.getNamedDispatcher("FooterServlet");
        dispatcher.include(req, resp);
        builder.append("</html>");
        out.println(builder.toString());


    }
}
