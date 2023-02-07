package com.example.homework.service;

import com.example.homework.api.ApiException;
import com.example.homework.dto.TeacherAddressDTO;
import com.example.homework.model.Address;
import com.example.homework.model.Course;
import com.example.homework.model.Teacher;
import com.example.homework.repository.AddressRepository;
import com.example.homework.repository.CourseRepository;
import com.example.homework.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
    private final CourseRepository courseRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher updateTeacher) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher == null) {
            throw new ApiException("Teacher not found!");
        }
        updateTeacher.setId(id);
        teacherRepository.save(updateTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher == null) {
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    public void addTeacherAddress(TeacherAddressDTO td) {
        Teacher teacher = teacherRepository.findTeacherById(td.getTeacher_id());
        if(teacher == null) {
            throw new ApiException("Can't find teacher id");
        }
        Address address = new Address(null, td.getArea(), td.getStreet(), td.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateTeacherAddress(TeacherAddressDTO updateDt) {
        Address address = addressRepository.findAddressById(updateDt.getTeacher_id());
        if(address == null) {
            throw new ApiException("Can't find the address");
        }
        address.setArea(updateDt.getArea());
        address.setStreet(updateDt.getStreet());
        address.setBuildingNumber(updateDt.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteTeacherAddress(TeacherAddressDTO dt) {
        Address address = addressRepository.findAddressById(dt.getTeacher_id());
        if(address == null) {
            throw new ApiException("Can't find the address");
        }
        addressRepository.save(address);
    }


    public void assignTeacherCourse(Integer teacher_id, Integer course_id) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);

        if(teacher == null || course == null) {
            throw new ApiException("Can't teacher or the course");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }
}
