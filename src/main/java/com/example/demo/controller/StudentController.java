package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    //Ajouter
    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent ( student );
        return "New student is added";
    }
    //Afficher
    @GetMapping("/gettall")
    public List<Student> GetAllStudent(){
        return studentService.GetAllStudents ();
    }
    // Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") int id, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudent(id, updatedStudent);
        if (student != null) {
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }


}
