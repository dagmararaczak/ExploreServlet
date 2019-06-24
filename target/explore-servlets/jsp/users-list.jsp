<%@ page import="java.util.List" %>
<%@ page import="pl.hit.servlets.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>

    <title>Uzytkownicy</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>
<%List<User> userList = new ArrayList<>();
User user1 = new User("dagus","dagus@gmail.com");
user1.setFirstName("Dagmara");
user1.setLastName("Raczaq");
user1.setBirthDate(LocalDate.of(1988,07,06));
User user2 = new User("Wiewiorka","wiewiorka@gmail.com");
    user2.setFirstName("Sylwia");
    user2.setLastName("Wiewiora");
    user2.setBirthDate(LocalDate.of(1989,05,20));
User user3 = new User("Zolwik","zolwik@gmail.com");
    user3.setFirstName("Maciek");
    user3.setLastName("Zolwik");

    user3.setBirthDate(LocalDate.of(1995,02,06));

    userList.add(user1);
    userList.add(user2);
    userList.add(user3);

    pageContext.setAttribute("userList",userList);
    LocalDate localDate = LocalDate.now();
    pageContext.setAttribute("localDate",localDate);
%>

<table class="table-striped">
   <thead>
        <th>Imie:</th>
        <th>Nazwisko: </th>
        <th>Wiek: </th>
        <th>Login: </th>
        <th>Email:</th>
        <th>Plec</th>
        <th>Pelnoletni</th>
        <th>Urodziny</th>

   </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
    <tr>

        <td>${user.firstName}</td>
        <td><${user.lastName}</td>
        <td>${user.age}</td>
        <td>${user.login}</td>
        <td>${user.email}</td>

        <c:choose>
            <c:when test="${user.firstName.endsWith(\"a\")}">
        <td>kobieta</td>
            </c:when>
            <c:otherwise>
                <td>mezczyzna</td>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${user.age>=18}">
                <td> Tak </td>
            </c:when>
            <c:otherwise>
                <td> Nie </td>
            </c:otherwise>
        </c:choose>
        <c:if test="${localDate.month == user.birthDate.month && localDate.dayOfMonth == user.birthDate.dayOfMonth}">


            <c:url  var="anniversaryLink" value="/jsp/anniversary.jsp">
                <c:param name="name" value="${user.firstName}"/>
            </c:url>
            <td> <a class="btn btn-success" href="${anniversaryLink}"/>Sto lat</td>
    </c:if>
    </tr>
    </c:forEach>

    </tbody>
</table>

<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>
</body>
</html>
