package com.example.sof3012.controller;

import com.example.sof3012.entity.Student;
import com.example.sof3012.services.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = {
        "/students/hien-thi",
        "/students/them",
        "/students/sua",
        "/students/viewSua",
        "/students/xoa"
})
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/students/hien-thi":
                hienThi(request, response);
                break;
            case "/students/xoa":
                xoa(request, response);
                break;
            case "/students/viewSua":
                viewSua(request, response);
                break;
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        String pageParam = request.getParameter("page");

        int page = (pageParam != null) ? Integer.parseInt(pageParam) : 1;
        int size = 5;

        List<Student> students;
        long total;

        if (keyword != null && !keyword.trim().isEmpty()) {
            students = studentService.getStudentsByNameAndPage(keyword, page, size);
            total = studentService.countStudentsByKeyword(keyword);
        } else {
            students = studentService.getStudentsByPage(page, size);
            total = studentService.countStudents();
        }

        int totalPages = (int) Math.ceil((double) total / size);

        request.setAttribute("students", students);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("keyword", keyword); // để giữ lại trong ô tìm kiếm
        request.getRequestDispatcher("/view/StudentList.jsp").forward(request, response);
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        studentService.xoaStudent(id);
        response.sendRedirect("/students/hien-thi");
    }

    private void viewSua(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("students", studentService.getStudent(id));
        request.getRequestDispatcher("/view/suaStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/students/them":
                them(request, response);
                break;
            case "/students/sua":
                sua(request, response);
                break;
        }
    }

    private void sua(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        studentService.suaStudent(id, name, email, phone);
        response.sendRedirect("/students/hien-thi");
    }

    private void them(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        studentService.themStudent(id, name, email, phone);
        response.sendRedirect("/students/hien-thi");
    }
}
