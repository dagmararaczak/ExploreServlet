
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<head>
    <title>Registration</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">

    
</head>
<body>

<div class="jumbotron text-center" style="background-color: lightseagreen">
    <h1> Rejestracja </h1>
    </div>

<form action="/mvc-register" method="post">


    <div class="form-group">
        <label ><strong>&nbsp;&nbsp;Login</strong></label>
    <input type="text" name="login" value="${user.login}"  class="form-control">
        </div>


    <div class="form-group">
        <label ><strong>&nbsp;&nbsp;Imie</strong></label>
     <input type="text" name="firstName" value="${user.firstName}"  class="form-control">
    </div>

    <div class="form-group" >
        <label ><strong>&nbsp;&nbsp;Nazwisko</strong></label>
    <input type="text" name="lastName" value="${user.lastName}"  class="form-control">
        </div>

    <div class="form-group" >
        <label><strong>&nbsp;&nbsp;Data urodzenia</strong></label>
   <input type="text" name="birthDate" value="${user.birthDate}"  class="form-control">
        </div>

    <div class="form-group" >
        <label ><strong>&nbsp;&nbsp;Email</strong></label>
     <input type="text" name="email" value="${user.email}" class="form-control">
            </div>
    <input class="btn" style="background-color: teal" type="submit"value="Przeslij" >
    <input class="btn" style="background-color: crimson"  type="reset" value="Wyczysc">

</form>

<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>
</body>
</html>
