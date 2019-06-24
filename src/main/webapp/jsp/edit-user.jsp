
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Edit user</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">


</head>
<body>

<form action="/edit-user" method="post">
    <div class="jumbotron text-center" style="background-color: lightseagreen">
        <h1>Edytuj uzytkownika : ${param.get("login")}</h1>
    </div>
    <div class="form-group">
        <label ><strong>&nbsp;&nbsp;Imię </strong></label>
        <input type="text" name="updateName" placeholder="Imię" class="form-control" value="${param.get("name")}">
    </div>
    <div class="form-group">
        <label><strong>&nbsp;&nbsp;Nazwisko </strong></label>
        <input type="text" name="updateLastName"  placeholder="Nazwisko" class="form-control" value="${param.get("lastName")}">
    </div>
    <div class="form-group">
        <label ><strong>&nbsp;&nbsp;Data urodzenia </strong></label>
        <input type="text" name="updateBirthDate" placeholder="Data urodzenia" class="form-control"value="${param.get("birthDate")}">
    </div>


    <input type="hidden" name="userLogin" value="${param.get("login")}">
     <input class="btn-lg" style="background-color: gold" type="submit" value="Potwierdz">

</form>
<a class="btn-lg btn-info" href="/mvc-users"> Cofnij </a>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>
</body>
</html>
