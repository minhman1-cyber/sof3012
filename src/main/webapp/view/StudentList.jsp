<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dotuongminh
  Date: 18/7/25
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Thong tin hoc vien
    <table>
        <thead>
        <tr>
            <td>Stt</td>
            <td>ID</td>
            <td>Ho ten sinh vien</td>
            <td>Email</td>
            <td>Phone</td>
            <td>Service</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.phone}</td>
                <td>
                    <a href="/students/xoa?id=${student.id}">Xoa</a>
                    <a href="/students/viewSua?id=${student.id}">Sua</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="/students/them" method="post">
        Them sinh vien <br>
        <div>ID: <input type="text" name="id"> </div> <br>
        <div>Ten: <input type="text" name="name"> </div> <br>
        <div>Email: <input type="text" name="email"> </div> <br>
        <div>Phone: <input type="text" name="phone"> </div> <br>
        <button>Thêm</button>
    </form>



</body>
</html>
