package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;


@SpringBootApplication
@ContextConfiguration(locations = {"classpath:spring-ws-servlet.xml"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run( DemoApplication.class, args );
    }
}
