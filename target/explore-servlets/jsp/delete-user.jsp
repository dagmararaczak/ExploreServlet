
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Delete</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>

<form action="/delete-user" method="post">
    <div class="alert alert-danger">
    <div class="jumbotron text-center" style="background-color: darkgrey">
<h2>Czy chcesz usunac uzytkownika: ${param.get("name")} ${param.get("lastName")}(${param.get("email")}) </h2>
    <input class="btn-lg btn-danger " type="submit" value="Tak">

    <a class="btn-lg btn-success" href="/mvc-users">Nie</a>
        </div>
        </div>
</form>





<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>
</body>
</html>
