package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> GetAllStudents();
    Student updateStudent(int id, Student updatedStudent);
    void deleteStudent(int id);
}
