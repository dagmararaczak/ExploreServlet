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


@WebServlet(urlPatterns = "/mvc-register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        req.setAttribute("newUser",user);
        req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String login = req.getParameter("login");
        String name = req.getParameter("firstName");
        String surname = req.getParameter("lastName");
        String birthDate = req.getParameter("birthDate");
        String email = req.getParameter("email");
        LocalDate birth = LocalDate.parse(birthDate);
        User firstUser = new User();

        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("repository");


        if(name != null ){
            firstUser.setFirstName(name);
        } else{
            firstUser.setFirstName("");
        }

        if(surname != null){
            firstUser.setLastName(surname);
        }else{
            firstUser.setLastName("");
        }

        if(birth != null){
            firstUser.setBirthDate(birth);
        }

        if(login.isEmpty()  | email.isEmpty() | userRepository.getUser(login) != null ){
            resp.sendRedirect("/mvc-register");
        } else {
            firstUser.setLogin(login);
            firstUser.setEmail(email);
            userRepository.addUser(login,firstUser);
            resp.sendRedirect("/mvc-users");
        }




    }
}
