<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dotuongminh
  Date: 14/7/25
  Time: 13:05
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
        <td>Ho ten sinh vien</td>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
          <td>${status.index + 1}</td>
          <td>${student}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
