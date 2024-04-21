package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    //ctrl + o
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return  studentRepository.save ( student );

    }

    @Override
    public List<Student> GetAllStudents() {
        return studentRepository.findAll ();
    }
    @Override
    public Student updateStudent(int id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAddress(updatedStudent.getAddress());
            return studentRepository.save(existingStudent);
        }
        return null; // or throw an exception indicating student not found
    }
    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}

