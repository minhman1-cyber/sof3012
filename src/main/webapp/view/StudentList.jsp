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
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap JS (nếu bạn cần dùng modal, dropdown,...) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
Thong tin hoc vien
<div class="container mt-4">
    <h3 class="mb-3">Danh sách sinh viên</h3>
    <table class="table table-bordered table-striped table-hover align-middle">
        <thead class="table-dark text-center">
        <tr>
            <th scope="col">STT</th>
            <th scope="col">ID</th>
            <th scope="col">Họ tên</th>
            <th scope="col">Email</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student" varStatus="status">
            <tr>
                <td class="text-center">${status.index + 1}</td>
                <td class="text-center">${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.phone}</td>
                <td class="text-center">
                    <a href="/students/xoa?id=${student.id}" class="btn btn-sm btn-danger">Xóa</a>
                    <a href="/students/viewSua?id=${student.id}" class="btn btn-sm btn-warning">Sửa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Pagination sử dụng Bootstrap -->
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <c:forEach begin="1" end="${totalPages}" var="i">
                <li class="page-item ${i == currentPage ? 'active' : ''}">
                    <a class="page-link" href="/students/paging?page=${i}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </nav>

</div>
<form action="/students/them" method="post">
    Them sinh vien <br>
    <div>ID: <input type="text" name="id"></div>
    <br>
    <div>Ten: <input type="text" name="name"></div>
    <br>
    <div>Email: <input type="text" name="email"></div>
    <br>
    <div>Phone: <input type="text" name="phone"></div>
    <br>
    <button>Thêm</button>
</form>


</body>
</html>
