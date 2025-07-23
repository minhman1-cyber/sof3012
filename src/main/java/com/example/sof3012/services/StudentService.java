package com.example.sof3012.services;

import com.example.sof3012.entity.Student;
import com.example.sof3012.repository.StudentRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class StudentService {
    private StudentRepo studentRepo = new StudentRepo();
    public List<Student> getStudents() {
        return studentRepo.getStudents();
    }
    public void themStudent(Long id, String name, String email, String phone) {
        Student student = new Student(id, name, email, phone);
        studentRepo.themStudent(student);
    }
    public void suaStudent(Long id, String name, String email, String phone) {
        Student student = new Student(id, name, email, phone);
        studentRepo.suaStudent(student);
    }
    public void xoaStudent(Long id) {
        studentRepo.xoa(id);
    }

    public Student getStudent(Long id) {
        return studentRepo.getStudent(id);
    }

    public List<Student> getStudentsByPage(int page, int size) {
        return studentRepo.getStudentsByPage(page, size);
    }

    public long countStudents() {
        return studentRepo.countStudents();
    }
}
