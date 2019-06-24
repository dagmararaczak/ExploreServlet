package pl.hit.servlets.http;

import pl.hit.servlets.events.EventManager;
import pl.hit.servlets.events.EventType;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet(urlPatterns = "/diagnostics", loadOnStartup = 1)

public class DiagnosticServlet extends HttpServlet {
    EventManager eventManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();

        eventManager = (EventManager) req.getServletContext().getAttribute("eventManager");

        Map<EventType, Integer> occurences = eventManager.getOccurences();

        String format = req.getParameter("format");

        if (format == null) {
            resp.setContentType("text/plain");
            writePlain(out, occurences);

        } else {

            switch (format) {
                case "plain":
                    resp.setContentType("text/plain");
                    writePlain(out, occurences);
                    break;
                case "html":
                    resp.setContentType("text/html");
                    writeHtml(out, occurences);
                    break;
                case "json":
                    resp.setContentType("application/json");
                    writeJson(out, occurences);
                    break;
                case "xml":
                    resp.setContentType("application/xml");
                    writeXml(out, occurences);
                    break;
            }
        }

    }

    @Override
    public void init() {

        eventManager = (EventManager) this.getServletContext().getAttribute("eventManager");
        eventManager.getOccurences().forEach((eventType, count) -> System.out.println(eventType + "=" + count));


    }

    private void writePlain(PrintWriter printWriter, Map<EventType, Integer> occurences) {

        occurences.forEach((eventType, count) -> printWriter.println(eventType + "=" + count));

    }

    private void writeHtml(PrintWriter printWriter, Map<EventType, Integer> occurences) {

        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Diagnostics</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>");
        printWriter.println("Diagnostics");
        printWriter.println("</h1>");
        printWriter.println("<table>");
        printWriter.println("<tr>");
        printWriter.println("<th>");
        printWriter.println("Zdarzenie");
        printWriter.println("</th>");
        printWriter.println("<th>");
        printWriter.println("Wystapienia");
        printWriter.println("</th>");
        printWriter.println("</tr>");

        occurences.forEach((eventType, count) -> printWriter.println("<tr><td>" + eventType + "</td>" +
                "<td>" + count + "</td></tr>"));
        printWriter.println("</table>");
        printWriter.println("</body>");
        printWriter.println("</html>");

    }

    private void writeXml(PrintWriter printWriter, Map<EventType, Integer> occurences) {

        printWriter.println(" <diagnostics>");
        occurences.forEach((eventType, count) -> printWriter.println("<event><type>" + eventType + "</type><count>" +
                count + "</count></event>"));
        printWriter.println(" </diagnostics>");


    }

    private void writeJson(PrintWriter printWriter, Map<EventType, Integer> occurences) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{\n" +
                "            \"diagnostics\" : [");


        occurences.forEach((eventType, count) -> stringBuilder.append(" {\n" +
                "                \"name\" : \"" + eventType + "\",\n" +
                "                    \"count\" : " + count + " },"));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]\n" +
                "}   ");
        printWriter.println(stringBuilder.toString());

    }
}
