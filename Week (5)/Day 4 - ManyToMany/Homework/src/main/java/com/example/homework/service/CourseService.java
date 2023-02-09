package com.example.homework.service;

import com.example.homework.api.ApiException;
import com.example.homework.model.Course;
import com.example.homework.model.Student;
import com.example.homework.model.Teacher;
import com.example.homework.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherService teacherService;

    public String getCourseName(Integer id) {
        Course course = courseRepository.findCourseById(id);
        return course.getCourseName();
    }
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course updateCourse) {
        Course course = courseRepository.findCourseById(id);
        if(course == null) {
            throw new ApiException("course not found!");
        }
        updateCourse.setId(id);
        courseRepository.save(updateCourse);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if(course == null) {
            throw new ApiException("Teacher not found");
        }
        courseRepository.delete(course);
    }

    // method to return tacher name of the course

    public Teacher getTeacherCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if(course == null) {
            throw new ApiException("Course not found");
        }
//        courseRepository.save(course);
//        course.getTeacher();
        return course.getTeacher();
    }

    // return students who taking this course
    public Course studentsCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if(course == null) {
            throw new ApiException("Course not found");
        }
        if(course.getStudents().isEmpty()) {
            throw new ApiException("Course has no students");
        }
        return course;
    }

}
