<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dotuongminh
  Date: 25/7/25
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="/product/sua" method="post">
    Sua product <br>
    <div>ID: <input type="text" name="id" value="${p.id}"> </div> <br>
    <div>Ten: <input type="text" name="name" value="${p.name}"> </div> <br>
    <div>Cate:
      <select name="categoryName" class="form-control">
        <c:forEach var="cate" items="${cateList}">
          <option value="${cate.id}" <c:if test="${cate.id == p.category.id}">selected</c:if>>${cate.name}</option>
        </c:forEach>
      </select>
    </div> <br>
    <button>Sua</button>
  </form>
</body>
</html>
