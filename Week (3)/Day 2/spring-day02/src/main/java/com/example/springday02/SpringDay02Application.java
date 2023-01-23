package com.example.springday02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDay02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDay02Application.class, args);
    }

    @Bean
    @Qualifier("1")
    public String getMessage1(MainController mainController) {
        System.out.println("hey from message1");
        return "1";
    }

    @Bean
    @Qualifier("2")
    public String getMessage2(@Qualifier("3") String data) {
        System.out.println("hey from message2 ");
        return data;
    }

    @Bean
    @Qualifier("3")
    public String getMessage3() {
        System.out.println("hey from message3 ");
        return "3";
    }

}
