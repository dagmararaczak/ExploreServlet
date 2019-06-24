<%@ page import="pl.hit.servlets.events.EventManager" %>
<%@ page import="java.util.Map" %>
<%@ page import="pl.hit.servlets.events.EventType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kontekst aplikacji</title>
</head>
<body>
<p>Kontekst aplikacji: </p>
<%EventManager eventManager =(EventManager)application.getAttribute("eventManager");%>

<%for(Map.Entry<EventType,Integer> event : eventManager.getOccurences().entrySet()){%>
    <p><%=event.getKey() + " = " +event.getValue()%></p>
<%}%>

</body>
</html>
