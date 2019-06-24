
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request-info</title>

</head>
<body>
<p> Metoda zadania : <%=request.getMethod()%></p><br>
<p> Typ tresci : <%=request.getContentType()%></p><br>
<p> Typ kodowania : <%=request.getCharacterEncoding()%></p><br>
<p> Parametry zadania :<%=request.getParameterNames().nextElement()%></p><br>
<p> Naglowki zadania :<%=request.getHeaderNames().nextElement()%></p><br>




</body>
</html>
