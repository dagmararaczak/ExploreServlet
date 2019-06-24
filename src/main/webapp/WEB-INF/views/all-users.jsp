
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Users List</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">

</head>
<body>

<div class="jumbotron text-center" style="background-color: lightseagreen">
    <h1> Użytkownicy</h1>
</div>
<form action="/mvc-users" method="post">
<table class="table table-striped">

    <thead>
            <th>Login</th>
            <th>Email</th>
            <th>Profil</th>
            <th>Usuń </th>
            <th>Edytuj</th>
    </thead>
    <tbody>

        <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.login}</td>
            <td>${user.email}</td>


           <c:url  var="userProfile" value="/jsp/uprofile.jsp">
                <c:param name="name" value="${user.firstName}"/>
               <c:param name="lastName" value="${user.lastName}"/>
               <c:param name="email" value="${user.email}"/>
               <c:param name="login" value="${user.login}"/>
               <c:param name="birthDate" value="${user.birthDate}"/>
               <c:param name="age" value="${user.getAge()}"/>


           </c:url>
            <td> <a class="btn" style="background-color: mediumturquoise" href="${userProfile}"/> Profil </td>
            <c:if test="${user.login ne 'admin'}">
            <td><a class="btn" style="background-color: crimson" href="/delete-user?login=${user.login}&email=${user.email}
            &name=${user.firstName}&lastName=${user.lastName}">Usuń</a></td>
          <td><a class="btn" style="background-color: gold" href="/edit-user?login=${user.login}&name=${user.firstName}&lastName=${user.lastName}&birthDate=${user.birthDate}">Edytuj</a></td>
            </c:if>
            <c:if test="${user.login eq 'admin'}">
                <td></td>
                <td></td>
            </c:if>
        </tr>
</c:forEach>
    </tbody>
</table>
</form>
<a class="btn-lg btn-info" href="/mvc-register"> + Dodaj uzytkownika </a>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>
</body>
</html>
