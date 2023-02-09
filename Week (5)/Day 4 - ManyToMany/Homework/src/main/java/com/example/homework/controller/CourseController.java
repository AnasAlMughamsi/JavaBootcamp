package com.example.homework.controller;

import com.example.homework.model.Course;
import com.example.homework.model.Student;
import com.example.homework.model.Teacher;
import com.example.homework.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourse() {
        List<Course> courses = courseService.getCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @Valid @RequestBody Course updateCourse) {
        courseService.updateCourse(id, updateCourse);
        return ResponseEntity.status(200).body("Course updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted!!");
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity getTeacherCourse(@PathVariable Integer id) {
        Teacher teacher = courseService.getTeacherCourse(id);
        return ResponseEntity.status(200).body(teacher.getName());
    }

    // endpoint: return students who take id course
    @GetMapping("/students/{course_id}")
    public ResponseEntity getStudentsCourse(@PathVariable Integer course_id) {
        Course course = courseService.studentsCourse(course_id);
        return ResponseEntity.status(200).body(course.getStudents());
    }
}
