package pl.hit.servlets.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/errors-generator")
public class ErrorsGeneratorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("error");

        switch (value){
            case "400":
                resp.sendError(400,"Bad Request");
                break;
            case "401":
                resp.sendError(401,"Unauthorized");
                break;
            case "404":
                resp.sendError(404,"Not Found");
                break;
            case "405":
                resp.sendError(405,"Method Not Allowed");
                break;
            case "500":
                resp.sendError(500,"Internal Server Error");
                break;
            case "503":
                resp.sendError(503,"Service Unavailable");
                break;
            case "npe":
               throw  new NullPointerException("NullPointerException");
            case "rte":

                throw new RuntimeException("RuntimeException");
            case "ioe":

                throw new IOException(" IOException");


        }
        }

}
