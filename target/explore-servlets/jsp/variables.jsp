<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Obliczenia matematyczne</title>
</head>
<body>
<h1>Obliczenia matematyczne</h1>

<%Random random = new Random();%>
<%   int a = random.nextInt(201)-100;
    int b =random.nextInt(201)-100;
    int c =random.nextInt(201)-100;%>
<div>
    <p>Zmienne</p>
    <p>a = <%=a%></p>
    <p>b =<%=b%></p>
    <p>c =<%=c%></p>

</div>
<div>
    <h2>Obliczenia</h2>
    <p>a + b + c = <%=a+b+c%></p>
    <p>a - b - c =  <%=a-b-c%> </p>
    <p>a * b * c =  <%=a*b*c%></p>

    <p>a / b / c =  <%=(double) a/b/c%></p>
</div>
</body>
</html>
