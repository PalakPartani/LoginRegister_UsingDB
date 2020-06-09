<%--
  Created by IntelliJ IDEA.
  User: Palak
  Date: 03-06-2020
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="login-box">
    <form action="Login" method="post">
        <div style="font-family: Arial;font-size:25px;font-weight: 700;text-align: center;padding: 10px">
            Login Form
        </div>
        <div>
            <input type="text" name="name" placeholder="Enter Username">
        </div>
        <div>
            <input type="password" name="password" placeholder="Enter Password">
        </div>
        <div>
            <input type="submit" name="submit" value="Login">
        </div>
        <div style="font-family: Arial;font-size:12px;font-weight: 700;text-align: center;padding: 30px">
            <a href="register.jsp">Registration</a>
        </div>
    </form>
</div>
</body>
</html>

<%
    Object customers = session.getAttribute("customers");
    if(customers != null){
        out.println("<script type=\"text/javascript\">");
        out.println("window.alert('Login Successfull!!');window.location.href='index.jsp'");
        out.println("</script>");
    }
    Object Error = session.getAttribute("Error");
    if(Error != null){
        out.println("<script type=\"text/javascript\">");
        out.println("window.alert('Username or Password incorrect!!')");
        out.println("</script>");
    }
%>