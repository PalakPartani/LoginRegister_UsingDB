<%--
  Created by IntelliJ IDEA.
  User: Palak Rubi
  Date: 08-06-2020
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("customers", null);
    session.setAttribute("Error", null);
    Object customers = session.getAttribute("customers");
    if (customers == null) {
        out.println("<script type=\"text/javascript\">");
        out.println("window.alert('Logout');window.location.href='login.jsp'");
        out.println("</script>");
    }
%>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<h1>Logout</h1>
</body>
</html>

