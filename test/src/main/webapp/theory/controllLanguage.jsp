<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 2021/1/11
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int day=3;%>
<html>
<head>
    <title>控制语句</title>
</head>
<body>
<h1>if-else</h1>
<% if(day==6 | day==7){ %>
    <p>今天是周末</p>
<% } else{ %>
<p>今天不是周末</p>
<% } %>
</body>
</html>
