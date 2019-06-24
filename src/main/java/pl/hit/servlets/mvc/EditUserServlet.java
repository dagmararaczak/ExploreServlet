package pl.hit.servlets.mvc;

import pl.hit.servlets.model.User;
import pl.hit.servlets.model.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet(urlPatterns = "/edit-user")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("login",req.getParameter("login"));
        req.setAttribute("name",req.getParameter("name"));
        req.setAttribute("lastName",req.getParameter("lastName"));
        req.setAttribute("email",req.getParameter("email"));
        req.getRequestDispatcher("/jsp/edit-user.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("userLogin");
        String name = req.getParameter("updateName");
        String lastName = req.getParameter("updateLastName");
        String birthDate = req.getParameter("updateBirthDate");
        LocalDate birth = LocalDate.parse(birthDate);

        UserRepository repository =(UserRepository) req.getServletContext().getAttribute("repository");
        User user = repository.getUser(login);

      if(!name.equals(user.getFirstName())){
            user.setFirstName(name);
        }else {

      }


        if(lastName.equals(user.getLastName())){
            user.setLastName(lastName);
        }

        if (!birth.equals(user.getBirthDate())){
            user.setBirthDate(birth);
        }

       repository.updateUser(login,user);

       resp.sendRedirect("/mvc-users");



    }
}
