<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Anniversary</title>
</head>
<body>

<c:set var = "now" value = "<%= new java.util.Date()%>" />
<p>Dzisiaj <fmt:formatDate value="${now}" pattern="EEEE, d MMMM YYYY" /> są Twoje urodziny</p>
<p>Sto lat sto lat ${param.get("name")} </p>
<a href="users-list.jsp">Wszyscy uzytkownicy</a>
</body>
</html>
