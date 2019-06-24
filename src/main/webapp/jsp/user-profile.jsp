<%@ page import="pl.hit.servlets.model.User" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Uzytkownicy</title>
</head>
<body>
<%User user = new User("dagus","dagus@gmail.com");
user.setFirstName("Dagmara");
user.setLastName("Raczaq");
user.setBirthDate(LocalDate.of(1988,07,06));
pageContext.setAttribute("user",user);
%>
<jsp:useBean id = "user1" class = "pl.hit.servlets.model.User" />
<jsp:setProperty name="user1" property = "login" value ="bocian"/>
<jsp:setProperty name="user1" property = "email" value="bocian@gmail.com"/>
<jsp:setProperty name="user1" property = "firstName" value="Zenek"/>
<jsp:setProperty name="user1" property = "lastName" value="Kowalski"/>
<jsp:setProperty name="user1" property = "birthDate" value="<%=LocalDate.of(1999,05,05)%>"/>

<p>Uzytkownik nr 1 : </p>
<p>Imie : ${user.firstName}</p>
<p> Nazwisko: ${user.lastName}</p>
<p> Email: ${user.email}</p>
<p> Login: ${user.login}</p>
<p>Wiek: ${user.age}</p>

<p>Uzytkownik nr 2 : </p>
<p>Imie : ${user1.firstName}</p>
<p> Nazwisko: ${user1.lastName}</p>
<p> Email: ${user1.email}</p>
<p> Login: ${user1.login}</p>
<p>Wiek: ${user1.age}</p>

</body>
</html>
