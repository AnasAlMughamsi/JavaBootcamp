package com.example.homework.controller;


import com.example.homework.model.Student;
import com.example.homework.model.Teacher;
import com.example.homework.service.CourseService;
import com.example.homework.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity getStudents() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @Valid @RequestBody Student updateStudent) {
        studentService.updateStudent(id, updateStudent);
        return ResponseEntity.status(200).body("Student updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted!!");
    }

    @PostMapping("/{student_id}/student/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id, @PathVariable Integer course_id) {
        studentService.assignStudentToCourse(student_id, course_id);
        return ResponseEntity.status(200).body("Student to course: " + courseService.getCourseName(course_id));
    }

    @PostMapping("/change-major/{id}/{newMajor}")
    public ResponseEntity changeMajor(@PathVariable Integer id, @PathVariable String newMajor) {
        studentService.changeMajor(id, newMajor);
        return ResponseEntity.status(200).body("Major changed!");
    }
}
