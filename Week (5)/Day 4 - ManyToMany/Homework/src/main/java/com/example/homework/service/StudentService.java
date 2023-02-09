package com.example.homework.service;


import com.example.homework.api.ApiException;
import com.example.homework.model.Course;
import com.example.homework.model.Student;
import com.example.homework.repository.CourseRepository;
import com.example.homework.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student updateStudent) {
        Student student = studentRepository.findStudentById(id);
        if(student == null) {
            throw new ApiException("Can't find the student id!");
        }

        updateStudent.setId(id);
        studentRepository.save(updateStudent);
    }

    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if(student == null) {
            throw new ApiException("Can't find the student id!");
        }
    }

    // student change major

    public void assignStudentToCourse(Integer student_id, Integer course_id) {
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);
        if(student == null || course == null)  {
            throw new ApiException("Can't find the student id or course id!");
        }

        student.getCourseList().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }


    public void changeMajor(Integer student_id, String major) {
        Student student = studentRepository.findStudentById(student_id);
        if(student == null) {
            throw new ApiException("Can't find the student id!");
        }
//        String newMajor = "Computer Science";
        student.getCourseList().clear();
        student.setMajor(major);

    }

}
