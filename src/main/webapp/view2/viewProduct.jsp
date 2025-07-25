<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dotuongminh
  Date: 25/7/25
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Thong tin san pham
  <table>
    <thead>
    <tr>
      <td>Stt</td>
      <td>ID</td>
      <td>Ten</td>
      <td>Cate</td>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td>${status.index + 1}</td>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.category.name}</td>
      </tr>
    </tbody>
  </table>
</body>
</html>
