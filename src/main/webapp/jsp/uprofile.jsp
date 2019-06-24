
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Profile</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

</head>
<body>

<div class="alert alert-info">
<h1> Witam<strong> ${param.get("name")}</strong></h1>
    </div>
<table class="table table-striped">

    <thead>
            <th>  </th>
            <th>Dane uzytkownika</th>
    </thead>
    <tbody>
            <tr>
                <td>Login</td>
                <td>${param.get("login")}</td>
            </tr>
        <tr>
                <td>Imie</td>
                <td>${param.get("name")}</td>
            </tr>
            <tr>
                <td>Nazwisko</td>
                <td>${param.get("lastName")}</td>
            </tr>
            <tr>
                <td>Data urodzenia</td>
                <td>${param.get("birthDate")}</td>
            </tr>
            <tr>
                <td>Wiek</td>
                <td>${param.get("age")}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${param.get("email")}</td>
            </tr>


    </tbody>


</table>

<a class="btn-lg btn-info" href="/mvc-users"> Cofnij </a>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>
</body>
</html>
