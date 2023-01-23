package com.example.springday01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class MainController {


    @RequestMapping(method = RequestMethod.GET, path = "/date")
    public Date getDate() {
        return new Date();
    }

    @GetMapping("/names")
    public ArrayList getNames() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Nasibah");
        arrayList.add("Anas");

        return arrayList;
    }

    @GetMapping("/hello")
    public String name() {
        return "<h1>Hello World</h1>";
    }
}
