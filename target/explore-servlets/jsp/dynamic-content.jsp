<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tresc dynamiczna</title>
</head>
<body>

<%LocalDateTime now = LocalDateTime.now(); %>
<% Random random = new Random();%>
<% Integer number = random.nextInt(21) -10;%>
<div>
    <h1>Tresc dynamiczna</h1>
    <div>
        <p>Wylosowana liczba: <%=number%></p>
        <%if(number<0){%>
        <p>Liczba jest nieparzysta</p>

        <%}else{%>

        <p>Liczba jest parzysta</p>

       <% } %>
    </div>
    <div>
        <p>Teraz jest: <%=now%></p>
    </div>
</div>

</body>
</html>
