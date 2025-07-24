<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-4">
    <h3 class="mb-3">Danh sách sinh viên</h3>

    <form action="/students/hien-thi" class="d-flex mb-3" role="search" method="get">
        <input name="keyword" value="${keyword}" class="form-control me-2" type="search" placeholder="Tìm kiếm theo tên" />
        <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
    </form>

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

    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <c:forEach begin="1" end="${totalPages}" var="i">
                <li class="page-item ${i == currentPage ? 'active' : ''}">
                    <a class="page-link"
                       href="/students/hien-thi?page=${i}${keyword != null ? '&keyword=' += keyword : ''}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </nav>

    <hr/>
    <h4>Thêm sinh viên</h4>
    <form action="/students/them" method="post">
        <div class="mb-2">ID: <input type="text" name="id" class="form-control"></div>
        <div class="mb-2">Tên: <input type="text" name="name" class="form-control"></div>
        <div class="mb-2">Email: <input type="text" name="email" class="form-control"></div>
        <div class="mb-2">SĐT: <input type="text" name="phone" class="form-control"></div>
        <button class="btn btn-primary">Thêm</button>
    </form>
</div>
</body>
</html>
