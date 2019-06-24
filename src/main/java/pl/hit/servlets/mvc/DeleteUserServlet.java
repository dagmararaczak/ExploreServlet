package pl.hit.servlets.mvc;

import pl.hit.servlets.model.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/delete-user")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getServletContext().setAttribute("firstName",req.getParameter("name"));
        req.getServletContext().setAttribute("lasttName",req.getParameter("lastName"));
        req.getServletContext().setAttribute("email",req.getParameter("email"));
        req.getServletContext().setAttribute("userLogin",req.getParameter("login"));
        req.getRequestDispatcher("/jsp/delete-user.jsp").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserRepository repository =(UserRepository) req.getServletContext().getAttribute("repository");
        String login =(String)req.getServletContext().getAttribute("userLogin");
        String email =(String)req.getServletContext().getAttribute("email");
        repository.getUsers().remove(repository.getUser(login));
        resp.sendRedirect("/mvc-users");

    }
}
