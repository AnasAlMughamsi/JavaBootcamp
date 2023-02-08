package com.example.homework.controller;

import com.example.homework.dto.TeacherAddressDTO;
import com.example.homework.model.Address;
import com.example.homework.model.Course;
import com.example.homework.model.Teacher;
import com.example.homework.service.AddressService;
import com.example.homework.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
//
//    @GetMapping("/get")
//    public ResponseEntity getAddresses() {
//        List<Address> addresses = addressService.getAddress();
//        return ResponseEntity.status(200).body(addresses);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity addAddress(@Valid @RequestBody TeacherAddressDTO teacherAddressDTO) {
//        addressService.addTeacherAddress(teacherAddressDTO);
//        return ResponseEntity.status(200).body("Address added!");
//    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity updateAddress(@PathVariable Integer id, @Valid @RequestBody Address updateAddress) {
//        addressService.updateAddress(id, updateAddress);
//        return ResponseEntity.status(200).body("Address updated!");
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteAddress(@PathVariable Integer id) {
//        addressService.deleteAddress(id);
//        return ResponseEntity.status(200).body("Address deleted!!");
//    }
//



}
