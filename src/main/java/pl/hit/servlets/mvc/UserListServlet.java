package pl.hit.servlets.mvc;

import pl.hit.servlets.model.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/mvc-users")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository =(UserRepository) req.getServletContext().getAttribute("repository");

        req.setAttribute("userList", userRepository.getUsers());
        req.getRequestDispatcher("/WEB-INF/views/all-users.jsp").forward(req,resp);

    }
}
