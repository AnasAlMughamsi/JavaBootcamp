package com.example.homework.service;

import com.example.homework.api.ApiException;
import com.example.homework.dto.TeacherAddressDTO;
import com.example.homework.model.Address;
import com.example.homework.model.Teacher;
import com.example.homework.repository.AddressRepository;
import com.example.homework.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public void addTeacherAddress(TeacherAddressDTO td) {
        Teacher teacher = teacherRepository.findTeacherById(td.getTeacher_id());
        if(teacher == null) {
            throw new ApiException("Can't find teacher id");
        }
        Address address = new Address(null, td.getArea(), td.getStreet(), td.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(Integer id, Address updateAddress) {
        Address address = addressRepository.findAddressById(id);
        if(address == null) {
            throw new ApiException("Address not found");
        }
        updateAddress.setId(id);
        addressRepository.save(updateAddress);
    }

    public void deleteAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if(address == null) {
            throw new ApiException("Address not found");
        }
        addressRepository.delete(address);
    }



}
