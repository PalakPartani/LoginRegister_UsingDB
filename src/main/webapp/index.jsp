<%
    String name=(String)session.getAttribute("username");
    String email=(String)session.getAttribute("email");
    String address=(String)session.getAttribute("address");
    //out.print("Hello User: You have entered the name: "+name);
%>0
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style>
        .card{
            margin: 100px auto;
            padding: 20px;
            width: 400px;
            box-shadow: 0px 0px 10px silver;
            background-color: white;
        }
    </style>
</head>
<body>
<div class="card">
<div style="width:200px;margin:0px auto">
    <img src="https://www.pngmart.com/files/10/Business-User-Account-PNG-Photos.png" width="100%">
</div>
    <div style="padding:10px 5px">
        <h2>User Name : <% out.print(name); %></h2>
    </div>
    <div style="padding:5px">
        <h5>Email : <% out.print(email); %></h5>
    </div>
    <div style="padding:5px">
        <h5>Address : <% out.print(address); %></h5>
    </div>
    <div style="padding:20px;text-align: center">
        <a style="padding:10px;text-decoration: none;color:black;color:white;background-color: blueviolet;border-radius: 10px;" href="login.jsp">Logout</a>
    </div>

</div>


</body>
</html>
