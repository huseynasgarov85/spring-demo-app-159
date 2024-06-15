package com.example.springdemoapp159;

import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class SpringDemoApp159Application{

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApp159Application.class, args);
    }
}
