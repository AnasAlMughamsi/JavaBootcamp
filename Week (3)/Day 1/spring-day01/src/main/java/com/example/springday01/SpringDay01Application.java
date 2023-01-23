package com.example.springday01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringDay01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDay01Application.class, args);

        System.out.println("Hello World!!!");
    }

}
