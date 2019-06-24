<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: dagmar
  Date: 2019-05-19
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<%String name = request.getParameter("name");%>
<div>
    <p>
        Imie : <%=name%> Dzisiejsza data: <%=LocalDate.now()%>
    </p>
</div>
