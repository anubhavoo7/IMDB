package com.example.IMDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.example.IMDB")
public class SpringbootBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootBackendApplication.class, args);
    }
}
