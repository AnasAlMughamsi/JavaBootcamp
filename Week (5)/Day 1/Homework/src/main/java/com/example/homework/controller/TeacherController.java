package com.example.homework.controller;

import com.example.homework.dto.TeacherAddressDTO;
import com.example.homework.model.Teacher;
import com.example.homework.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getTeachers() {
        List<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher addTeacher) {
        teacherService.addTeacher(addTeacher);
        return ResponseEntity.status(200).body("Teacher added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher updateTeacher) {
        teacherService.updateTeacher(id, updateTeacher);
        return ResponseEntity.status(200).body("teacher updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted!!");
    }

    @PostMapping("/add-taecher-address/")
    public ResponseEntity addAddressTeacher(@Valid @RequestBody TeacherAddressDTO td) {
        teacherService.addTeacherAddress(td);
        return ResponseEntity.status(200).body("Teacher Address added!");
    }

    // update teacher address here
    // delete teacher address here

    @PostMapping("/{teacher_id}/course/{course_id}")
    public ResponseEntity assignTeacherCourse(@PathVariable Integer teacher_id, @PathVariable Integer course_id) {
        teacherService.assignTeacherCourse(teacher_id, course_id);
        return ResponseEntity.status(200).body("Teacher assign to course!");

    }

}
