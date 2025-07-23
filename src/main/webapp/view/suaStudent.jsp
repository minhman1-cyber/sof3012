<%--
  Created by IntelliJ IDEA.
  User: dotuongminh
  Date: 23/7/25
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  Sua student
  <form action="/students/sua" method="post">
    Sua sinh vien <br>
    <div>ID: <input type="text" name="id" value="${students.id}"> </div> <br>
    <div>Ten: <input type="text" name="name" value="${students.name}"> </div> <br>
    <div>Email: <input type="text" name="email" value = "${students.email}"> </div> <br>
    <div>Phone: <input type="text" name="phone" value="${students.phone}"> </div> <br>
    <button>Sua</button>
  </form>
</body>
</html>
