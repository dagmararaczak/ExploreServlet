<%@ page import="java.time.LocalDate" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
    <% int counter = 0;%>
<p> Technologia JSP , Dzisiejsza data : <%=LocalDate.now()%> Liczba odwiedzin : <%= counter++%></p>