package pl.hit.servlets.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/validation")
public class ValidationServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(ValidationServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/fill-form.html").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String name = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDate = req.getParameter("birthDate");
        String pesel = req.getParameter("pesel");
        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmedPassword");
        TreeMap<String, String> errors = new TreeMap<>();
        if(login == null |login.length()<8|login.length()>12){
            errors.put("login",login + "- Nie może być puste; Musi składać się z od 8 do 12 znaków alftanumerycznych");
            System.out.println("BLAAAAAADDDD LOOGIN");
        }else{
            req.setAttribute("login", login);
        }
        if(email == null | !email.contains("@")){
            errors.put("email",email + "- Nie może być puste; Musi mieć poprawny format adresu email (może być uproszczony)");
            System.out.println("BLAAAAAADDDD EMAAAIL");
        }else{
            req.setAttribute("email", email);
        }

        if (name ==null | name.length()<3){
            errors.put("firstName",name + "- Nie może być puste; Musi zawierać minimum 3 znaki");
            System.out.println("BLAAAAAADDDD NAAAMEEE");
        }else{
            req.setAttribute("firstName", name);
        }

        if(lastName == null | lastName.length()<3){
            errors.put("lastName", lastName + "- Nie może być puste; Musi zawierać minimum 3 znaki");
            System.out.println("BLAAAAAADDDD LAAASTNAAME");
        }else{
            req.setAttribute("lastName",lastName);
        }

        if (!birthDate.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")){
            errors.put("birthDate", birthDate +
                    "- Może być puste; Jeżeli nie jest puste to musi być datą w formacie YYYY-MM-DD (np. 2018-12-06)");
            System.out.println("BLAAAAAADDDD DAAATAA");
        }else {
            req.setAttribute("birthDate",birthDate);
        }


        if(pesel == null | pesel.length()<11 | pesel.length()>11 | !pesel.matches("[0-9]+" ) ){
            errors.put("pesel",pesel + "- Nie może być puste; Musi zawierać 11 znaków, z których każda jest cyfrą");
            System.out.println("BLAAAAAADDDD PESEL");
        }else {
            req.setAttribute("pesel",pesel);
        }

        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Pattern letter = Pattern.compile("[A-Z]");
        Matcher specialLetter = special.matcher(password);
        Matcher upperLetter = letter.matcher(password);
        if (password.length()<8 | !specialLetter.find() | !upperLetter.find() ){
            errors.put("password","Nie może być puste; Musi zawierać minimum 8 znaków; Musi zawierać przynajmniej jedną dużą literę i jeden znak specjalny (np. !)");
            System.out.println("BLAAAAAADDDD PASSWORDD");
        }else{
            req.setAttribute("password",password);

        }

        if(!confirmedPassword.equals(password)){
            errors.put("confirmedPassword", "Nie może być puste; Musi być zgodne z wartością pola Hasło");
            System.out.println("BLAAAAAADDDD PASSWORDD COOONFIRMEED");
        }else {
            req.setAttribute("confirmedPassword",confirmedPassword);
        }



        if (errors.isEmpty()){
            writer.println("Formularz zostal wypelniony poprawnie");
        }else{
            resp.sendRedirect("/validation");
        }



    }
}
