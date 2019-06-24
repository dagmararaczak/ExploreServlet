package pl.hit.servlets.mvc;

import pl.hit.servlets.model.User;
import pl.hit.servlets.model.UserRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserRepository userRepository = new UserRepository();
        User user = new User("admin","admin@gmail.com");
        userRepository.addUser("admin",user);
        sce.getServletContext().setAttribute("repository",userRepository);

    }
}
