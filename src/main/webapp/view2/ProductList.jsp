<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dotuongminh
  Date: 25/7/25
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
  <div class="container mt-4">
    <h3 class="mb-3">Danh sách sản phẩm</h3>

    <form action="/product/hien-thi" class="d-flex mb-3" role="search" method="get">
      <input name="keyword" value="${keyword}" class="form-control me-2" type="search" placeholder="Tìm kiếm theo tên" />
      <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
    </form>

    <table class="table table-bordered table-striped table-hover align-middle">
      <thead class="table-dark text-center">
      <tr>
        <th scope="col">STT</th>
        <th scope="col">ID</th>
        <th scope="col">Tên</th>
        <th scope="col">Nhãn hàng</th>
        <th scope="col">Thao tác</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${products}" var="p" varStatus="status">
        <tr>
          <td class="text-center">${status.index + 1}</td>
          <td class="text-center">${p.id}</td>
          <td>${p.name}</td>
          <td>${p.category.name}</td>
          <td class="text-center">
            <a href="/product/view?id=${p.id}" class="btn btn-sm btn-danger">Xem</a>
            <a href="/product/xoa?id=${p.id}" class="btn btn-sm btn-danger">Xóa</a>
            <a href="/product/viewSua?id=${p.id}" class="btn btn-sm btn-warning">Sửa</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

    <nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center">
        <c:forEach begin="1" end="${totalPages}" var="i">
          <li class="page-item ${i == currentPage ? 'active' : ''}">
            <a class="page-link"
               href="/product/hien-thi?page=${i}${keyword != null ? '&keyword=' += keyword : ''}">${i}</a>
          </li>
        </c:forEach>
      </ul>
    </nav>

    <hr/>
    <h4>Thêm sản phẩm</h4>
    <form action="/product/them" method="post">
      <div class="mb-2">ID: <input type="text" name="id" class="form-control"></div>
      <div class="mb-2">Tên: <input type="text" name="name" class="form-control"></div>
      <div class="mb-2">Cate:
        <select name="categoryName" class="form-control">
          <c:forEach var="cate" items="${cateList}">
            <option value="${cate.id}">${cate.name}</option>
          </c:forEach>
        </select>
      </div>
      <button class="btn btn-primary">Thêm</button>
    </form>
  </div>
</body>
</html>
